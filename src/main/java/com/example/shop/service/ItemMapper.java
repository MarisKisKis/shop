package com.example.shop.service;

import com.example.shop.model.*;
import com.example.shop.model.dto.ItemDto;

public class ItemMapper {

    public static DesktopPC toDesktopPC (ItemDto itemDto, long amount) {
        return new DesktopPC(itemDto.getSerialNumber(), itemDto.getProducer(), itemDto.getPrice(), amount,
                itemDto.getDesktopPCDto().getFormFactor());
    }

    public static HardDrive toHardDrive (ItemDto itemDto, long amount) {
        return new HardDrive(itemDto.getSerialNumber(), itemDto.getProducer(), itemDto.getPrice(), amount,
                itemDto.getHardDriveDto().getVolumeValue(), itemDto.getHardDriveDto().getMeasureUnit());
    }

    public static Laptop toLaptop (ItemDto itemDto, long amount) {
        return new Laptop(itemDto.getSerialNumber(), itemDto.getProducer(), itemDto.getPrice(), amount,
                itemDto.getLaptopDto().getSize());
    }

    public static ItemDto toItemDtoFromPc(DesktopPC pc) {
        return ItemDto.builder()
                .id(pc.getId())
                .serialNumber(pc.getSerialNumber())
                .producer(pc.getProducer())
                .price(pc.getPrice())
                .amountAtStock(String.valueOf(pc.getAmountAtStock()))
                .desktopPCDto(ItemDto.DesktopPCDto.builder()
                        .formFactor(pc.getFormFactor()).build())
                .build();
    }

    public static ItemDto toItemDtoFromHardDrive(HardDrive hardDrive) {
        return ItemDto.builder()
                .id(hardDrive.getId())
                .serialNumber(hardDrive.getSerialNumber())
                .producer(hardDrive.getProducer())
                .price(hardDrive.getPrice())
                .amountAtStock(String.valueOf(hardDrive.getAmountAtStock()))
                .hardDriveDto(ItemDto.HardDriveDto.builder()
                        .volumeValue(hardDrive.getVolumeValue())
                        .measureUnit(hardDrive.getMeasureUnit())
                        .build())
                .build();
    }

    public static ItemDto toItemDtoFromLaptop(Laptop laptop) {
        return ItemDto.builder()
                .id(laptop.getId())
                .serialNumber(laptop.getSerialNumber())
                .producer(laptop.getProducer())
                .price(laptop.getPrice())
                .amountAtStock(String.valueOf(laptop.getAmountAtStock()))
                .laptopDto(ItemDto.LaptopDto.builder()
                        .size(laptop.getSize())
                        .build())
                .build();
    }

    public static ItemDto toItemDtoFromMonitor(Monitor monitor) {
        return ItemDto.builder()
                .id(monitor.getId())
                .serialNumber(monitor.getSerialNumber())
                .producer(monitor.getProducer())
                .price(monitor.getPrice())
                .amountAtStock(String.valueOf(monitor.getAmountAtStock()))
                .monitorDto(ItemDto.MonitorDto.builder()
                        .diagonalValue(monitor.getDiagonalValue())
                        .measureUnit(monitor.getMeasureUnit())
                        .build())
                .build();
    }
}
