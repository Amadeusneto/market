package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.exception.MarketplaceNotFoundException;
import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import br.com.amadeus.marketplace.repository.MarketplaceSpecification;
import br.com.amadeus.marketplace.dto.request.FilterMarketplaceRequest;
import br.com.amadeus.marketplace.model.Marketplace;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FindMarketplaceService {
    private MarketplaceRepository marketplaceRepository;
    private MarketplaceSpecification marketplaceSpecification;

    public Marketplace findById(Long id) {
        return marketplaceRepository.findById(id).orElseThrow(() -> new MarketplaceNotFoundException());
    }

    public Page<Marketplace> findByFiltersAndPagination(FilterMarketplaceRequest filterMarketplaceRequest, Pageable pageable) {
        return marketplaceRepository.findAll(marketplaceSpecification.getMarketplacesByFilter(filterMarketplaceRequest), pageable);
    }
}
