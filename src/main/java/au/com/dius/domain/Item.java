package au.com.dius.domain;

import java.math.BigDecimal;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public class Item
{
    private String sku;
    private String name;
    private BigDecimal price;

    public Item(String sku, String name, BigDecimal price)
    {
        this.sku = sku;
        this.name = name;
        this.price = price;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku(String sku)
    {
        this.sku = sku;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (sku != null ? !sku.equals(item.sku) : item.sku != null) return false;
        if (name != null ? !name.equals(item.name) : item.name != null) return false;
        return price != null ? price.equals(item.price) : item.price == null;
    }

    @Override
    public int hashCode()
    {
        int result = sku != null ? sku.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }
}
