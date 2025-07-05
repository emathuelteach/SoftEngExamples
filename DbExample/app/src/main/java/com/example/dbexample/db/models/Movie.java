package com.example.dbexample.db.models;

import java.time.LocalDate;
import java.util.Date;

public class Movie {
    private int id;
    private String name;
    private LocalDate fromDate;
    private int rank;

    public Movie(String name,LocalDate fromDate,int rank){
        this.name = name;
        this.fromDate = fromDate;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
