package com.lucascorp.smetilender.api.item.model;


import com.lucascorp.smetilender.api.item.enumeration.CategoryItemEnum;
import com.lucascorp.smetilender.api.item.enumeration.StatusItemEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class ItemEntity implements Item{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String description;

    @Enumerated(EnumType.STRING)
    private CategoryItemEnum category;

    @NotNull
    @Enumerated(EnumType.STRING)
    private StatusItemEnum status;

    @NotNull
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

    @Override
    public void update(ItemUpdateRequestDto itemRequest) {
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

    @Override
    public void delete() {
        this.deleteDate = LocalDateTime.now();
        this.status = StatusItemEnum.NOT_AVAILABLE;
    }

    @Override
    public void toLoan() {

    }

    @Override
    public void giveBack() {

    }
}
