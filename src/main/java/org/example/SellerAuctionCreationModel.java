package org.example;

/*
Rishav 
*/

import org.example.Constants.AuctionWinningModeEnum;

public class SellerAuctionCreationModel {

    private Integer auctionId;
    private Double lowestBidLimit;
    private Double highestBidLimit;

    private Double participationCost;

    private String sellerName;

    // i have created this enum so that while deciding the winner i can decide by the auction winning mode according to the condition
    private AuctionWinningModeEnum auctionWinningModeEnum;

    public SellerAuctionCreationModel(Integer auctionId, Double lowestBidLimit, Double highestBidLimit, Double participationCost, String sellerName, AuctionWinningModeEnum auctionWinningModeEnum) {
        this.auctionId = auctionId;
        this.lowestBidLimit = lowestBidLimit;
        this.highestBidLimit = highestBidLimit;
        this.participationCost = participationCost;
        this.sellerName = sellerName;
        this.auctionWinningModeEnum = auctionWinningModeEnum;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Double getLowestBidLimit() {
        return lowestBidLimit;
    }

    public void setLowestBidLimit(Double lowestBidLimit) {
        this.lowestBidLimit = lowestBidLimit;
    }

    public Double getHighestBidLimit() {
        return highestBidLimit;
    }

    public void setHighestBidLimit(Double highestBidLimit) {
        this.highestBidLimit = highestBidLimit;
    }

    public Double getParticipationCost() {
        return participationCost;
    }

    public void setParticipationCost(Double participationCost) {
        this.participationCost = participationCost;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public AuctionWinningModeEnum getAuctionWinningModeEnum() {
        return auctionWinningModeEnum;
    }

    public void setAuctionWinningModeEnum(AuctionWinningModeEnum auctionWinningModeEnum) {
        this.auctionWinningModeEnum = auctionWinningModeEnum;
    }

    public SellerAuctionCreationModel() {
    }
}
