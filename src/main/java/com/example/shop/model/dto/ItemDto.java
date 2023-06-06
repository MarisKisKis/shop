package com.example.shop.model.dto;

import com.example.shop.model.enums.FormFactor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@Getter
@Setter
@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDto {
    private long id;
    private String serialNumber;
    private String producer;
    private float price;
    private String amountAtStock;
    private DesktopPCDto desktopPCDto;
    private HardDriveDto hardDriveDto;
    private LaptopDto laptopDto;
    private MonitorDto monitorDto;

    @Getter
    @Setter
    @Builder
    @Jacksonized
    public static class DesktopPCDto {
        private FormFactor formFactor;
    }

    @Getter
    @Setter
    @Builder
    @Jacksonized
    public static class HardDriveDto {
        private int volumeValue;
        public String measureUnit;
    }

    @Getter
    @Setter
    @Builder
    @Jacksonized
    public static class LaptopDto {
        private int size;
    }

    @Getter
    @Setter
    @Builder
    @Jacksonized
    public static class MonitorDto {
        private float diagonalValue;
        public String measureUnit;
    }
}

