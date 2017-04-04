package au.com.dius.domain;

/**
 * Created by rodealmeida on 05/04/2017.
 */
public class Item
{
    private String sku;
    private String name;
    private Double price;

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

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }
}
