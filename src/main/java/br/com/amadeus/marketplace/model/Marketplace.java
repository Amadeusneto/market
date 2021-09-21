package br.com.amadeus.marketplace.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Marketplace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double longitude;
    private Double latitude;
    private String sector;
    private String area;
    private String districtCode;
    private String districtName;
    private Long subCityHallCode;
    private String subCityHallName;
    private String region05;
    private String region08;
    private String name;
    private String register;
    private String street;
    private String number;
    private String neighborhood;
    private String reference;
    private Boolean active = true;
}
