package au.com.dius.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import au.com.dius.domain.Item;
import au.com.dius.domain.PricingRule;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public class CheckoutImpl implements Checkout
{
    private final List<PricingRule> pricingRules;
    private final List<Item> items = new ArrayList<Item>();


    public CheckoutImpl(List<PricingRule> pricingRules)
    {
        this.pricingRules = pricingRules;
    }

    public void scan(Item item)
    {
        items.add(item);
    }

    public BigDecimal total()
    {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item: items) {
            total = total.add(item.getPrice());
        }
        return total;
    }
}
