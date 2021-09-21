package br.com.amadeus.marketplace.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MarketplaceNotFoundException extends IllegalArgumentException {
    public MarketplaceNotFoundException(String message) {
        super(message);
    }
}
