package br.com.amadeus.marketplace.service;

import br.com.amadeus.marketplace.repository.MarketplaceRepository;
import br.com.amadeus.marketplace.MarketplaceApplication;
import br.com.amadeus.marketplace.dto.reader.MarketplaceReaderCsv;
import br.com.amadeus.marketplace.mappers.MarketplaceMapper;
import br.com.amadeus.marketplace.model.Marketplace;
import com.opencsv.bean.CsvToBeanBuilder;
import lombok.AllArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ImportDataByCsv {
    private MarketplaceRepository marketplaceRepository;
    private static final Logger LOGGER = LogManager.getLogger(MarketplaceApplication.class);
    @EventListener(ContextRefreshedEvent.class)
    public void importCsv() {
        if (marketplaceRepository.findAll().isEmpty()) {
            LOGGER.info("Initializing routine to populate marketplaces");
            try {
                Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/DEINFO_AB_FEIRASLIVRES_2014.csv"));

                List<MarketplaceReaderCsv> marketplaceReaders = new CsvToBeanBuilder<MarketplaceReaderCsv>(reader)
                        .withType(MarketplaceReaderCsv.class)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build().parse();
                reader.close();

                List<Marketplace> marketplaces = marketplaceReaders.stream()
                        .map(marketplace -> MarketplaceMapper.INSTANCE.marketplaceReaderCsvToMarketplaceEntity(marketplace))
                        .collect(Collectors.toList());

                marketplaceRepository.saveAll(marketplaces);
                LOGGER.info("End routine to populate marketplaces");
            } catch (IOException e) {
                LOGGER.error("Error in routine, cause: " + e.getCause());
                e.printStackTrace();
            }
        }
    }
}
