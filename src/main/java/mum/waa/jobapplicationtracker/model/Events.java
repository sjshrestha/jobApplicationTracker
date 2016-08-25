/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mum.waa.jobapplicationtracker.model;

/**
 *
 * @author suraj
 */
public class Events {

    private String eventName;
    private String eventDate;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public Events() {

    }

    public Events(String eventName, String eventDate) {
        this.eventName = eventName;
        this.eventDate = eventDate;
    }

}
