package com.lucascorp.smetilender.api.item.model;


import com.lucascorp.smetilender.api.item.enumeration.CategoryItemEnum;
import com.lucascorp.smetilender.api.item.enumeration.StatusItemEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "items")
@Entity(name = "Item")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryItemEnum category;

    @Nullable
    @Enumerated(EnumType.STRING)
    private StatusItemEnum status;

    private LocalDateTime createDate;

    @Nullable
    private LocalDateTime updateDate;

    @Nullable
    private LocalDateTime deleteDate;

    public ItemEntity(ItemRegistrationRequestDto itemRequest) {
        this.name = itemRequest.name();
        this.description = itemRequest.description();
        this.category = itemRequest.category();
        this.status = StatusItemEnum.AVAILABLE;
        this.createDate = LocalDateTime.now();
    }

    public void updateData(ItemUpdateRequestDto itemRequest) {
        if (itemRequest.name() != null) {
            this.name = itemRequest.name();
        }
        if (itemRequest.description() != null) {
            this.description = itemRequest.description();
        }
        if (itemRequest.category() != null) {
            this.category = itemRequest.category();
        }
        this.updateDate = LocalDateTime.now();
    }

    public void delete() {
        this.deleteDate = LocalDateTime.now();
        this.status = StatusItemEnum.NOT_AVAILABLE;
    }
}
