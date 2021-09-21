package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.model.Marketplace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateMarketplaceServiceTest extends BaseMarketplaceServiceTest {
    @Autowired
    UpdateMarketplaceService updateMarketplaceService;

    Marketplace marketplaceUpdate;

    @BeforeEach
    public void setup() {
        marketplaceUpdate = getMarketplace();
        marketplaceUpdate.setName("Nova Feira");
        Mockito.when(marketplaceRepository.findById(13000L)).thenReturn(Optional.of(getMarketplace()));
        Mockito.when(marketplaceRepository.save(Mockito.any())).thenReturn(marketplaceUpdate);
    }

    @Test
    public void updateMarketplaceByIdTest() {
        Marketplace marketplace = updateMarketplaceService.save(13000L, marketplaceUpdate);
        assertThat(marketplace.getId()).isEqualTo(13000L);
    }
}
