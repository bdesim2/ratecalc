package com.ratecalc.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HealthCheck {

    @JsonProperty("id")
    private long id;
    @JsonProperty("content")
    private String content;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "HealthCheck{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
