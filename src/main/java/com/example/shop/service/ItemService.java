package com.example.shop.service;

import com.example.shop.model.DesktopPC;
import com.example.shop.model.HardDrive;
import com.example.shop.model.Laptop;
import com.example.shop.model.Monitor;
import com.example.shop.model.dto.ItemDto;

import java.util.List;

public interface ItemService {

    void save(ItemDto itemDto);

    List<ItemDto> getAllItemsByType(String itemType);

    HardDrive getHardDrive(long id);

    DesktopPC getPCById(long id);

    Laptop getLaptop(long id);

    Monitor getMonitor(long id);

    ItemDto updateItem(long id, ItemDto itemDto, String itemType);
}
