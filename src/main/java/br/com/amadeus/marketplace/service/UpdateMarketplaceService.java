package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.exception.MarketplaceNotFoundException;
import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import br.com.amadeus.marketplace.model.Marketplace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateMarketplaceService {
    private MarketplaceRepository marketplaceRepository;

    public Marketplace save(Long id, Marketplace marketplace) {
        marketplaceRepository.findById(id).orElseThrow(() -> new MarketplaceNotFoundException());
        marketplace.setId(id);
        return marketplaceRepository.save(marketplace);
    }
}
