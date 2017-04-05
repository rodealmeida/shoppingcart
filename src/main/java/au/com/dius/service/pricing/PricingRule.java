package au.com.dius.service.pricing;

import java.math.BigDecimal;
import java.util.List;

import au.com.dius.domain.Item;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public interface PricingRule
{

    /**
     * Applies the pricing rule to the given items.
     *
     * @param items to be processed.
     *
     * @return the amount discounted by the pricing rule. If there are no discounts applied will return {@code BigDecimal.ZERO}
     */
    BigDecimal apply(List<Item> items);
}
