package Task6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static Map<String, List<Employee>> groupByDepartment(
            List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)) ;
    }

  public static  Map<String, Double> averageSalaryByDepartment(
          List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)) );
  }

    public static Optional<String> highestAverageSalaryDepartment(
            List<Employee> employees) {
        return averageSalaryByDepartment(employees)
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey) ;
    }


    static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(1L, "Ali", "IT", 2500));
        employees.add(new Employee(2L, "Murad", "HR", 1800));
        employees.add(new Employee(3L, "Nicat", "IT", 3200));
        employees.add(new Employee(4L, "Leyla", "HR", 2200));
        employees.add(new Employee(5L, "Kamran", "Finance", 3000));




        Map<String, List<Employee>> grouped = groupByDepartment(employees) ;
        Map<String, Double> average = averageSalaryByDepartment(employees) ;
        Optional<String> highest = highestAverageSalaryDepartment(employees) ;
        System.out.println(grouped) ;
        System.out.println(average) ;
        System.out.println(highest) ;





    }

}
