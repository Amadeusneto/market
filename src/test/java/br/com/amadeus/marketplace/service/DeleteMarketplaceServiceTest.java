package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.exception.MarketplaceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DeleteMarketplaceServiceTest extends BaseMarketplaceServiceTest {
    @Autowired
    DeleteMarketplaceService deleteMarketplaceService;

    @BeforeEach
    public void setup() {
        Mockito.when(marketplaceRepository.findById(13000L)).thenReturn(Optional.of(getMarketplace()));
        Mockito.doNothing().when(marketplaceRepository).delete(any());
    }

    @Test
    public void deleteMarketplaceTest() {
        deleteMarketplaceService.delete(13000L);
        verify(marketplaceRepository, times(1)).delete(any());
    }

    @Test
    public void deleteMarketplaceNotFoundExceptionTest() {
        assertThrows(MarketplaceNotFoundException.class, () -> deleteMarketplaceService.delete(11000L));
    }
}
