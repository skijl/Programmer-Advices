package com.onlineshop.productservice.product.static_object;

import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.product.*;
import com.commercetools.api.models.product_type.ProductTypeReference;
import com.commercetools.api.models.product_type.ProductTypeReferenceImpl;
import com.onlineshop.productservice.product.dto.response.ProductGetAllDtoResponse;
import com.onlineshop.productservice.product.dto.response.ProductGetDtoResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StaticProduct {
    public static ProductGetDtoResponse productGetDtoResponse() {
        ProductGetDtoResponse response = new ProductGetDtoResponse();

        response.setId("testProductId");
        response.setVersion(1L);
        LocalizedString name = LocalizedString.of(new Locale("en-US"), "Test Product");
        response.setName(name);
        LocalizedString slug = LocalizedString.of(new Locale("en-US"), "test-product");
        response.setSlug(slug);
        LocalizedString description = LocalizedString.of(new Locale("en-US"), "This is a test product");
        response.setDescription(description);
        ProductVariant masterVariant = ProductVariant.of();
        response.setMasterVariant(masterVariant);
        List<ProductVariant> variants = new ArrayList<>();
        variants.add(masterVariant);
        response.setVariants(variants);
        ProductTypeReference productType = new ProductTypeReferenceImpl();
        response.setProductType(productType);

        return response;
    }

    public static Product product() {
        Product product = new ProductImpl();
        product.setId("id");
        product.setVersion(1L);

        product.setMasterData(new ProductCatalogDataImpl());
        product.getMasterData().setCurrent(new ProductDataImpl());

        LocalizedString name = LocalizedString.of(new Locale("en-US"), "Test Product");
        product.getMasterData().getCurrent().setName(name);

        product.setMasterData(new ProductCatalogDataImpl());
        product.getMasterData().setCurrent(new ProductDataImpl());

        LocalizedString slug = LocalizedString.of(new Locale("en-US"), "test-product");
        product.getMasterData().getCurrent().setSlug(slug);

        LocalizedString description = LocalizedString.of(new Locale("en-US"), "This is a test product");
        product.getMasterData().getCurrent().setDescription(description);

        ProductVariant masterVariant = ProductVariant.of();
        product.getMasterData().getCurrent().setMasterVariant(masterVariant);

        List<ProductVariant> variants = new ArrayList<>();
        variants.add(masterVariant);
        product.getMasterData().getCurrent().setVariants(variants);

        ProductTypeReference productType = new ProductTypeReferenceImpl();
        product.setProductType(productType);

        return product;
    }

    public static ProductGetAllDtoResponse productGetAllDtoResponse() {
        ProductGetAllDtoResponse response = new ProductGetAllDtoResponse();
        response.setId("testProductId");
        response.setVersion(1L);

        LocalizedString name = LocalizedString.of(new Locale("en-US"), "Test Product");
        response.setName(name);

        LocalizedString slug = LocalizedString.of(new Locale("en-US"), "test-product");
        response.setSlug(slug);

        LocalizedString description = LocalizedString.of(new Locale("en-US"), "This is a test product");
        response.setDescription(description);

        response.setImages(new ArrayList<>());
        response.setPrices(new ArrayList<>());

        return response;
    }
}
