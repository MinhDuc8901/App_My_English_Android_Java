package com.example.myenglish.Model;

public class GameEnglish {
    private String Anh,Viet;
    private boolean check ;

    public String getAnh() {
        return Anh;
    }

    public void setAnh(String anh) {
        Anh = anh;
    }

    public String getViet() {
        return Viet;
    }

    public void setViet(String viet) {
        Viet = viet;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public GameEnglish(String anh, String viet, boolean check) {
        Anh = anh;
        Viet = viet;
        this.check = check;
    }
}
