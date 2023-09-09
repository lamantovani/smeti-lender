package com.lucascorp.smetilender.api.item.model;

import com.lucascorp.smetilender.api.item.enumeration.CategoryItemEnum;
import com.lucascorp.smetilender.api.item.enumeration.StatusItemEnum;

import java.time.LocalDateTime;

public record ItemDedatilResponseDto(Long id, String name, String description, CategoryItemEnum category,
                                     StatusItemEnum status, LocalDateTime createDate, LocalDateTime updateDate) {
    public ItemDedatilResponseDto(ItemEntity item) {
        this(item.getId(), item.getName(), item.getDescription(), item.getCategory(), item.getStatus(), item.getCreateDate(), item.getUpdateDate());
    }
}
