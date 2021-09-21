package br.com.amadeus.marketplace.exception;

public abstract class MarketplaceBaseException extends RuntimeException {
    public abstract MarketplaceErrors error();
}
