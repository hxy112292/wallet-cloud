/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;

/**
 * Auto-generated: 2019-05-29 10:1:48
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairInputOrOutput {

    private long block_id;
    private long transaction_id;
    private int index;
    private String transaction_hash;
    private String date;
    private String time;
    private long value;
    private double value_usd;
    private String recipient;
    private String type;
    private String script_hex;
    private boolean is_from_coinbase;
    private boolean is_spendable;
    private boolean is_spent;
    private long spending_block_id;
    private long spending_transaction_id;
    private int spending_index;
    private String spending_transaction_hash;
    private String spending_date;
    private String spending_time;
    private double spending_value_usd;
    private long spending_sequence;
    private String spending_signature_hex;
    private String spending_witness;
    private int lifespan;
    private double cdd;

    public void setBlock_id(long block_id) {
        this.block_id = block_id;
    }
    public long getBlock_id() {
        return block_id;
    }

    public void setTransaction_id(long transaction_id) {
        this.transaction_id = transaction_id;
    }
    public long getTransaction_id() {
        return transaction_id;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }

    public void setTransaction_hash(String transaction_hash) {
        this.transaction_hash = transaction_hash;
    }
    public String getTransaction_hash() {
        return transaction_hash;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public boolean isIs_from_coinbase() {
        return is_from_coinbase;
    }

    public boolean isIs_spent() {
        return is_spent;
    }

    public void setSpending_date(String spending_date) {
        this.spending_date = spending_date;
    }

    public void setSpending_time(String spending_time) {
        this.spending_time = spending_time;
    }

    public void setValue(long value) {
        this.value = value;
    }
    public long getValue() {
        return value;
    }

    public void setValue_usd(double value_usd) {
        this.value_usd = value_usd;
    }
    public double getValue_usd() {
        return value_usd;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }
    public String getRecipient() {
        return recipient;
    }

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

    public void setIs_from_coinbase(boolean is_from_coinbase) {
        this.is_from_coinbase = is_from_coinbase;
    }
    public boolean getIs_from_coinbase() {
        return is_from_coinbase;
    }

    public boolean isIs_spendable() {
        return is_spendable;
    }

    public void setIs_spendable(boolean is_spendable) {
        this.is_spendable = is_spendable;
    }

    public String getSpending_date() {
        return spending_date;
    }

    public String getSpending_time() {
        return spending_time;
    }

    public void setIs_spent(boolean is_spent) {
        this.is_spent = is_spent;
    }
    public boolean getIs_spent() {
        return is_spent;
    }

    public void setSpending_block_id(long spending_block_id) {
        this.spending_block_id = spending_block_id;
    }
    public long getSpending_block_id() {
        return spending_block_id;
    }

    public void setSpending_transaction_id(long spending_transaction_id) {
        this.spending_transaction_id = spending_transaction_id;
    }
    public long getSpending_transaction_id() {
        return spending_transaction_id;
    }

    public void setSpending_index(int spending_index) {
        this.spending_index = spending_index;
    }
    public int getSpending_index() {
        return spending_index;
    }

    public void setSpending_transaction_hash(String spending_transaction_hash) {
        this.spending_transaction_hash = spending_transaction_hash;
    }
    public String getSpending_transaction_hash() {
        return spending_transaction_hash;
    }

    public void setSpending_value_usd(double spending_value_usd) {
        this.spending_value_usd = spending_value_usd;
    }
    public double getSpending_value_usd() {
        return spending_value_usd;
    }

    public void setSpending_sequence(long spending_sequence) {
        this.spending_sequence = spending_sequence;
    }
    public long getSpending_sequence() {
        return spending_sequence;
    }

    public void setSpending_signature_hex(String spending_signature_hex) {
        this.spending_signature_hex = spending_signature_hex;
    }
    public String getSpending_signature_hex() {
        return spending_signature_hex;
    }

    public void setSpending_witness(String spending_witness) {
        this.spending_witness = spending_witness;
    }
    public String getSpending_witness() {
        return spending_witness;
    }

    public void setLifespan(int lifespan) {
        this.lifespan = lifespan;
    }
    public int getLifespan() {
        return lifespan;
    }

    public double getCdd() {
        return cdd;
    }

    public void setCdd(double cdd) {
        this.cdd = cdd;
    }
}