package com.discovery.project.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MidResult {



    private MidServer[] result;

    public MidServer[] getResult() {
        return result;
    }
}
