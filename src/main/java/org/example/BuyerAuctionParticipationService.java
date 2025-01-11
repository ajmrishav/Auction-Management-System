package org.example;

import java.util.ArrayList;
import java.util.List;

/*
Rishav 
*/

public class BuyerAuctionParticipationService {

    List<BuyerAuctionParticipationModel> buyerDetailsModelList;


    public List<BuyerAuctionParticipationModel> upsertBidDetails(String buyerName, Integer auctionId, Double amount) {
        BuyerDetailsModel buyerDetailsModel = new BuyerDetailsModel();
        Boolean isUpdated = false;
        try {
            if(buyerDetailsModelList == null || buyerDetailsModelList.isEmpty()){
              buyerDetailsModelList = new ArrayList<>();
            }
            Boolean isBuyerDetailsValid = buyerDetailsModel.isBuyerDetailsExist(buyerName);
            for (BuyerAuctionParticipationModel buyerAuctionParticipation : buyerDetailsModelList) {
                if (buyerAuctionParticipation != null && (buyerAuctionParticipation.getAuctionId().equals(auctionId) && buyerAuctionParticipation.getBuyerName().equals(buyerName))) {
                    buyerAuctionParticipation.setAuctionId(auctionId);
                    buyerAuctionParticipation.setBuyerName(buyerName);
                    buyerAuctionParticipation.setAmount(amount);
                    isUpdated = true;
                    break;
                }
            }
            if (!isUpdated) {
                buyerDetailsModelList.add(new BuyerAuctionParticipationModel(buyerName, auctionId, amount));
            }
        } catch (Exception e) {
            System.out.println("Something went wrong while upserting bid details");
            return null;
        }
        return buyerDetailsModelList;
    }

    public Boolean withdrawAuctionDetails(Integer auctionId, String buyerName){

        if(buyerDetailsModelList!=null && buyerDetailsModelList.isEmpty()) {
            for (BuyerAuctionParticipationModel buyerAuctionParticipationModel : buyerDetailsModelList) {
                if (buyerAuctionParticipationModel.getBuyerName().equals(buyerName) && buyerAuctionParticipationModel.getAuctionId().equals(auctionId)) {
                    buyerDetailsModelList.remove(buyerAuctionParticipationModel);
                    return true;
                }
            }
        }
          return false;
    }

    public List<BuyerAuctionParticipationModel> getBuyerDetailsModelList() {
        return buyerDetailsModelList;
    }
}
