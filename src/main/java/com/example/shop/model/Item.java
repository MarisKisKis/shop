package com.example.shop.model;

import com.example.shop.model.enums.ItemType;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item {
    @NotBlank
    private String serialNumber;
    @NotBlank
    private String producer;
    @NotBlank
    private float price;
    @NotBlank
    private long amountAtStock;
    @NotBlank
    private ItemType type;
}
