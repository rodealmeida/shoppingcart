package au.com.dius.service.pricing;

import java.math.BigDecimal;
import java.util.List;

import au.com.dius.domain.Item;

/**
 * This rule applies a discount to items when bought in bulk.
 *
 * Created by rodealmeida on 05/04/2017.
 */
public class BulkBuyPricingRule implements PricingRule
{
    private final String applicableSku;

    private final int bulkItemCount;

    private final BigDecimal discountAmount;

    /**
     * Creates a new BulkBuyPricingRule.
     *
     * @param sku to which this rule applies to.
     * @param bulkItemCount How many combined items are needed for this rule to apply.
     * @param discountAmount Money amount to discount when the rule condition is met.
     */
    public BulkBuyPricingRule(String sku, int bulkItemCount, BigDecimal discountAmount)
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
            return discountAmount.multiply(new BigDecimal(matchedItems));
        }

        return BigDecimal.ZERO;
    }
}
