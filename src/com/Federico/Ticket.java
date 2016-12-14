package com.Federico;

import java.util.Date;


public class Ticket {

    private String Priority;
    private String TicketID;
    private String Description;
    private Date DateReported;

    public Ticket (String TicketID, String Description, String Priority, Date DateReported){

        this.Priority = Priority;
        this.TicketID = TicketID;
        this.Description = Description;
        this.DateReported = DateReported;
    }

    public String getID (){
        return TicketID;
    }
    @Override
    public String toString(){
        return("Ticket ID : " + this.TicketID + " Description: "+ this.Description + " Priority: " + this.Priority +
                " Ticket created on: " + this.DateReported);
    }
}
