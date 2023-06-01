package com.example.shop.model;

import com.example.shop.model.enums.FormFactor;
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
@Table(name = "desktopPCs")
public class DesktopPC extends Item{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank
    private FormFactor formFactor;

    public DesktopPC(String serialNumber, String producer, float price, FormFactor formFactor) {
    }
}
