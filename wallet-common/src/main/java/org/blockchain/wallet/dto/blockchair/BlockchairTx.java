/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;

import java.util.Date;

/**
 * Auto-generated: 2019-05-29 10:1:48
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairTx {

    private long block_id;
    private long id;
    private String hash;
    private String date;
    private Date time;
    private int size;
    private int weight;
    private int version;
    private long lock_time;
    private boolean is_coinbase;
    private boolean has_witness;
    private int input_count;
    private int output_count;
    private long input_total;
    private double input_total_usd;
    private long output_total;
    private double output_total_usd;
    private long fee;
    private double fee_usd;
    private double fee_per_kb;
    private double fee_per_kb_usd;
    private double fee_per_kwu;
    private double fee_per_kwu_usd;
    private double cdd_total;

    public void setBlock_id(long block_id) {
        this.block_id = block_id;
    }
    public long getBlock_id() {
        return block_id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
    public String getHash() {
        return hash;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public boolean isIs_coinbase() {
        return is_coinbase;
    }

    public boolean isHas_witness() {
        return has_witness;
    }

    public void setSize(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    public int getVersion() {
        return version;
    }

    public void setLock_time(long lock_time) {
        this.lock_time = lock_time;
    }
    public long getLock_time() {
        return lock_time;
    }

    public void setIs_coinbase(boolean is_coinbase) {
        this.is_coinbase = is_coinbase;
    }
    public boolean getIs_coinbase() {
        return is_coinbase;
    }

    public void setHas_witness(boolean has_witness) {
        this.has_witness = has_witness;
    }
    public boolean getHas_witness() {
        return has_witness;
    }

    public void setInput_count(int input_count) {
        this.input_count = input_count;
    }
    public int getInput_count() {
        return input_count;
    }

    public void setOutput_count(int output_count) {
        this.output_count = output_count;
    }
    public int getOutput_count() {
        return output_count;
    }

    public void setInput_total(long input_total) {
        this.input_total = input_total;
    }
    public long getInput_total() {
        return input_total;
    }

    public double getInput_total_usd() {
        return input_total_usd;
    }

    public void setInput_total_usd(double input_total_usd) {
        this.input_total_usd = input_total_usd;
    }

    public void setOutput_total(long output_total) {
        this.output_total = output_total;
    }
    public long getOutput_total() {
        return output_total;
    }

    public void setOutput_total_usd(double output_total_usd) {
        this.output_total_usd = output_total_usd;
    }
    public double getOutput_total_usd() {
        return output_total_usd;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }
    public long getFee() {
        return fee;
    }

    public void setFee_usd(double fee_usd) {
        this.fee_usd = fee_usd;
    }
    public double getFee_usd() {
        return fee_usd;
    }

    public void setFee_per_kb(double fee_per_kb) {
        this.fee_per_kb = fee_per_kb;
    }
    public double getFee_per_kb() {
        return fee_per_kb;
    }

    public void setFee_per_kb_usd(double fee_per_kb_usd) {
        this.fee_per_kb_usd = fee_per_kb_usd;
    }
    public double getFee_per_kb_usd() {
        return fee_per_kb_usd;
    }

    public void setFee_per_kwu(double fee_per_kwu) {
        this.fee_per_kwu = fee_per_kwu;
    }
    public double getFee_per_kwu() {
        return fee_per_kwu;
    }

    public void setFee_per_kwu_usd(double fee_per_kwu_usd) {
        this.fee_per_kwu_usd = fee_per_kwu_usd;
    }
    public double getFee_per_kwu_usd() {
        return fee_per_kwu_usd;
    }

    public void setCdd_total(double cdd_total) {
        this.cdd_total = cdd_total;
    }
    public double getCdd_total() {
        return cdd_total;
    }

}