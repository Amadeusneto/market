package br.com.amadeus.marketplace.exception.message;

import br.com.amadeus.marketplace.exception.MarketplaceErrors;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MarketplaceMessageSource implements MarketplaceBaseMessageSource {
    private final MessageSource messageSource;

    public String getMessage(MarketplaceErrors error, Object[] params) {
        return getMessage(error.getMessageRes(), params);
    }

    public String getMessage(String resource, Object[] params) {
        return messageSource.getMessage(resource, params, LocaleContextHolder.getLocale());
    }
}