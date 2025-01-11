package org.example;

/*
Rishav Ajmani
*/

import java.util.HashSet;
import java.util.Set;

public class BuyerDetailsModel {

    private Set<String> buyerDetails;

    // default constructor
    public BuyerDetailsModel() {
        buyerDetails = new HashSet<>();
    }

    public void addBuyerDetails(String buyerName) {
        try {
            if (buyerName == null || buyerName.isEmpty()) {
                throw new Exception("Please send a valid buyer details");
            }
            if(buyerDetails.contains(buyerName)){
             throw new Exception("This Buyer details already exists");
            }
            else {
               buyerDetails.add(buyerName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public Set<String> getBuyerDetails(){
      return this.buyerDetails;
    }

    public Boolean isBuyerDetailsExist(String buyerName){

        if( (buyerDetails!=null && !buyerDetails.isEmpty()) && buyerDetails.contains(buyerName)){
            return true;
        }
        return false;
    }
}
