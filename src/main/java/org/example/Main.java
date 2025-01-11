package org.example;

import org.example.Constants.AuctionWinningModeEnum;

import java.util.Map;

/*
Rishav Ajmani
*/
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        BuyerDetailsModel buyerDetailsModel = new BuyerDetailsModel();
        SellerDetailsModel sellerDetailsModel = new SellerDetailsModel();
        BuyerAuctionParticipationService buyerAuctionParticipationService = new BuyerAuctionParticipationService();
        CloseAuctionService closeAuctionService = new CloseAuctionService();
        try {
            // Test Case 1
            buyerDetailsModel.addBuyerDetails("Rishav");
            buyerDetailsModel.addBuyerDetails("Virat");
            buyerDetailsModel.addBuyerDetails("Sachin");
            sellerDetailsModel.addSellerDetails("Ramesh");
            CreateAuctionService createAuctionService = new CreateAuctionService(1, 2.0, 100.0, 50.50, "Ramesh", AuctionWinningModeEnum.HIGHEST_BID, sellerDetailsModel);
            buyerAuctionParticipationService.upsertBidDetails("Rishav", 1, 500000.0);
            buyerAuctionParticipationService.upsertBidDetails("Virat", 1, 100.0);
            buyerAuctionParticipationService.upsertBidDetails("Sachin", 1, 200.0);
            buyerAuctionParticipationService.upsertBidDetails("Sachin", 1, 12000.0);
            buyerAuctionParticipationService.withdrawAuctionDetails(1, "Virat");
            Map<String, Double> winnerDetails = closeAuctionService.getWinnerDetails(1,buyerAuctionParticipationService);
            if (winnerDetails != null && !winnerDetails.isEmpty()) {
                for (Map.Entry<String, Double> entry : winnerDetails.entrySet()) {
                    System.out.println("Winner Name " + entry.getKey() + "Bid Amount " + entry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong in the auction process");
        }
    }
}