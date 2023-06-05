package com.example.shop.model;

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
@Builder
@Table(name = "monitors")
public class Monitor extends Item {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private float diagonalValue;
    public String measureUnit;

    @Builder
    public Monitor(String serialNumber, String producer, float price, long amountAtStock, float diagonalValue, String measureUnit) {
        super(serialNumber, producer, price, amountAtStock);
        this.diagonalValue = diagonalValue;
        this.measureUnit = measureUnit;
    }
}
