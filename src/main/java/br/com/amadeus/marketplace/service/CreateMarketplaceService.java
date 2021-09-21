package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import br.com.amadeus.marketplace.model.Marketplace;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateMarketplaceService {
    private MarketplaceRepository marketplaceRepository;

    public Marketplace save(Marketplace market) {
        return marketplaceRepository.save(market);
    }
}
