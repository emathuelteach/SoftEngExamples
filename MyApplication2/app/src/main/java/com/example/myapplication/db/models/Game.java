package com.example.myapplication.db.models;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Game {
    private int id;
    private String startDateTime;
    private String  endDateTime;
    private String state;
    private int winnerId;

    private final String DATE_FORMAT = "yyyy-MM-dd HH:mm";


    public Game(int id,String startDateTime,String endDateTime,
                String state,int winnerId){
        this.id = id;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.state = state;
        this.winnerId = winnerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(String startDateTime) {
        this.startDateTime = startDateTime;
    }

    public String getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(String endDateTime) {
        this.endDateTime = endDateTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getWinnerId() {
        return winnerId;
    }

    public void setWinnerId(int winnerId) {
        this.winnerId = winnerId;
    }
}
