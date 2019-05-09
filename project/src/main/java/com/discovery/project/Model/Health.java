package com.discovery.project.Model;

public class Health {
    private  String instance;
    private  String id;
    private  String name;
    private  String status;

    public Health(String instance, String id, String name, String status) {
        this.instance = instance;
        this.id = id;
        this.name = name;
        this.status = status;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
