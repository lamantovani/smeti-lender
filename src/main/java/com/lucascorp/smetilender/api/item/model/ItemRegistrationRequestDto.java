package com.lucascorp.smetilender.api.item.model;

import com.lucascorp.smetilender.api.item.enumeration.CategoryItemEnum;

public record ItemRegistrationRequestDto(String name, String description, CategoryItemEnum category) {
}
