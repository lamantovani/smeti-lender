package com.lucascorp.smetilender.api.item.model;

public interface Item {

    void update(ItemUpdateRequestDto itemRequest);
    void delete();
    void lend();
    void giveBack();
}
