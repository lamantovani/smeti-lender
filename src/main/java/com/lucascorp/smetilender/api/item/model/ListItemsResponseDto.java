package com.lucascorp.smetilender.api.item.model;

import com.lucascorp.smetilender.api.item.enumeration.CategoryItemEnum;
import com.lucascorp.smetilender.api.item.enumeration.StatusItemEnum;

import java.time.LocalDateTime;

public record ListItemsResponseDto(Long id, String nome, String description, CategoryItemEnum category, StatusItemEnum status, LocalDateTime createDate, LocalDateTime updateDate) {
    public ListItemsResponseDto(ItemEntity item) {
        this(item.getId(), item.getName(), item.getDescription(), item.getCategory(), item.getStatus(), item.getCreateDate(), item.getUpdateDate());
    }
}
