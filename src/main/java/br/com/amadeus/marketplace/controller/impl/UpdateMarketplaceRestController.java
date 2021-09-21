package br.com.amadeus.marketplace.controller.impl;

import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import br.com.amadeus.marketplace.dto.response.MarketplaceResponse;
import br.com.amadeus.marketplace.mappers.MarketplaceMapper;
import br.com.amadeus.marketplace.model.Marketplace;
import br.com.amadeus.marketplace.service.UpdateMarketplaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class UpdateMarketplaceRestController implements MarketplaceController {
    private UpdateMarketplaceService updateMarketplaceService;

    @ApiOperation(value = "Update a existing markeplace")
    @PutMapping("/{id}")
    public ResponseEntity<?> saveCommunication(@PathVariable Long id, @RequestBody @Valid MarketplaceRequest marketplaceRequest) {
        Marketplace marketplace = updateMarketplaceService.save(id, MarketplaceMapper.INSTANCE.createMarketplaceRequestToMarketplaceEntity(marketplaceRequest));
        MarketplaceResponse marketplaceResponse = MarketplaceMapper.INSTANCE.marketplaceEntityToMarketplaceResponse(marketplace);
        return ResponseEntity.ok().body(marketplaceResponse);
    }
}
