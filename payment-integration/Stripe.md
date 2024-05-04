# Stripe
https://youtu.be/kakuRkFhW3M?si=KySootcnQB9fVuWY
- Charge users
- Create subscriptions  
## application.yml
```
# can be any / no configs really needed, but it's a good practice to store such a data safe
api:
  stripe:
    publisher-key: ${STRIPE_PUBLISHER_API_KEY:your_stripe_publisher_api_key}
    secret-key: ${STRIPE_SECRET_API_KEY:your_stripe_secret_api_key}
```
## pom.xml
```
<dependency>
    <groupId>com.stripe</groupId>
    <artifactId>stripe-java</artifactId>
    <version>25.1.0</version>
</dependency>
```
## How to use?
### 1. Generate token:
```
@Data
public class StripeTokenDtoRequest {
    @NotBlank(message = "Card number is required")
    @CreditCardNumber(message = "Invalid card number")
    private String cardNumber;

    @NotBlank(message = "Expiration month is required")
    @Pattern(regexp = "^0[1-9]|1[0-2]", message = "Invalid Expiration Month")
    private String expMonth;

    @NotBlank(message = "Expiration year is required")
    @Pattern(regexp = "\\d{2}", message = "Invalid Expiration Year")
    private String expYear;

    @NotBlank(message = "CVC is required")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVC")
    private String cvc;

    @NotBlank(message = "Username is required")
    private String username;
}

@Data
public class StripeTokenModel {
    private String cardNumber;
    private String expMonth;
    private String expDate;
    private String cvc;
    private String token;
    private String username;
    private Boolean success;
}

@Service
@Slf4j
public class StripeTokenServiceImpl implements StripeTokenService {

    @Value("${api.stripe.publisher-key}")
    private String stripePublisherApiKey;

    @Override
    public StripeTokenModel createCardToken(StripeTokenModel model){
        Stripe.apiKey = stripePublisherApiKey;
        try{
            Map<String, Object> card = new HashMap<>();
            card.put("number", model.getCardNumber());
            card.put("exp_month", model.getExpMonth());
            card.put("exp_year", model.getExpDate());
            card.put("cvc", model.getCvc());
            Map<String, Object> params = new HashMap<>();
            params.put("card", card);
            Token token = Token.create(params);
            if(token!=null && token.getId()!=null){
                model.setSuccess(true);
                model.setToken(token.getId());
            }
            return model;
        }catch (Exception e){
            log.error("StripeToken create token: {}", e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
```
### 2. Charge:
```
@Data
public class StripeChargeDtoRequest {
    @NotBlank(message = "Username is required")
    private String username;
    @NotBlank(message = "Stripe Token is required")
    @NotNull(message = "Stripe Token is required")
    private String stripeToken;

    @NotNull(message = "Amount is required")
    @Positive(message = "Invalid amount")
    private Double amount;

    private Map<String,Object> additionalInfo = new HashMap<>();

}

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StripeChargeModel {
    private String stripeToken;
    private String username;
    private Double amount;
    private Boolean success;
    private String message;
    private String chargeId;
    private Map<String,Object> additionalInfo = new HashMap<>();
}

@Service
@Slf4j
public class StripeChargeServiceImpl implements StripeChargeService {
    @Value("${api.stripe.secret-key}")
    private String stripeSecretApiKey;

    @Override
    public StripeChargeModel charge(StripeChargeModel chargeModel) {
        Stripe.apiKey = stripeSecretApiKey;
        try {
            chargeModel.setSuccess(false);
            Map<String, Object> chargeParams = new HashMap<>();
            chargeParams.put("amount", (int) (chargeModel.getAmount() * 100));
            chargeParams.put("currency", "PLN");
            chargeParams.put("description", "Payment for order id: " + chargeModel.getAdditionalInfo().getOrDefault("ID_TAG", "N/A"));
            chargeParams.put("source", chargeModel.getStripeToken());
            Map<String, Object> metaData = new HashMap<>();
            metaData.put("id", chargeModel.getChargeId());
            metaData.putAll(chargeModel.getAdditionalInfo());
            chargeParams.put("metadata", metaData);
            Charge charge = Charge.create(chargeParams);
            chargeModel.setMessage(charge.getOutcome().getSellerMessage());
            if (charge.getPaid()) {
                chargeModel.setChargeId(charge.getId());
                chargeModel.setSuccess(true);
            }
            return chargeModel;
        } catch (StripeException e) {
            log.error("StripeCharge charge", e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
```