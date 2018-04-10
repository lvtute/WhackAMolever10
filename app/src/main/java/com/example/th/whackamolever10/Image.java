package com.example.th.whackamolever10;

public class Image {
    private int img;
    private int state;
    public int getHinh() {
        return img;
    }

    public void setHinh(int hinh) {
        this.img = hinh;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Image(int hinh, int state) {
        this.img = hinh;
        this.state = state;
    }


}
