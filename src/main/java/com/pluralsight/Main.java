package com.pluralsight;

import com.pluralsight.models.Employee;
import com.pluralsight.models.Reservations;
import com.pluralsight.models.Room;

import java.sql.SQLOutput;

public class Main {
    static void main()
    {
        // Reservations Test instantiation
        Reservations reservation1 = new Reservations("King", 3, true);
        Reservations reservation2 = new Reservations("King", 3, false);
        Reservations reservation3 = new Reservations("Double", 3, false);
        Reservations reservation4 = new Reservations("Double", 3, true);

        // Room Test instantiation
        Room room1 = new Room(2, 124, true, true);
        Room room2 = new Room(2, 124, true, false);
        Room room3 = new Room(2, 124, false, true );
        Room room4 = new Room(2,124, false, false);

        // Employee Test instantiation
        Employee employee1 = new Employee(1, "Sam", "Clerk" , 20, 50);
        Employee employee2 = new Employee(2,"Jay", "Cook", 20, 65);
        Employee employee3 = new Employee(3, "Joffre", "Cleaner" , 20, 40);
        Employee employee4 = new Employee(4," Tushar", "Security" , 20, 25);

        // Reservation Test output
        System.out.println("------------ Reservations TEST ------------");
        System.out.println("King Size Room, 3 nights, Weekend : " + reservation1.getReservationTotal());
        System.out.println("King Size Room, 3 nights, Not Weekend : " + reservation2.getReservationTotal());
        System.out.println("Double Size Room, 3 nights, Weekend : " + reservation3.getReservationTotal());
        System.out.println("Double Size Room, 3 nights, Not Weekend : " + reservation4.getReservationTotal());

        // Room Test output
        System.out.println("---------------- Room TEST ----------------");
        System.out.println("(isOccupied = true, isDirty = true) Is it available? : " + room1.isAvailable());
        System.out.println("(isOccupied = true, isDirty = false) Is it available? : " + room2.isAvailable());
        System.out.println("(isOccupied = false, isDirty = true) Is it available? : " + room3.isAvailable());
        System.out.println("(isOccupied = false, isDirty = false) Is it available? : " + room4.isAvailable());

        // Employee Test output
        System.out.println("-------------- Employee TEST --------------");
        System.out.println("PayRate = 20");
        System.out.println("Employee 1 " + employee1.getName() + ": " + employee1.getDepartment() + " | " + "Hours Worked: " + employee1.getHoursWorked() + " | Total Pay: " + employee1.getTotalPay());
        System.out.println("Employee 2 " + employee2.getName() + ": " + employee2.getDepartment() + " | " + "Hours Worked: " + employee2.getHoursWorked() + " | Total Pay: " + employee2.getTotalPay());
        System.out.println("Employee 3 " + employee3.getName() + ": " + employee3.getDepartment() + " | " + "Hours Worked: " + employee1.getHoursWorked() + " | Total Pay: " + employee3.getTotalPay());
        System.out.println("Employee 4 " + employee4.getName() + ": " + employee4.getDepartment() + " | " + "Hours Worked: " + employee1.getHoursWorked() + " | Total Pay: " + employee4.getTotalPay());
    }
}
