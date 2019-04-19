package com.demo.model;

public class Action {
    private Integer id;

    private String actionType;

    private String name;

    private String url;

    public Action() {
    }

    public Action(Integer id, String actionType, String name, String url) {
        this.id = id;
        this.actionType = actionType;
        this.name = name;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}