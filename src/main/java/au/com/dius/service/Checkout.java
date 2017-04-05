package au.com.dius.service;

import java.math.BigDecimal;

import au.com.dius.domain.Item;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public interface Checkout
{
    /**
     * Scans a single item
     *
     * @param item to be scanned.
     */
    void scan(Item item);

    /**
     * Calculates the total for the scanned items.
     *
     * @return the total amount if items have been scanned, {@code BigDecimal.ZERO} otherwise.
     */
    BigDecimal total();
}
