/**
 * Copyright 2019 bejson.com
 */
package org.blockchain.wallet.dto.blockchair;

/**
 * Auto-generated: 2019-05-29 9:41:5
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class BlockchairContext {

    private int code;
    private String source;
    private double time;
    private int limit;
    private int offset;
    private int results;
    private long state;
    private BlockchairCache cache;
    private BlockchairApi api;

    public void setCode(int code) {
        this.code = code;
    }
    public int getCode() {
        return code;
    }

    public void setSource(String source) {
        this.source = source;
    }
    public String getSource() {
        return source;
    }

    public void setTime(double time) {
        this.time = time;
    }
    public double getTime() {
        return time;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
    public int getLimit() {
        return limit;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
    public int getOffset() {
        return offset;
    }

    public void setResults(int results) {
        this.results = results;
    }
    public int getResults() {
        return results;
    }

    public void setState(long state) {
        this.state = state;
    }
    public long getState() {
        return state;
    }

    public void setCache(BlockchairCache cache) {
        this.cache = cache;
    }
    public BlockchairCache getCache() {
        return cache;
    }

    public void setApi(BlockchairApi api) {
        this.api = api;
    }
    public BlockchairApi getApi() {
        return api;
    }

}