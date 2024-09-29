package com.assignment.repository;

import com.assignment.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 1. Total number of employees
    @Query("SELECT COUNT(e) FROM Employee e")
    Integer getTotalNumberOfEmployees();

    // 2a. Employees joined in a month
    @Query("SELECT e.employeeId, e.designation, e.empFName, e.empLName FROM Employee e WHERE MONTH(e.joinDate) = :month")
    List<Object[]> getEmployeesJoinedInMonth(@Param("month") int month);

    // 2b. Employees exited in a month
    @Query("SELECT e.empFName, e.empLName FROM Employee e WHERE MONTH(e.exitDate) = :month")
    List<Object[]> getEmployeesExitedInMonth(@Param("month") int month);

    // 3. Monthly salary report
    @Query("SELECT MONTH(e.event.eventDate), SUM(e.event.value), COUNT(e) FROM Employee e WHERE e.event.eventType = 'SALARY' GROUP BY MONTH(e.event.eventDate)")
    List<Object[]> getMonthlySalaryReport();

    // 4. Employee-wise financial report
    @Query("SELECT e.employeeId, e.empFName, e.empLName, SUM(e.event.value) FROM Employee e WHERE e.event.eventType IN ('SALARY', 'BONUS', 'REIMBURSEMENT') GROUP BY e.employeeId, e.empFName, e.empLName")
    List<Object[]> getEmployeeFinancialReport();

    // 5. Monthly amount released
    @Query("SELECT MONTH(e.event.eventDate), SUM(e.event.value), COUNT(e) FROM Employee e WHERE e.event.eventType IN ('SALARY', 'BONUS', 'REIMBURSEMENT') GROUP BY MONTH(e.event.eventDate)")
    List<Object[]> getMonthlyAmountReleased();

    // 6. Yearly financial report
    @Query("SELECT e.event.eventType, e.employeeId, e.event.eventDate, e.event.value FROM Employee e WHERE YEAR(e.event.eventDate) = :year")
    List<Object[]> getYearlyFinancialReport(@Param("year") int year);
}
