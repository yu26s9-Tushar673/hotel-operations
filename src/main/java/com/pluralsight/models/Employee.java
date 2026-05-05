package com.pluralsight.models;

import java.time.LocalDateTime;

public class Employee
{
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private int punchInTime = -1;
    private int punchInMin = 0;

    public Employee(int employeeID, String name, String department, double payRate, double hoursWorked) {
        this.employeeID = employeeID;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    private String formatTime(int time) {
        if (time == 0)
        {   return "12:00 am."; }
        else if (time == 12)
        {   return "12:00 pm."; }
        else if (time < 12)
        {   return time + ":00 am.";    }
        else
        {   return (time - 12) + ":00 pm."; }
    }

    private String formatTime(int hour, int min) {
        String timeOfDay;
        if (hour < 12) {    timeOfDay = "am.";  }
        else { timeOfDay = "pm."; }
        int displayHour = hour % 12;
        if (displayHour == 0) { displayHour = 12; }
        return String.format( "%d:%02d %s", displayHour, min, timeOfDay);
    }
    public void punchIn() {
        if (punchInTime != -1) {
            System.out.println("Employee " + this.employeeID + ": " + this.name + " already punched in at " + formatTime(punchInTime, punchInMin));
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        punchInTime = now.getHour();
        punchInMin = now.getMinute();
        System.out.println("Employee " + this.employeeID + ": " + this.name + "punched in at " + formatTime(punchInTime, punchInMin));
    }

    public void punchOut() {
        if (punchInTime == -1) {
            System.out.println("Employee " + this.employeeID + ": " + this.name + "never punched in.");
            return;
        }
        LocalDateTime now = LocalDateTime.now();
        int outTime = now.getHour();
        int outMin = now.getMinute();

        int minutesAtPunchIn = (punchInTime * 60) + punchInMin;
        int minutesAtPunchOut = (outTime * 60) + outMin;

        if (minutesAtPunchOut <= minutesAtPunchIn) {
            System.out.println("Invalid punch out time. Must punch out AFTER punch in time.");
        }
        double shiftHours = (minutesAtPunchOut - minutesAtPunchIn) / 60.0;
        hoursWorked += shiftHours;

        System.out.printf("%s punched OUT at %s. Session: %.2f hrs | Total: %.2f hrs.%n",
                name, formatTime(outTime, outMin), shiftHours, hoursWorked);
    }

    public void punchIn(int time) {
        if (punchInTime != -1) {
            System.out.println("Employee " + this.employeeID + ": " + this.name + " already punched in at " + formatTime(punchInTime));
            return;
        } else {
            punchInTime = time;
            System.out.println("Employee " + this.employeeID + ": " + this.name + " punched in at " + formatTime(punchInTime));
        }
    }

    public void punchOut(int time) {
        if (punchInTime == -1) {
            System.out.println("Employee " + this.employeeID + ": " + this.name + "never punched in.");
            return;
        } else if (time <= punchInTime) {
            System.out.println("Invalid punch out time. Must punch out AFTER punch in time.");
            return;
        }
        double shiftHours = time - punchInTime;
        hoursWorked += shiftHours;
        System.out.printf("%s punched OUT at %s. Session: %.2f hrs | Total: %.2f hrs.%n",
                name, formatTime(time), shiftHours, hoursWorked);
        punchInTime = -1; // reset after punch out
    }

    public double getTotalPay() {
        return  ((getPayRate() * getRegularHours()) + ((getPayRate() * 1.5) * getOvertimeHours()));
    }

    public double getRegularHours() {
        if (getHoursWorked() >= 40) {
            return 40;
        } else {
            return getHoursWorked();
        }
    }

    public double getOvertimeHours() {
        if (getHoursWorked() > 40) {
            return getHoursWorked() - 40;
        } else {
            return 0;
        }
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPayRate() {
        return payRate;
    }

    public int getPunchInTime() {
        return punchInTime;
    }

    public void setPunchInTime(int punchInTime) {
        this.punchInTime = punchInTime;
    }

    public int getPunchInMin() {
        return punchInMin;
    }

    public void setPunchInMin(int punchInMin) {
        this.punchInMin = punchInMin;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}
