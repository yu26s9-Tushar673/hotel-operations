package com.pluralsight;

import com.pluralsight.models.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmployeeTest
{
    @Test
    public void punchIn_shouldSet_punchInTime()
    {
        // arrange
        Employee employee = new Employee(1, "Brian", "cook", 30, 30);

        // act
        employee.punchIn(13);

        // assert
        assertEquals(13, employee.getPunchInTime());
    }

    @Test
    public void punchIn_shouldNot_punchInTwice() {
        // arrange
        Employee employee = new Employee(1, "Brian", "cook", 30, 30);

        // act
        employee.punchIn(12);
        employee.punchIn(13);

        // assert
        assertEquals(12, employee.getPunchInTime());
    }

    @Test
    public void punchOut_should_calculateCorrectHours() {
        // arrange
        Employee employee = new Employee(1, "Brian", "cook", 30, 30);

        // act
        employee.punchIn(12);
        employee.punchOut(21);
        // assert
        assertEquals(39, employee.getHoursWorked());


    }
    @Test
    public void punchOut_should_resetPunchInTime() {
        // arrange
        Employee employee = new Employee(1, "Brian", "cook", 30, 30);

        // act
        employee.punchIn(12);
        employee.punchOut(21);
        // assert
        assertEquals(-1, employee.getPunchInTime());
    }
}