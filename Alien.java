package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class Alien {
        private int aid;
        private String name;
        private String tech;
    @Autowired

    private laptop lap1;
    public Alien() {
        System.out.println("object created");
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public laptop getLap1() {
        return lap1;
    }

    public void setLap1(laptop lap1) {
        this.lap1 = lap1;
    }

    public void show(){
        System.out.println("alien exits");
         lap1.compile();
    }
}
