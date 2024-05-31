package com.onlineshop.productservice.category.controller;

import com.commercetools.api.models.category.Category;
import com.commercetools.api.models.category.CategoryPagedQueryResponse;
import com.commercetools.api.models.category.CategoryPagedQueryResponseImpl;
import com.onlineshop.productservice.category.dto.mapper.CategoryDtoMapper;
import com.onlineshop.productservice.category.service.CategoryService;
import com.onlineshop.productservice.category.static_object.StaticCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void getAllCategories_Success() throws Exception {
        CategoryPagedQueryResponse categoryResponse = new CategoryPagedQueryResponseImpl();
        categoryResponse.setLimit(20L);
        categoryResponse.setOffset(0L);
        categoryResponse.setTotal(2L);
        Category category = StaticCategory.category();
        categoryResponse.setResults(Collections.singletonList(category));
        Mockito.when(categoryService.getAll(Mockito.anyLong(), Mockito.anyLong())).thenReturn(categoryResponse);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/category")
                        .param("limit", "20")
                        .param("offset", "0")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].id").value("id"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].name.en").value("Mock Category"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.content[0].slug.en").value("mock-category"));
    }
}