package com.jarvis.dao;

public class Project {
    private int proId;
    private int userId;
    private String proName;
    private String expDetail;


    public int getProId() {
        return proId;
    }

    public void setProId(int proId) {
        this.proId = proId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getExpDetail() {
        return expDetail;
    }

    public void setExpDetail(String expDetail) {
        this.expDetail = expDetail;
    }
}
