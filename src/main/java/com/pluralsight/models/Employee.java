package com.pluralsight.models;

public class Employee
{
    private int employeeID;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private int punchInTime = -1;


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

    public void punchIn(int time) {
        if (punchInTime != -1) {
            System.out.println("Employee " + this.employeeID + ": " + this.name + " already punched in at " + formatTime(punchInTime));
            return;
        } else {
            punchInTime = time;
            System.out.println("Employee " + this.employeeID + ": " + this.name + "punched in at " + formatTime(punchInTime));
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
        System.out.println("Employee " + this.employeeID + ": " + this.name + " punched out at " + formatTime(time) + " Shift Hours: " + shiftHours + " | Total Hours Worked: " + hoursWorked);
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
