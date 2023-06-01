package com.example.shop.service;

import com.example.shop.model.DesktopPC;
import com.example.shop.model.ItemDto;

public class ItemMapper {

    public static DesktopPC ToDesktopPC (ItemDto itemDto) {
        return new DesktopPC(itemDto.getSerialNumber(), itemDto.getProducer(), itemDto.getPrice(),
                itemDto.getDesktopPCDto().getFormFactor());
    }
}
