package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.exception.MarketplaceNotFoundException;
import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import br.com.amadeus.marketplace.model.Marketplace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DeleteMarketplaceService {
    private MarketplaceRepository marketplaceRepository;

    public void delete(Long id) {
        Marketplace marketplace = marketplaceRepository.findById(id).orElseThrow(() -> new MarketplaceNotFoundException());
        marketplaceRepository.delete(marketplace);
    }
}
