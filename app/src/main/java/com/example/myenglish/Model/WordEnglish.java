package com.example.myenglish.Model;

public class WordEnglish {
    private String English,VietNam;

    public WordEnglish(String english, String vietNam) {
        English = english;
        VietNam = vietNam;
    }

    public String getEnglish() {
        return English;
    }

    public void setEnglish(String english) {
        English = english;
    }

    public String getVietNam() {
        return VietNam;
    }

    public void setVietNam(String vietNam) {
        VietNam = vietNam;
    }
}
