package br.com.amadeus.marketplace.exception.message;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum MarketplaceMessages {
    TEMP("message.temp");

    @Getter
    private final String value;
}