package org.shop;

import java.util.*;

import org.shop.api.SellerService;
import org.shop.data.Seller;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * The Seller Initializer util class.
 */
public class SellerInitializer {

    /** The seller service. */
    @Autowired
    private SellerService sellerService;
    
    /** The seller names. */
    private final Map<Long, String> sellerNames = new HashMap<>();

    /**
     * Inits the sellers.
     */
    public void initSellers() {
        sellerNames.put(1L, "Vasya");
        sellerNames.put(2L, "Petya");

        List<Seller> sellers = new LinkedList<>();
        
        for (Map.Entry<Long, String> entry : sellerNames.entrySet()) {
            Seller seller = new Seller();
            seller.setId(entry.getKey());
            seller.setName(entry.getValue());
            
            sellers.add(seller);
        }
        
        sellerService.importSellers(sellers);
    }
}
