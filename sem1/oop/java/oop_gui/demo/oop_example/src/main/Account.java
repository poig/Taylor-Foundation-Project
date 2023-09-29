/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

/**
 *
 * @author junli
 */
public class Account {
    private String ACCNo;
    private double Balance;
    
    public Account(String a, double b) {
        ACCNo = a ; Balance = b;
    }
    
    public String getACCNo(){
        return ACCNo;
    }
    
    
}
