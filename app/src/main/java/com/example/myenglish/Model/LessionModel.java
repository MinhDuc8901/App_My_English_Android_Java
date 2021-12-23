package com.example.myenglish.Model;

public class LessionModel {
    public int id;
    public String lessionName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLessionName() {
        return lessionName;
    }

    public void setLessionName(String lessionName) {
        this.lessionName = lessionName;
    }

    public LessionModel(int id, String lessionName) {
        this.id = id;
        this.lessionName = lessionName;
    }
}
