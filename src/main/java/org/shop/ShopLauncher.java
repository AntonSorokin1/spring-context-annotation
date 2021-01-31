package org.shop;


import org.shop.api.ProductService;
import org.shop.api.SellerService;
import org.shop.configuration.MainConfiguration;
import org.shop.data.Product;
import org.shop.data.Seller;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainConfiguration.class);

        SellerService sellerService = context.getBean(SellerService.class);
        Seller seller = sellerService.getSellerById(1L);
        System.out.println("seller = " + seller);
        ProductService productService = context.getBean(ProductService.class);
        Product product = productService.getProductById(1L);
        System.out.println("product = " + product);
    }
}
