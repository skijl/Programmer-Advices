package com.onlineshop.productservice.category.static_object;

import com.commercetools.api.models.category.*;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.history.models.common.Reference;
import com.onlineshop.productservice.category.dto.response.CategoryDtoResponse;

import java.util.ArrayList;
import java.util.List;

public class StaticCategory {
    public static CategoryDtoResponse categoryDtoResponse() {
        CategoryDtoResponse mock = new CategoryDtoResponse();
        mock.setId("id");
        mock.setVersion(1L);
        mock.setName(LocalizedString.ofEnglish("Mock Category"));
        mock.setSlug(LocalizedString.ofEnglish("mock-category"));
        mock.setDescription(LocalizedString.ofEnglish("Mock category description"));
        mock.setParent(new CategoryReferenceImpl());
        List<CategoryReference> ancestors = new ArrayList<>();
        ancestors.add(new CategoryReferenceImpl());
        mock.setAncestors(ancestors);
        mock.setOrderHint("0.1");
        return mock;
    }

    public static Category category() {
        Category category = new CategoryImpl();
        category.setId("id");
        category.setVersion(1L);
        category.setName(LocalizedString.ofEnglish("Mock Category"));
        category.setSlug(LocalizedString.ofEnglish("mock-category"));
        category.setDescription(LocalizedString.ofEnglish("Mock category description"));
        category.setParent(new CategoryReferenceImpl());
        List<CategoryReference> ancestors = new ArrayList<>();
        ancestors.add(new CategoryReferenceImpl());
        category.setAncestors(ancestors);
        category.setOrderHint("0.1");
        return category;
    }
}
