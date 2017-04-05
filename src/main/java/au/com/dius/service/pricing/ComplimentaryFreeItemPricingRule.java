package au.com.dius.service.pricing;

import java.math.BigDecimal;
import java.util.List;

import au.com.dius.domain.Item;

/**
 * This rule gives away an item for every matching item.
 *
 * Created by rodealmeida on 05/04/2017.
 */
public class ComplimentaryFreeItemPricingRule implements PricingRule
{
    private final String applicableSku;

    private final BigDecimal discountAmount;

    /**
     * Creates a new ComplimentaryFreeItemPricingRule.
     *
     * @param sku to which this rule applies to.
     * @param discountAmount Money amount to discount when the rule condition is met.
     */
    public ComplimentaryFreeItemPricingRule(String sku, BigDecimal discountAmount)
    {
        this.applicableSku = sku;
        this.discountAmount = discountAmount;
    }

    public BigDecimal apply(List<Item> items)
    {
        int matchedItems = 0;
        for (Item item: items) {
            if (item.getSku().equalsIgnoreCase(applicableSku)) {
                matchedItems++;
            }
        }

        if (matchedItems >= 1) {
            return discountAmount.multiply(new BigDecimal(matchedItems));
        }

        return BigDecimal.ZERO;
    }
}
