/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;

import java.io.Serializable;
import java.util.Date;

/**
 * Auto-generated: 2019-05-29 9:41:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairAddr implements Serializable {

    private String type;
    private String script_hex;
    private long balance;
    private double balance_usd;
    private long received;
    private double received_usd;
    private long spent;
    private double spent_usd;
    private long output_count;
    private long unspent_output_count;
    private Date first_seen_receiving;
    private Date last_seen_receiving;
    private Date first_seen_spending;
    private Date last_seen_spending;
    private long transaction_count;

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setScript_hex(String script_hex) {
        this.script_hex = script_hex;
    }
    public String getScript_hex() {
        return script_hex;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }
    public long getBalance() {
        return balance;
    }

    public void setBalance_usd(double balance_usd) {
        this.balance_usd = balance_usd;
    }
    public double getBalance_usd() {
        return balance_usd;
    }

    public void setReceived(long received) {
        this.received = received;
    }
    public long getReceived() {
        return received;
    }

    public void setReceived_usd(double received_usd) {
        this.received_usd = received_usd;
    }
    public double getReceived_usd() {
        return received_usd;
    }

    public void setSpent(long spent) {
        this.spent = spent;
    }
    public long getSpent() {
        return spent;
    }

    public void setSpent_usd(double spent_usd) {
        this.spent_usd = spent_usd;
    }
    public double getSpent_usd() {
        return spent_usd;
    }

    public void setOutput_count(long output_count) {
        this.output_count = output_count;
    }
    public long getOutput_count() {
        return output_count;
    }

    public long getUnspent_output_count() {
        return unspent_output_count;
    }

    public void setUnspent_output_count(long unspent_output_count) {
        this.unspent_output_count = unspent_output_count;
    }

    public Date getFirst_seen_receiving() {
        return first_seen_receiving;
    }

    public void setFirst_seen_receiving(Date first_seen_receiving) {
        this.first_seen_receiving = first_seen_receiving;
    }

    public Date getLast_seen_receiving() {
        return last_seen_receiving;
    }

    public void setLast_seen_receiving(Date last_seen_receiving) {
        this.last_seen_receiving = last_seen_receiving;
    }

    public Date getFirst_seen_spending() {
        return first_seen_spending;
    }

    public void setFirst_seen_spending(Date first_seen_spending) {
        this.first_seen_spending = first_seen_spending;
    }

    public Date getLast_seen_spending() {
        return last_seen_spending;
    }

    public void setLast_seen_spending(Date last_seen_spending) {
        this.last_seen_spending = last_seen_spending;
    }

    public void setTransaction_count(long transaction_count) {
        this.transaction_count = transaction_count;
    }
    public long getTransaction_count() {
        return transaction_count;
    }

}
