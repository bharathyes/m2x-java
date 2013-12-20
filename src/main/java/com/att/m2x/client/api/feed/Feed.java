package com.att.m2x.client.api.feed;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import com.att.m2x.client.api.Status;
import com.att.m2x.client.api.Visibility;
import com.att.m2x.client.api.stream.Stream;
import com.att.m2x.client.api.trigger.Trigger;


/*
  TODO: PK,20/12, Sometime type information is missed in response, all type-dependent fields will be placed in raws map
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = BatchFeed.class, name="batch"),
        @Type(value = BlueprintFeed.class, name="blueprint"),
        @Type(value = DataSourceFeed.class, name="datasource")
})*/
public /*abstract*/ class Feed {

    protected String id;
    protected String name;
    protected String description;
    protected Visibility visibility;
    protected String serial;
    protected Status status;
    protected String feed;
    protected List<String> tags;
    protected String url;
    protected String key;
    protected Date created;
    protected Date updated;
    protected Location location;
    protected List<Stream> streams;
    protected List<Trigger> triggers;
    protected Map<String, Object> raws = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public String getSerial() {
        return serial;
    }

    public Status getStatus() {
        return status;
    }

    public String getFeed() {
        return feed;
    }

    public List<String> getTags() {
        return tags;
    }

    public String getUrl() {
        return url;
    }

    public String getKey() {
        return key;
    }

    public Date getCreated() {
        return created;
    }

    public Date getUpdated() {
        return updated;
    }

    public Location getLocation() {
        return location;
    }

    public List<Stream> getStreams() {
        return streams;
    }

    public List<Trigger> getTriggers() {
        return triggers;
    }

    @JsonAnySetter
    public void addRawPair(String name, Object value) {
        raws.put(name, value);
    }

    public Map<String, Object> getRawMap() {
        return Collections.unmodifiableMap(raws);
    }

}

