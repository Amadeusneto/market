package br.com.amadeus.marketplace.controller.impl;

import br.com.amadeus.marketplace.service.DeleteMarketplaceService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class DeleteMarketplaceRestController implements MarketplaceController {

    private DeleteMarketplaceService deleteMarketplaceService;

    @ApiOperation(value = "Delete existing marketplace")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        deleteMarketplaceService.delete(id);
    }
}
