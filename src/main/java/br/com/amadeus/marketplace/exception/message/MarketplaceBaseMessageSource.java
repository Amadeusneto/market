package br.com.amadeus.marketplace.exception.message;

import br.com.amadeus.marketplace.exception.MarketplaceErrors;
import org.springframework.stereotype.Component;

@Component
public interface MarketplaceBaseMessageSource {
    String getMessage(String resource, Object[] params);
    String getMessage(MarketplaceErrors error, Object[] params);
}