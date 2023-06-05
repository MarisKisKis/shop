package com.example.shop.controller;

import com.example.shop.model.DesktopPC;
import com.example.shop.model.HardDrive;
import com.example.shop.model.Laptop;
import com.example.shop.model.Monitor;
import com.example.shop.model.dto.ItemDto;
import com.example.shop.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/items")
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<ItemDto> getAllItemsByType(@RequestParam("type") String itemType) {
        log.trace("Получаем товар с выбранным типом {}", itemType);
        return itemService.getAllItemsByType(itemType);
    }

    @GetMapping("/desktopPCs/{id}")
    public DesktopPC getPCById(@PathVariable long id) {
        log.trace("Получаем персональный компьтер с id {}", id);
        return itemService.getPCById(id);
    }

    @GetMapping("/hardDrives/{id}")
    public HardDrive getHardDriveById(@PathVariable long id) {
        log.trace("Получаем жесткий диск с id {}", id);
        return itemService.getHardDrive(id);
    }

    @GetMapping("/laptops/{id}")
    public Laptop getLaptopById(@PathVariable long id) {
        log.trace("Получаем ноутбук с id {}", id);
        return itemService.getLaptop(id);
    }

    @GetMapping("/monitors/{id}")
    public Monitor getMonitorById(@PathVariable long id) {
        log.trace("Получаем монитор с id {}", id);
        return itemService.getMonitor(id);
    }

    @PostMapping
    public void createItem(@RequestBody ItemDto itemDto) {
        itemService.save(itemDto);
        log.trace("Товар добавлен");
    }

    @PatchMapping
    public ItemDto updateItem(@RequestParam String itemType, @RequestParam long id, @RequestBody ItemDto itemDto) {
        log.trace("Обновляем товар типа {} с id {}", itemType, id);
        return itemService.updateItem(id, itemDto, itemType);
    }
}
