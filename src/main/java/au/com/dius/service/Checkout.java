package au.com.dius.service;

import au.com.dius.domain.Item;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public interface Checkout
{
    void scan(Item item);

    Double total();
}
