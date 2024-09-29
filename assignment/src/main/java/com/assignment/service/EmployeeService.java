package com.assignment.service;

import com.assignment.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Integer getTotalNumberOfEmployees();
    public List<Object[]> getEmployeesJoinedInMonth(int month);
    public List<Object[]> getEmployeesExitedInMonth(int month);
    public List<Object[]> getMonthlySalaryReport();
    public List<Object[]> getEmployeeFinancialReport();
    public List<Object[]> getMonthlyAmountReleased();
    public List<Object[]> getYearlyFinancialReport(int year);
    public void saveEmployee(Employee employee);

}
