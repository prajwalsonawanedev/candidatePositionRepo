package com.example.candiatePosition.util;

public class Demo implements Container<Integer> {

    private Integer data;


    @Override
    public void addData(Integer data) {
        this.data = data;
    }

    @Override
    public Integer getData() {
        return this.data;
    }
}
