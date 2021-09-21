package br.com.amadeus.marketplace.dto.request;

import lombok.Data;

@Data
public class FilterMarketplaceRequest {
    private String district;
    private String region;
    private String name;
    private String neighborhood;
}
