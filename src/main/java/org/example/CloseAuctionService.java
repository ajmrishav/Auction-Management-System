package org.example;

/*
Rishav 
*/


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloseAuctionService {



    public Map<String, Double> getWinnerDetails(Integer auctionId, BuyerAuctionParticipationService buyerAuctionParticipationService){
         CreateAuctionService createAuctionService = new CreateAuctionService();
         Map<String, Double> ans = new HashMap<>();

            try {
                List<SellerAuctionCreationModel> sellerAuctionCreationModelList = createAuctionService.getAuctionDetailsList();
                List<BuyerAuctionParticipationModel> buyerAuctionParticipationModelList = buyerAuctionParticipationService.getBuyerDetailsModelList();

                Map<Double, Integer> bidFrequency = new HashMap<>();
                Map<Double, String> bidToBuyerMap = new HashMap<>();
                for (BuyerAuctionParticipationModel participationModel : buyerAuctionParticipationModelList) {
                    if (participationModel.getAuctionId().equals(auctionId)) {
                        Double bidAmount = participationModel.getAmount();
                        String buyerName = participationModel.getBuyerName();

                        bidFrequency.put(bidAmount, bidFrequency.getOrDefault(bidAmount, 0) + 1);
                        bidToBuyerMap.put(bidAmount, buyerName); // Map bid to buyer
                    }
                }
                Double highestUniqueBid = null;
                for (Map.Entry<Double, Integer> entry : bidFrequency.entrySet()) {
                    if (entry.getValue() == 1) {
                        if (highestUniqueBid == null || entry.getKey() > highestUniqueBid) {
                            highestUniqueBid = entry.getKey();
                        }
                    }
                }

                if (highestUniqueBid != null) {
                    String winner = bidToBuyerMap.get(highestUniqueBid);
                    ans.put(winner, highestUniqueBid);
                    System.out.println("The winner of auction " + auctionId + " is: " + winner + " with a bid of " + highestUniqueBid);
                } else {
                    System.out.println("No unique highest bid found. No winner for auction " + auctionId);
                }
            } catch (Exception e) {
                System.out.println("Something went wrong while closing auction service");
            }
            return ans;
        }
    }
