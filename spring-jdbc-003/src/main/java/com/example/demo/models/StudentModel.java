package com.example.demo.models;

import org.springframework.stereotype.Component;

@Component
public class StudentModel {

    private String fName;

    private String sName;

    private String regno;

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getRegno() {
        return regno;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public String toString()
    {
        return "  fName " + fName + "  sName " + sName + "  regno " + regno;
    }
}
