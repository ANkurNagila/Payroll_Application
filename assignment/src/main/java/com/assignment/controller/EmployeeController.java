package com.assignment.controller;

import com.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/payroll")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/total-employees")
    public Integer getTotalEmployees() {
        return employeeService.getTotalNumberOfEmployees();
    }

    @GetMapping("/employees-joined/{month}")
    public List<Object[]> getEmployeesJoinedInMonth(@PathVariable int month) {
        return employeeService.getEmployeesJoinedInMonth(month);
    }

    @GetMapping("/employees-exited/{month}")
    public List<Object[]> getEmployeesExitedInMonth(@PathVariable int month) {
        return employeeService.getEmployeesExitedInMonth(month);
    }

    @GetMapping("/monthly-salary-report")
    public List<Object[]> getMonthlySalaryReport() {
        return employeeService.getMonthlySalaryReport();
    }

    @GetMapping("/employee-financial-report")
    public List<Object[]> getEmployeeFinancialReport() {
        return employeeService.getEmployeeFinancialReport();
    }

    @GetMapping("/monthly-amount-released")
    public List<Object[]> getMonthlyAmountReleased() {
        return employeeService.getMonthlyAmountReleased();
    }

    @GetMapping("/yearly-financial-report/{year}")
    public List<Object[]> getYearlyFinancialReport(@PathVariable int year) {
        return employeeService.getYearlyFinancialReport(year);
    }
}

