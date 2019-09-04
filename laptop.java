package com.example.demo;

import org.springframework.stereotype.Component;

@Component("lap1")
public class laptop {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void compile(){
        System.out.println("compiling...");
    }
}