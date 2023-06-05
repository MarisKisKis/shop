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
@Table(name = "laptops")
public class Laptop extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "size")
    private int size;

    public Laptop(String serialNumber, String producer, float price, long amountAtStock, int size) {
        super(serialNumber, producer, price, amountAtStock);
        this.size = size;
    }
}
