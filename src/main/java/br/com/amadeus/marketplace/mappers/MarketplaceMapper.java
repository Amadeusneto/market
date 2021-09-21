package br.com.amadeus.marketplace.mappers;

import br.com.amadeus.marketplace.dto.reader.MarketplaceReaderCsv;
import br.com.amadeus.marketplace.dto.request.MarketplaceRequest;
import br.com.amadeus.marketplace.dto.response.MarketplaceResponse;
import br.com.amadeus.marketplace.model.Marketplace;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MarketplaceMapper {
    MarketplaceMapper INSTANCE = Mappers.getMapper(MarketplaceMapper.class);

    Marketplace createMarketplaceRequestToMarketplaceEntity(MarketplaceRequest marketplaceRequest);
    MarketplaceResponse marketplaceEntityToMarketplaceResponse(Marketplace marketplace);
    Marketplace marketplaceReaderCsvToMarketplaceEntity(MarketplaceReaderCsv marketplaceReaderCsv);
}
