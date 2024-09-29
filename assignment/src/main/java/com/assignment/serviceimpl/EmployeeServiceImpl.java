package com.assignment.serviceimpl;
import com.assignment.model.Employee;
import com.assignment.repository.EmployeeRepository;
import com.assignment.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    // 1. Total number of employees in the organization
    public Integer getTotalNumberOfEmployees() {
        List<Employee> temp= employeeRepository.findAll();
        return temp.size();
    }

    @Override
    // 2a. Employees joined per month
    public List<Object[]> getEmployeesJoinedInMonth(int month) {
        return employeeRepository.getEmployeesJoinedInMonth(month);
    }

    @Override
    // 2b. Employees exited per month
    public List<Object[]> getEmployeesExitedInMonth(int month) {
        return employeeRepository.getEmployeesExitedInMonth(month);
    }

    @Override
    // 3. Monthly Salary Report
    public List<Object[]> getMonthlySalaryReport() {
        return employeeRepository.getMonthlySalaryReport();
    }

    @Override
    // 4. Employee-wise Financial Report
    public List<Object[]> getEmployeeFinancialReport() {
        return employeeRepository.getEmployeeFinancialReport();
    }

    @Override
    // 5. Monthly Amount Released (Salary + Bonus + Reimbursement)
    public List<Object[]> getMonthlyAmountReleased() {
        return employeeRepository.getMonthlyAmountReleased();
    }

    @Override
    // 6. Yearly Financial Report
    public List<Object[]> getYearlyFinancialReport(int year) {
        return employeeRepository.getYearlyFinancialReport(year);
    }

    @Override
    // Additional method to save an employee record (for future usage)
    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
