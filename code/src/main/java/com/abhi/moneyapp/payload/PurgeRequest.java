package com.abhi.moneyapp.payload;

import java.io.Serializable;

public class PurgeRequest implements Serializable {

    private int id;
    private String action;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
