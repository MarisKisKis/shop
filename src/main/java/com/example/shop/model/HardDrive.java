package com.example.shop.model;

import com.example.shop.model.enums.LaptopSize;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "hardDrives")
public class HardDrive extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private int volumeValue;
    public String measureUnit;

    public HardDrive(String serialNumber, String producer, float price, long amountAtStock, int volumeValue, String measureUnit) {
        super(serialNumber, producer, price, amountAtStock);
        this.volumeValue = volumeValue;
        this.measureUnit = measureUnit;
    }
}
