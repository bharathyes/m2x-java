package com.att.m2x.client.api.feed;


//see @Feed
@Deprecated
public class DataSourceFeed extends Feed {

    private String batch;

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

}

