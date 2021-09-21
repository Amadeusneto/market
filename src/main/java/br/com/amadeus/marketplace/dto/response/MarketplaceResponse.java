package br.com.amadeus.marketplace.dto.response;

import lombok.Data;

@Data
public class MarketplaceResponse {
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
}
