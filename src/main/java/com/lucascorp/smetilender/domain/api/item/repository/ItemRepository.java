package com.lucascorp.smetilender.domain.api.item.repository;

import com.lucascorp.smetilender.domain.api.item.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long> {

    public List<ItemEntity> findItemsByName(String name);

    public List<ItemEntity> findItemsByCreateDateBetween(Date startDate, Date finishDate);
}
