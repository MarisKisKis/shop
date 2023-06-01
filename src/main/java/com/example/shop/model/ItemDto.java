package com.example.shop.model;

import com.example.shop.model.enums.FormFactor;
import com.example.shop.model.enums.LaptopSize;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@Jacksonized
public class ItemDto {
    @NotBlank
    private String serialNumber;
    @NotBlank
    private String producer;
    @NotBlank
    private float price;
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
        private LaptopSize size;
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

