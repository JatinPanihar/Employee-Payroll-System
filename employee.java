
import java.util.ArrayList;
abstract class Employee {
    private String name;

    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public int getid() {
        return id;
    }

    public abstract double calculatesalary();

    public String tostring() {
        return "Employee Name :- " + name + " Employee id :-" + id + "Employee salary :- " + calculatesalary();
    }

    class Fulltimeemployee extends Employee {
        private double monthlysalary;

        public Fulltimeemployee(String name, int id, double monthlysalary) {
            super(name, id);
            this.monthlysalary = monthlysalary;
        }

        public double calculatesalary() {

            return monthlysalary;
        }


    }

    class Parttimeemployee extends Employee {
        private int hourlyrate;
        private int hourlytime;

        public Parttimeemployee(String name, int id, int hourlyrate, int hourlytime) {
            super(name, id);
            this.hourlytime = hourlytime;
            this.hourlyrate = hourlyrate;
        }

        public double calculatesalary() {

            return hourlyrate * hourlytime;
        }
    }

    class PayrollSystem {

        private ArrayList<Employee> employeelist;

        public PayrollSystem() {
            employeelist = new ArrayList<>();
        }

        public void addEmployee(Employee employee) {
            employeelist.add(employee);
        }

        public void removeemployee(int id) {
            Employee employeeToRemove = null;
            for (Employee employee : employeelist) {
                if (employee.getid() == id) {
                    employeeToRemove = employee;
                    break;
                }
            }
            if (employeeToRemove != null) {
                employeelist.remove(employeeToRemove);
            }
        }

        public void displayEmployees() {
            for (Employee employee : employeelist) {
                System.out.println(employee);
            }
        }
    }


    public class Main {
        public void main(String[] args) {
            PayrollSystem payrollsystem = new PayrollSystem();
            Parttimeemployee emp1 = new Parttimeemployee("vikash", 2, 200, 5);
            Fulltimeemployee emp2 = new Fulltimeemployee("deepanshu", 3, 50000);
            payrollsystem.addEmployee(emp1);
            payrollsystem.addEmployee(emp2);
            System.out.println("Display initial details ");
            payrollsystem.displayEmployees();
            System.out.println("Removing employee:- ");
            payrollsystem.removeemployee(2);
            System.out.println("Remaining Employee in list :-");
            payrollsystem.displayEmployees();

        }
    }
}

