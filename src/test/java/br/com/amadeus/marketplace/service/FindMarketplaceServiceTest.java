package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.model.Marketplace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class FindMarketplaceServiceTest extends BaseMarketplaceServiceTest {
    @Autowired
    FindMarketplaceService findMarketplaceService;

    @BeforeEach
    public void setup() {
        Mockito.when(marketplaceRepository.findById(13000L)).thenReturn(Optional.of(getMarketplace()));
    }

    @Test
    public void findMarketPlaceByIdTest() {
        Marketplace marketplace = findMarketplaceService.findById(13000L);
        assertThat(marketplace.getId()).isEqualTo(13000L);
    }
}
