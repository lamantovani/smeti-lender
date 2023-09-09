package com.lucascorp.smetilender.domain.api.item.model;

import com.lucascorp.smetilender.domain.api.item.enumeration.CategoryItemEnum;
import jakarta.validation.constraints.NotNull;

public record ItemUpdateRequestDto(
        @NotNull
        String name,
        @NotNull
        String description,
        @NotNull
        CategoryItemEnum category) {
}