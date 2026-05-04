package com.pluralsight.models;

public class Room
{
    private int numOfBeds;
    private float price;
    private boolean isOccupied;
    private boolean isDirty;

    public Room(int numOfBeds, float price, boolean isOccupied, boolean isDirty) {
        this.numOfBeds = numOfBeds;
        this.price = price;
        this.isOccupied = isOccupied;
        this.isDirty = isDirty;
    }

    public boolean isAvailable() {
        return !isOccupied && !isDirty;
    }

    public int getNumOfBeds() {
        return numOfBeds;
    }

    public float getPrice() {
        return price;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public boolean isDirty() {
        return isDirty;
    }
}