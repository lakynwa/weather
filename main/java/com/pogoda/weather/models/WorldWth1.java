package com.pogoda.weather.models;

import javax.persistence.*;

@Entity
public class WorldWth1 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public static String date, town, temp, yavl, vlaj, davl;

    public WorldWth1() {
    }

    public WorldWth1(String date, String town, String temp, String yavl, String vlaj, String davl) {
        this.date = date;
        this.town = town;
        this.temp = temp;
        this.yavl = yavl;
        this.vlaj = vlaj;
        this.davl = davl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getYavl() {
        return yavl;
    }

    public void setYavl(String yavl) {
        this.yavl = yavl;
    }

    public String getVlaj() {
        return vlaj;
    }

    public void setVlaj(String vlaj) {
        this.vlaj = vlaj;
    }

    public String getDavl() {
        return davl;
    }

    public void setDavl(String davl) {
        this.davl = davl;
    }
}
