package br.com.amadeus.marketplace.controller.impl;

import br.com.amadeus.marketplace.dto.request.FilterMarketplaceRequest;
import br.com.amadeus.marketplace.dto.response.MarketplaceResponse;
import br.com.amadeus.marketplace.mappers.MarketplaceMapper;
import br.com.amadeus.marketplace.model.Marketplace;
import br.com.amadeus.marketplace.service.FindMarketplaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class FindMarketplaceRestController implements MarketplaceController {

    private FindMarketplaceService findMarketplaceService;

    @ApiOperation(value = "Find Marketplace by ID")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Marketplace marketplace = findMarketplaceService.findById(id);
        MarketplaceResponse marketplaceResponse = MarketplaceMapper.INSTANCE.marketplaceEntityToMarketplaceResponse(marketplace);
        return ResponseEntity.ok().body(marketplaceResponse);
    }

    @ApiOperation(value = "Find Marketplace using filters and pagination")
    @GetMapping
    public Page<?> findByFilter(FilterMarketplaceRequest filterMarketplaceRequest, Pageable pageable) {
        return findMarketplaceService.findByFiltersAndPagination(filterMarketplaceRequest, pageable);
    }
}
