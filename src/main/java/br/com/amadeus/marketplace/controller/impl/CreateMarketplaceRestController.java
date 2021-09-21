package br.com.amadeus.marketplace.controller.impl;

import br.com.amadeus.marketplace.dto.response.MarketplaceResponse;
import br.com.amadeus.marketplace.mappers.MarketplaceMapper;
import br.com.amadeus.marketplace.model.Marketplace;
import br.com.amadeus.marketplace.service.CreateMarketplaceService;
import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@AllArgsConstructor
public class CreateMarketplaceRestController implements MarketplaceController {
    private CreateMarketplaceService createMarketplaceService;

    @ApiOperation(value = "Save a new marketplace")
    @PostMapping
    public ResponseEntity<?> saveCommunication(@RequestBody @Valid MarketplaceRequest marketplaceRequest) {
        Marketplace marketplace = createMarketplaceService.save(MarketplaceMapper.INSTANCE.createMarketplaceRequestToMarketplaceEntity(marketplaceRequest));
        MarketplaceResponse marketplaceResponse = MarketplaceMapper.INSTANCE.marketplaceEntityToMarketplaceResponse(marketplace);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(marketplaceResponse.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
