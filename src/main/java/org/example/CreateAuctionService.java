package org.example;/*
Rishav 
*/

import org.example.Constants.AuctionWinningModeEnum;

import java.util.ArrayList;
import java.util.List;

public class CreateAuctionService {

    List<SellerAuctionCreationModel> ongoingAuctionDetails;


    public CreateAuctionService() {
        ongoingAuctionDetails = new ArrayList<>();
    }

    // this is a service class for creating the auction
    public CreateAuctionService(Integer auctionId, Double lowestBidLimit, Double highestBidLimit, Double participationCost, String sellerName, AuctionWinningModeEnum auctionWinningModeEnum, SellerDetailsModel sellerDetails) {
        SellerDetailsModel sellerDetailsModel = sellerDetails;
         if(ongoingAuctionDetails == null || ongoingAuctionDetails.isEmpty()){
           ongoingAuctionDetails = new ArrayList<>();
         }
        try {
            if(highestBidLimit < lowestBidLimit || lowestBidLimit < 0){
                System.out.println("Amount details is not valid");
                // throw exception;
            }
            Boolean isSellerDetailsValid = sellerDetailsModel.isSellerDetailsExist(sellerName);
            Boolean isAuctionExists = isAuctionIdAlreadyExists(auctionId);

            if (isAuctionExists) {
                System.out.println("this auction id already exists , Please create a auction with a different name");
            }

            if (isSellerDetailsValid) {
                SellerAuctionCreationModel SellerAuctionCreationModel = new SellerAuctionCreationModel(auctionId, lowestBidLimit, highestBidLimit, participationCost, sellerName, auctionWinningModeEnum);
                ongoingAuctionDetails.add(SellerAuctionCreationModel);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong while creating the auction details");
        }
    }

    private Boolean isAuctionIdAlreadyExists(Integer auctionId) {
        for (SellerAuctionCreationModel SellerAuctionCreationModel : ongoingAuctionDetails) {
            if (SellerAuctionCreationModel.getAuctionId().equals(auctionId)) {
                return true;
            }
        }
        return false;
    }

    public List<SellerAuctionCreationModel> getAuctionDetailsList() {
        return this.ongoingAuctionDetails;
    }


}
