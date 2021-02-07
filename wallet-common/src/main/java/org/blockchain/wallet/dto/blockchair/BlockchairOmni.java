/**
  * Copyright 2019 bejson.com
  */
package org.blockchain.wallet.dto.blockchair;

import java.io.Serializable;

/**
 * Auto-generated: 2019-05-29 9:41:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairOmni implements Serializable {

    private int property_id;
    private String property_name;
    private double balance;
    private int reserved_balance;
    private int frozen_balance;

    public void setProperty_id(int property_id) {
         this.property_id = property_id;
     }
     public int getProperty_id() {
         return property_id;
     }

    public void setProperty_name(String property_name) {
         this.property_name = property_name;
     }
     public String getProperty_name() {
         return property_name;
     }

    public void setBalance(double balance) {
         this.balance = balance;
     }
     public double getBalance() {
         return balance;
     }

    public void setReserved_balance(int reserved_balance) {
         this.reserved_balance = reserved_balance;
     }
     public int getReserved_balance() {
         return reserved_balance;
     }

    public void setFrozen_balance(int frozen_balance) {
         this.frozen_balance = frozen_balance;
     }
     public int getFrozen_balance() {
         return frozen_balance;
     }

}
