package com.lucascorp.smetilender.api.item.controller;

import com.lucascorp.smetilender.api.item.model.*;
import com.lucascorp.smetilender.api.item.repository.ItemRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * Serviço para cadastro de itens
     */
    @PostMapping
    @Transactional
    public ResponseEntity registration(@RequestBody @Valid ItemRegistrationRequestDto itemRequest, UriComponentsBuilder uriBuilder) {
        var item = new ItemEntity(itemRequest);
        itemRepository.save(item);
        var uri = uriBuilder.path("/item/detail/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemRegistrationResponseDto(item.getId(), item.getName(), "Item registrado com sucesso"));
    }

    /**
     * @return all itens
     */
    @GetMapping
    public ResponseEntity getAllItems() {
        var items = itemRepository.findAll().stream().map(ListItemsResponseDto::new);
        return ResponseEntity.ok(items);
    }

    /**
     * Serviço para lista todos os itens cadastrados
     *
     * @return: Lista de itens
     */
    @GetMapping("/by_name/{name}")
    public ResponseEntity searchItemsByName(@PathVariable String name) {
        var items = itemRepository.findItemsByName(name).stream().map(ListItemsResponseDto::new);
        return ResponseEntity.ok(items);
    }

    /**
     * @param startDate  - init date for criation date, ex: 21/04/2020
     * @param finishDate - finish date for friation date, ex: 10/10/2023
     */
    @GetMapping("/creation_date/{startDate}/{finishDate}")
    public ResponseEntity searchItemsByCreationDate(@PathVariable Date startDate, @PathVariable Date finishDate) {
        var items = itemRepository.findItemsByCreateDateBetween(startDate, finishDate).stream().map(ListItemsResponseDto::new);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity update(@PathVariable Long id, @RequestBody @Valid ItemUpdateRequestDto itemRequest, UriComponentsBuilder uriBuilder) {
        var item = itemRepository.getReferenceById(id);
        item.update(itemRequest);
        var uri = uriBuilder.path("/item/detail/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemDedatilResponseDto(item));
    }

    /**
     * @param id - of item detail
     * @return - ItemDetailResponseDto
     */
    @GetMapping("/detail/{id}")
    public ResponseEntity itemDetail(@PathVariable Long id) {
        var item = itemRepository.getReferenceById(id);
        return ResponseEntity.ok(new ItemDedatilResponseDto(item));
    }

    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        var item = itemRepository.getReferenceById(id);
        item.delete();
        return ResponseEntity.noContent().build();
    }


}
