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
public class BlockchairApi {

    private String version;
    private String last_major_update;
    private String next_major_update;
    private String tested_features;
    private String documentation;

    public void setVersion(String version) {
        this.version = version;
    }
    public String getVersion() {
        return version;
    }

    public String getLast_major_update() {
        return last_major_update;
    }

    public void setLast_major_update(String last_major_update) {
        this.last_major_update = last_major_update;
    }

    public void setNext_major_update(String next_major_update) {
        this.next_major_update = next_major_update;
    }
    public String getNext_major_update() {
        return next_major_update;
    }

    public void setTested_features(String tested_features) {
        this.tested_features = tested_features;
    }
    public String getTested_features() {
        return tested_features;
    }

    public void setDocumentation(String documentation) {
        this.documentation = documentation;
    }
    public String getDocumentation() {
        return documentation;
    }

}