package com.example.currencyexchange;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ExchangeRates")
public class CurrencyData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortName;
    private Date validFrom;
    private String name;
    private String country;
    private double move;
    private double amount;
    private double valBuy;
    private double valSell;
    private double valMid;
    private double currBuy;
    private double currSell;
    private double currMid;
    private int version;
    private double cnbMid;
    private double ecbMid;

    // Getters and setters
    
    // Getters
    public String getShortName() {
        return shortName;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public double getMove() {
        return move;
    }

    public double getAmount() {
        return amount;
    }

    public double getValBuy() {
        return valBuy;
    }

    public double getValSell() {
        return valSell;
    }

    public double getValMid() {
        return valMid;
    }

    public double getCurrBuy() {
        return currBuy;
    }

    public double getCurrSell() {
        return currSell;
    }

    public double getCurrMid() {
        return currMid;
    }

    public int getVersion() {
        return version;
    }

    public double getCnbMid() {
        return cnbMid;
    }

    public double getEcbMid() {
        return ecbMid;
    }

    // Setters
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setMove(double move) {
        this.move = move;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setValBuy(double valBuy) {
        this.valBuy = valBuy;
    }

    public void setValSell(double valSell) {
        this.valSell = valSell;
    }

    public void setValMid(double valMid) {
        this.valMid = valMid;
    }

    public void setCurrBuy(double currBuy) {
        this.currBuy = currBuy;
    }

    public void setCurrSell(double currSell) {
        this.currSell = currSell;
    }

    public void setCurrMid(double currMid) {
        this.currMid = currMid;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public void setCnbMid(double cnbMid) {
        this.cnbMid = cnbMid;
    }

    public void setEcbMid(double ecbMid) {
        this.ecbMid = ecbMid;
    }
}

