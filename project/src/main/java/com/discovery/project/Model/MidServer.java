package com.discovery.project.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class MidServer {

    private String status;
    private String  name;
    private String sys_id;

    public String getName() {
        return name;
    }

    public String getSys_id() {
        return sys_id;
    }

    public String getStatus() {
        return status;
    }

}
