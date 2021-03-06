package shopping.v2.samples.products;

import com.google.api.services.content.model.Price;
import com.google.api.services.content.model.Product;
import com.google.api.services.content.model.ProductShipping;

import java.util.ArrayList;
import shopping.v2.samples.Config;

/**
 * Factory for creating Products to be inserted by the ProductInsert and ProductBatchInsert
 * samples.
 */
public class ExampleProductFactory {
  public static Product create(Config config, String channel, String contentLanguage,
      String targetCountry, String offerId) {
    Product product = new Product();
    String websiteUrl = config.getWebsiteUrl();

    if (config.getWebsiteUrl() == null) {
      websiteUrl = "http://my-book-shop.com";
    }

    product.setOfferId(offerId);
    product.setTitle("A Tale of Two Cities");
    product.setDescription("A classic novel about the French Revolution");
    product.setLink(websiteUrl + "/tale-of-two-cities.html");
    product.setImageLink(websiteUrl + "/tale-of-two-cities.jpg");
    product.setChannel(channel);
    product.setContentLanguage(contentLanguage);
    product.setTargetCountry(targetCountry);
    product.setAvailability("in stock");
    product.setCondition("new");
    product.setGoogleProductCategory("Media > Books");
    product.setGtin("9780007350896");

    Price price = new Price();
    price.setValue("2.50");
    price.setCurrency("GBP");
    product.setPrice(price);

    Price shippingPrice = new Price();
    shippingPrice.setValue("0.99");
    shippingPrice.setCurrency("GBP");

    ProductShipping shipping = new ProductShipping();
    shipping.setPrice(shippingPrice);
    shipping.setCountry("GB");
    shipping.setService("1st class post");

    ArrayList<ProductShipping> shippingList = new ArrayList<ProductShipping>();
    shippingList.add(shipping);
    product.setShipping(shippingList);

    return product;
  }
}
