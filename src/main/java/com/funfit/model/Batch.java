package com.funfit.model;


public class Batch {


    private int batchId;

    private String batchName;

    private String batchTime;

    private String instructor;



    public Batch() {

    }



    public Batch(String batchName,
                 String batchTime,
                 String instructor) {


        this.batchName = batchName;

        this.batchTime = batchTime;

        this.instructor = instructor;

    }



    public Batch(int batchId,
                 String batchName,
                 String batchTime,
                 String instructor) {


        this.batchId = batchId;

        this.batchName = batchName;

        this.batchTime = batchTime;

        this.instructor = instructor;

    }




    public int getBatchId() {

        return batchId;

    }



    public void setBatchId(int batchId) {

        this.batchId = batchId;

    }



    public String getBatchName() {

        return batchName;

    }



    public void setBatchName(String batchName) {

        this.batchName = batchName;

    }



    public String getBatchTime() {

        return batchTime;

    }



    public void setBatchTime(String batchTime) {

        this.batchTime = batchTime;

    }



    public String getInstructor() {

        return instructor;

    }



    public void setInstructor(String instructor) {

        this.instructor = instructor;

    }


}