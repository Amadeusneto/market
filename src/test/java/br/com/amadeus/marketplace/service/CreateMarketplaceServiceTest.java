package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.model.Marketplace;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateMarketplaceServiceTest extends BaseMarketplaceServiceTest {
    @Autowired
    CreateMarketplaceService createMarketplaceService;

    @BeforeEach
    public void setup() {
        Mockito.when(marketplaceRepository.save(Mockito.any())).thenReturn(getMarketplace());
    }

    @Test
    public void saveMarketplaceTest() {
        Marketplace marketplaceSaved = createMarketplaceService.save(marketplace);
        assertThat(marketplaceSaved.getId()).isEqualTo(13000L);
    }
}
