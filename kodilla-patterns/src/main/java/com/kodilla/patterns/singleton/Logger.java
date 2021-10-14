package com.kodilla.patterns.singleton;

public enum Logger {

    INSTANCE;

    private String lastLog = "";

    public void log(String log) {
        lastLog = log;
        System.out.println("Log: [" + log + "]");
    }

    public String getLastLog() {
        return lastLog;
    }

    public void deleteLog(){
        this.lastLog = "";
    }

    public void newLog(String log){
        this.lastLog = log;
    }
}