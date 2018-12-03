package com.webarity.models;

public class Thing {

    private String propA = "initial string";
    private long propB;

    public String getPropA() {
        return propA;
    }

    public long getPropB() {
        return propB;
    }

    public void setPropB(long propB) {
        this.propB = propB;
    }

    public void setPropA(String propA) {
        this.propA = propA;
    }
}