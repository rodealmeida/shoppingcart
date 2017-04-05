package au.com.dius.service.pricing;

import java.math.BigDecimal;
import java.util.List;

import au.com.dius.domain.Item;

/**
 * This rule discounts the total amount of one of the matched items.
 *
 * Created by rodealmeida on 05/04/2017.
 */
public class BulkBuyFreeItemPricingRule implements PricingRule
{
    private final String applicableSku;

    private final int bulkItemCount;

    private final BigDecimal discountAmount;

    /**
     * Creates a new BulkBuyFreeItemPricingRule.
     *
     * @param sku to which this rule applies to.
     * @param bulkItemCount How many combined items are needed for this rule to apply.
     * @param discountAmount Money amount to discount when the rule condition is met.
     */
    public BulkBuyFreeItemPricingRule(String sku, int bulkItemCount, BigDecimal discountAmount)
    {
        this.applicableSku = sku;
        this.bulkItemCount = bulkItemCount;
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

        if (matchedItems > bulkItemCount) {
            return discountAmount;
        }

        return BigDecimal.ZERO;
    }
}
