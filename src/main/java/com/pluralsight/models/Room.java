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

    public void checkIn() {
        if (isOccupied()) {
            System.out.println("Cannot Check In, the room is currently occupied.");
            return;
        }
        if (isDirty()) {
            System.out.println("Cannot Check In, the room is currently dirty.");
        }
        this.isDirty = true;
        this.isOccupied = true;
        System.out.println("Checked In, the room is now occupied.");
    }

    public void checkout() {
        if (!isOccupied()) {
            System.out.println("Cannot Check Out, the room is not occupied.");
            return;
        }
        this.isOccupied = false;
        System.out.println("Checked Out, the room is now unoccupied.");
    }

    public void cleanRoom() {
        if (isOccupied()) {
            System.out.println("Cannot clean room, it is currently occupied.");
            return;
        }
        if (!isDirty()) {
            System.out.println("Cannot clean room, it is already cleaned.");
        }
        this.isDirty = false;
        System.out.println("Room Cleaned, it is now available.");
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