package com.lucascorp.smetilender.domain.api.item.model;

import com.lucascorp.smetilender.domain.api.item.enumeration.CategoryItemEnum;

public record ItemRegistrationRequestDto(String name, String description, CategoryItemEnum category) {
}
