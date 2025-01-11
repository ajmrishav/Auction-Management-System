package org.example;/*
Rishav 
*/

public class BuyerAuctionParticipationModel {

    private String buyerName;
    private Integer auctionId;
    private Double amount;

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public BuyerAuctionParticipationModel(String buyerName, Integer auctionId, Double amount) {
        this.buyerName = buyerName;
        this.auctionId = auctionId;
        this.amount = amount;
    }
}
