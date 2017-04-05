package au.com.dius.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import au.com.dius.domain.Item;
import au.com.dius.domain.PricingRule;

/**
 * Unit test for CheckoutImpl.
 */
public class CheckoutImplTest
{
    private Checkout checkout;

    @Before
    public void setUp() throws Exception
    {
        List<PricingRule> pricingRules = new ArrayList<PricingRule>();
        checkout = new CheckoutImpl(pricingRules);
    }

    /**
     * Checks that the 3 for 2 deal is being applied on items being checked out.
     */
    @Test
    public void shouldApply3For2DealOnAtvWhenAtvDealRunning()
    {
        // given
        Item item1 = new Item("atv", "Apple TV", new BigDecimal(109.5));
        Item item2 = new Item("atv", "Apple TV", new BigDecimal(109.5));
        Item item3 = new Item("atv", "Apple TV", new BigDecimal(109.5));
        Item item4 = new Item("vga", "VGA adapter", new BigDecimal(30.0));

        // when
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);
        checkout.scan(item4);

        // then
        assertNotNull(checkout.total());
        assertEquals(new BigDecimal(249.0), checkout.total());
    }

    /**
     * Checks that the bulk discount is being applied on items being checked out.
     */
    @Test
    public void shouldApplyBulkDiscountOnIpdWhenIpdBulkDealRunning()
    {
        // given
        Item item1 = new Item("atv", "Apple TV", new BigDecimal(109.5));
        Item item2 = new Item("ipd", "Super iPad", new BigDecimal(549.99));
        Item item3 = new Item("ipd", "Super iPad", new BigDecimal(549.99));
        Item item4 = new Item("atv", "Apple TV", new BigDecimal(109.5));
        Item item5 = new Item("ipd", "Super iPad", new BigDecimal(549.99));
        Item item6 = new Item("ipd", "Super iPad", new BigDecimal(549.99));
        Item item7 = new Item("ipd", "Super iPad", new BigDecimal(549.99));

        // when
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);
        checkout.scan(item4);
        checkout.scan(item5);
        checkout.scan(item6);
        checkout.scan(item7);

        // then
        assertNotNull(checkout.total());
        assertEquals(new BigDecimal(2718.95), checkout.total());
    }

    /**
     * Checks that the free VGA discount is applied when buying a MacBook Pro.
     */
    @Test
    public void shouldBundleFreeVgaWhenMacBookProSold()
    {
        // given
        Item item1 = new Item("mbp", "MacBook Pro", new BigDecimal(1399.99));
        Item item2 = new Item("vga", "VGA adapter", new BigDecimal(30.0));
        Item item3 = new Item("ipd", "Super iPad", new BigDecimal(549.99));

        // when
        checkout.scan(item1);
        checkout.scan(item2);
        checkout.scan(item3);

        // then
        assertNotNull(checkout.total());
        assertEquals( new BigDecimal(1949.98), checkout.total());
    }
}
