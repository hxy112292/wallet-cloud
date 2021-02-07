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
public class BlockchairCache implements Serializable {

    private boolean live;
    private int duration;
    private String since;
    private String until;
    private double time;

    public void setLive(boolean live) {
        this.live = live;
    }
    public boolean getLive() {
        return live;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    public int getDuration() {
        return duration;
    }

    public boolean isLive() {
        return live;
    }

    public String getSince() {
        return since;
    }

    public void setSince(String since) {
        this.since = since;
    }

    public String getUntil() {
        return until;
    }

    public void setUntil(String until) {
        this.until = until;
    }

    public void setTime(double time) {
        this.time = time;
    }
    public double getTime() {
        return time;
    }

}
