package au.com.dius.service;

import java.math.BigDecimal;
import java.util.List;

import au.com.dius.domain.Item;
import au.com.dius.domain.PricingRule;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public class CheckoutImpl implements Checkout
{
    private final List<PricingRule> pricingRules;

    public CheckoutImpl(List<PricingRule> pricingRules)
    {
        this.pricingRules = pricingRules;
    }

    public void scan(Item item)
    {

    }

    public BigDecimal total()
    {
        return null;
    }
}
