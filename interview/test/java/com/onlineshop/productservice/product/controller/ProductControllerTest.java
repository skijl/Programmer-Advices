package com.onlineshop.productservice.product.controller;

import com.commercetools.api.models.product.Product;
import com.commercetools.api.models.product.ProductPagedQueryResponse;
import com.commercetools.api.models.product.ProductPagedQueryResponseImpl;
import com.onlineshop.productservice.product.service.ProductService;
import com.onlineshop.productservice.product.static_object.StaticProduct;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    void getAllProducts_Success() throws Exception {
        ProductPagedQueryResponse productResponse = new ProductPagedQueryResponseImpl();
        productResponse.setLimit(20L);
        productResponse.setOffset(0L);
        productResponse.setTotal(2L);
        Product product = StaticProduct.product();
        productResponse.setResults(Collections.singletonList(product));
        Mockito.when(productService.getAll(Mockito.anyLong(), Mockito.anyLong())).thenReturn(productResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/product")
                        .param("limit", "20")
                        .param("offset", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].description").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].slug").exists());
    }

    @Test
    void getProductsByCategoryId_Success() throws Exception {
        ProductPagedQueryResponse productResponse = new ProductPagedQueryResponseImpl();
        productResponse.setLimit(20L);
        productResponse.setOffset(0L);
        productResponse.setTotal(2L);
        Product product = StaticProduct.product();
        productResponse.setResults(Collections.singletonList(product));
        Mockito.when(productService.getByCategoryId(Mockito.anyString(),Mockito.anyLong(), Mockito.anyLong())).thenReturn(productResponse);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/product/category/id")
                        .param("limit", "20")
                        .param("offset", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].slug").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].description").exists());
    }

    @Test
    void getProductById_Success() throws Exception {
        Product product = StaticProduct.product();
        Mockito.when(productService.getById(Mockito.anyString())).thenReturn(product);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/product/id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.version").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name.en-US").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.slug").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").exists());
        String jsonResponse = result.andReturn().getResponse().getContentAsString();
        System.out.println("JSON Response: " + jsonResponse);
    }

    @Test
    void getProductInfoById_Success() throws Exception {
        Product product = StaticProduct.product();
        Mockito.when(productService.getById(Mockito.anyString())).thenReturn(product);
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.get("/api/product/info/id")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.version").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.masterData").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.masterData.current").exists());
        String jsonResponse = result.andReturn().getResponse().getContentAsString();
        System.out.println("JSON Response: " + jsonResponse);
    }
}


