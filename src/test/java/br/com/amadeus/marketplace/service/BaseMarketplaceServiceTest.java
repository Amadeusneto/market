package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import br.com.amadeus.marketplace.mappers.MarketplaceMapper;
import br.com.amadeus.marketplace.model.Marketplace;
import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BaseMarketplaceServiceTest {
    @MockBean
    protected MarketplaceRepository marketplaceRepository;

    protected MarketplaceRequest marketplaceRequest;
    protected Marketplace marketplace;

    protected MarketplaceRequest getMarketplaceRequest() {
        return MarketplaceRequest.builder()
                .active(true)
                .area("51")
                .districtCode("04")
                .districtName("DF")
                .latitude(23245D)
                .longitude(23245D)
                .name("LOJA DE VAREJO")
                .neighborhood("Brasília")
                .number("11")
                .reference("PRÓXIMO AO HOSPITAL DO GUARÁ")
                .region05("SUL")
                .region08("NORTE")
                .register("5001")
                .sector("235432")
                .street("Brasília")
                .subCityHallCode(23L)
                .subCityHallName("BSB")
                .build();
    }

    protected Marketplace getMarketplace() {
        MarketplaceRequest marketplaceRequest = getMarketplaceRequest();
        Marketplace marketplaceX = MarketplaceMapper.INSTANCE.createMarketplaceRequestToMarketplaceEntity(marketplaceRequest);
        marketplaceX.setId(16000L);
        return marketplaceX;
    }
}
