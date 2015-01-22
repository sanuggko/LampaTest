package com.sng.lampatest.Models;

/**
 * Created by Alexandr on 21.01.2015.
 */
public class TaskModel {
    private String taskNumber;
    private String smallDescription;
    private String fullDescription;

    public TaskModel(String taskNumber, String smallDescription, String fullDescription) {
        this.taskNumber = taskNumber;
        this.smallDescription = smallDescription;
        this.fullDescription = fullDescription;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(String taskNumber) {
        this.taskNumber = taskNumber;
    }

    public String getSmallDescription() {
        return smallDescription;
    }

    public void setSmallDescription(String smallDescription) {
        this.smallDescription = smallDescription;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }
}
