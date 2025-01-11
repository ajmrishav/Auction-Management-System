package org.example;

/*
Rishav 
*/

import java.util.HashSet;
import java.util.Set;

public class SellerDetailsModel {

   private Set<String> sellerDetails;

    // default constructor
    public SellerDetailsModel() {
            sellerDetails = new HashSet<>();
    }

    public Set<String> addSellerDetails(String seller) throws Exception {
        try {
            if (seller == null || seller.isEmpty()) {
                throw new Exception("Please send a valid buyer details");
            }
            if (sellerDetails.contains(seller)) {
                throw new Exception("This Buyer details already exists");
            } else {
                sellerDetails.add(seller);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong while adding seller details");
            // we can use Sl4j for logging for that i have used sout just for this case
            throw new Exception("Something went wrong while adding seller");
        }
        return sellerDetails;
    }

    public Set<String> getSellerDetails() {
        return this.sellerDetails;
    }

    public Boolean isSellerDetailsExist(String sellerName){
        System.out.println("Is seller details valid");
        System.out.println(sellerDetails.size());
        if( (sellerDetails!=null && !sellerDetails.isEmpty()) && sellerDetails.contains(sellerName)){
            return true;
        }
        return false;
    }
}
