package com.pluralsight.models;

public class Reservations
{
    private String roomType;
    private int numOfNights;
    private boolean isWeekend;

    public Reservations(String roomType, int numOfNights, boolean isWeekend) {
        this.roomType = roomType;
        this.numOfNights = numOfNights;
        this.isWeekend = isWeekend;
    }

    public double getPrice() {
        if (getRoomType().equalsIgnoreCase("king") && isWeekend())
        {   return 139 * 1.1;   }
        else if (getRoomType().equalsIgnoreCase("king") && !isWeekend())
        {   return 139; }
        else if (getRoomType().equalsIgnoreCase("double") && isWeekend())
        {   return 124 * 1.1; }
        else if (getRoomType().equalsIgnoreCase("double") && !isWeekend())
        {   return 124; }
        return 0;
    }

    public double getReservationTotal() {
        return getNumOfNights() * getPrice();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getNumOfNights() {
        return numOfNights;
    }

    public void setNumOfNights(int numOfNights) {
        this.numOfNights = numOfNights;
    }

    public boolean isWeekend() {
        return isWeekend;
    }

    public void setWeekend(boolean weekend) {
        isWeekend = weekend;
    }
}
