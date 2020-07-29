/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author cis2mye
 */
public class Stock {
    public static void main(){
        Stock s1 = new Stock("ORCL", "Oracle Corporation");
        System.out.println(s1);
    }
    
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;
    
    Stock(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }
    
    public double getChangePercent(){
        return 100 - 100 * (previousClosingPrice / currentPrice);
    }
    
    //setters
    public void setCurrentPrice(double currentPrice){
        this.currentPrice = currentPrice;
    }
    
    public void setPreviousPrice(double previousPrice){
        this.previousClosingPrice = previousPrice;
    }
}
