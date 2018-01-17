/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication1;

import java.io.Serializable;

/**
 *
 * @author panbe
 */
public class User implements Serializable {
    private String cardId;
    private String username;
    private double balance;

    public User(String cardId, String username, double balance) {
        this.cardId = cardId;
        this.username = username;
        this.balance = balance;
    }

    public User() {
    }
    
    public void buyProduct(Product product) {
        this.balance = this.balance-product.getPrice();
        product.setQuantityLeft(product.getQuantityLeft() -1);
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    
}
