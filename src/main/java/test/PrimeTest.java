package test;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class PrimeTest {
    public static void main(String[] args) {
        System.out.println("Test setup");
        // N * 3 ( row * col)
        // first column contains name of the employees
        // second column contains login time
        // third column contains logout time

        // o/p : read this matrix and come up with another matrix with unique rows and maximum time spent in office.

        // o/p : N * 4 ( name, max time, login, log out time)

        String trackEmployee [] [] = new String [10][3];

        trackEmployee [0] = new String[]{"Robin", String.valueOf(new Timestamp(5000)), String.valueOf(new Timestamp(6000))};
        trackEmployee [1] = new String[]{"RobinS", String.valueOf(new Timestamp(5000)), String.valueOf(new Timestamp(6000))};
        trackEmployee [2] = new String[]{"RobinT", String.valueOf(new Timestamp(5000)), String.valueOf(new Timestamp(6000))};
        trackEmployee [3] = new String[]{"RobinV", String.valueOf(new Timestamp(5000)), String.valueOf(new Timestamp(6000))};

        // list of numbers and numbers can be order of millions.
        // o/p : second highest number.

        // Employee table and Department table
        // Employee : empId, Name, Salary, deptId
        // Department : (1:1 with Employee) - id, name

        //select * from Employee emp INNER JOIN Department dept on emp.deptId = dept.id
          //      order by emp.salary desc limit 1;
    }
}
