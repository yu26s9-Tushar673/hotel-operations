package com.pluralsight.models;

public class Hotel
{
    private String name;
    private int numberOfSuites;
    private int numberOfRooms;
    private int bookedSuites;
    private int bookedBasicRooms;

    public Hotel(String name, int numberOfSuites, int numberOfRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = 0;
        this.bookedBasicRooms = 0;
    }

    public Hotel(String name, int numberOfSuites, int numberOfRooms, int bookedSuites, int bookedBasicRooms) {
        this.name = name;
        this.numberOfSuites = numberOfSuites;
        this.numberOfRooms = numberOfRooms;
        this.bookedSuites = bookedSuites;
        this.bookedBasicRooms = bookedBasicRooms;
    }

    public boolean bookRoom(int numOfRooms, boolean isSuite) {
        if (isSuite) {
            if (getAvailableSuites() < numOfRooms) {
                bookedSuites += numOfRooms;
                System.out.println(numOfRooms + " Suite(s) booked. Remaining suite(s): " + getAvailableSuites());
                return true;
            } else {
                System.out.println("Not enough suites available. Requested: " + numberOfRooms
                        + " | Available: " + getAvailableSuites());
                return false;
            }
        } else {
            if (getAvailableRooms() < numOfRooms) {
                bookedSuites += numOfRooms;
                System.out.println(numOfRooms + " basic rooms(s) booked. Remaining basic rooms(s): " + getAvailableRooms());
                return true;
            } else {
                System.out.println("Not enough basic rooms available. Requested: " + numberOfRooms
                        + " | Available: " + getAvailableRooms());
                return false;
            }
        }
    }

    public int getAvailableSuites() {
        return numberOfSuites - bookedSuites;
    }

    public int getAvailableRooms() {
        return numberOfRooms - bookedBasicRooms;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfSuites() {
        return numberOfSuites;
    }

    public void setNumberOfSuites(int numberOfSuites) {
        this.numberOfSuites = numberOfSuites;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(int numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public int getBookedSuites() {
        return bookedSuites;
    }

    public void setBookedSuites(int bookedSuites) {
        this.bookedSuites = bookedSuites;
    }

    public int getBookedBasicRooms() {
        return bookedBasicRooms;
    }

    public void setBookedBasicRooms(int bookedBasicRooms) {
        this.bookedBasicRooms = bookedBasicRooms;
    }
}
