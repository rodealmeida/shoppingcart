package au.com.dius.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import au.com.dius.domain.Item;
import au.com.dius.service.pricing.PricingRule;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public class CheckoutImpl implements Checkout
{
    private final List<PricingRule> pricingRules;
    private final List<Item> items = new ArrayList<>();


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
        BigDecimal totalDiscounts = BigDecimal.ZERO;
        BigDecimal grandTotal = BigDecimal.ZERO;

        for (PricingRule pricingrule: pricingRules) {
            totalDiscounts = totalDiscounts.add(pricingrule.apply(items));
        }

        for (Item item: items) {
            grandTotal = grandTotal.add(item.getPrice());
        }

        return grandTotal.subtract(totalDiscounts);
    }
}
