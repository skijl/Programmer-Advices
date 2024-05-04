# Angular
## Instalation
1. Download Node js (node -v)
2. Install Angular CLI
    npm install -g @angular/cli
## Angular CLI
- Create new app (cmd): 
    1. `ng new <app_name>`
    2. `ng create component <component_name>`
    3. `ng create service <service_name>`
    4. `ng help`
- Change app.config.ts to get a Http:
    export const appConfig: ApplicationConfig = {
        providers: [provideRouter(routes), provideHttpClient()]
    };
- <file_name>.ts for the interfaces (objects to use)
- General api service (inject HttpClient and create request):
```
    constructor(private httpClient: HttpClient) { }

    get<T>(url: string): Observable<T> {
        return this.httpClient.get<T>(url);
    }
```
- Other service (inject apiService and use your object):
```
    constructor(private apiService: ApiService) { }

    getProduct(url: string): Observable<Product[]> {
        return this.apiService.get<Product[]>(url);
    }
```
- In home.component.ts import CommonModule,inject service and call the method:
```
    imports: [ProductComponent, CommonModule]

    constructor(private productService: ProductService){}

    ngOnInit(){
        this.productService.getProduct("http://localhost:8081/api/products").subscribe((product: Product[])=>{
        console.log(product);
        })
    }
```
- In app.component.ts import components:
```
    imports: [RouterOutlet, HeaderComponent, FooterComponent],
```