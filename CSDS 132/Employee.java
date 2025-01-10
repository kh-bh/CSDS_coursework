import java.util.Arrays;
/* A class to represent employees at a company */
public class Employee implements Comparable<Employee> {
 
  // a field storing the employee name
  private String name;
  
  // a field storing the employee salary
  private double salary;
  
  // a field storing the employee id number
  private int number;
  
  // a field storing the last employee number used
  private static int lastNumberUsed = 0;
  
  /* a constructor that sets the name of the employee */
  public Employee(String name) {
    this(Employee.lastNumberUsed + 1, name);
    /*
    super();
    this.name = name;
    this.number = Employee.lastNumberUsed + 1;
    Employee.lastNumberUsed = this.number;
    */
  }
  
  /* a constructor that sets the name and number for an employee */
  public Employee(int number, String name) {
    super();
    this.name = name;
    this.number = number;
    if (this.number > Employee.lastNumberUsed)
      Employee.lastNumberUsed = this.number;
  }
  
  /* get the name of the employee */
  public String getName() {
    return this.name;
  }
  
  /* set the name of the employee */
  public void setName(String name) {
    this.name = name;
  }
  
  /* get the salary of the employee */
  public double getSalary() {
    return this.salary;
  }
  
  /* change the salary of the employe */
  public void setSalary(double salary) {
    this.salary = salary;
  }
  
  /* get the number of the employee */
  public int getNumber() {
    return this.number;
  }
  
  /* Change how the inherited toString method works to give the Employee number
   * and name */
  public String toString() {
    return this.getNumber() + ": " + this.getName();
  }
  
  /* Change how the inherited equals method works so two employees will be the
   * same if they have the same number */
  public boolean equals(Object o) {
    if (o instanceof Employee) {
      Employee e = (Employee)o;
      return this.getNumber() == e.getNumber();
    }
    else
      return false;
  }
  
  /* return true if this employee earns more than employee e */
  public boolean earnsMoreThan(Employee e) {
    return this.getSalary() > e.getSalary();
  }
  
  /**
   * Required by the Comparable interface.
   * Employee default ordering is by employee number.
   * @param e the employee to order with this employee
   * @return < 0, > 0 or = 0 if this employee is ordered before, after or the same as e, respectively.
   */
  public int compareTo(Employee e){
    /*
    if (e.getNumber() > this.getNumber())
      return -1;
    else if (e.getNumber() < this.getNumber())
      return 1;
    else
      return 0;
      */
    return this.getNumber() - e.getNumber();
  }
  
  public static Comparator<Employee> compareByName() {
    return new Comparator<Employee>() {
      public int compare(Employee e1, Employee e2) {
        return e1.getName().comapareTo(e2.getName());
      }
    };
  }
  
  /** A nested class that compares two employees by salary */
  public static Comparator<Employee> compareBySalary() {
    return new CompareBySalary();
  }
  
  private static class CompareBySalary implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2) {
      return (int)((e1.getSalary() - e2.getSalary()) *100);
    }
  }
  
  public Comparator<Employee> compareToThisSalary() {
    return this.new CompareSalaryToThisEmployee();
  }
  
  /** A nested class that compares two employees by how close their salary is to this employee */
  public class CompareSalaryToThisEmployee implements Comparator<Employee> {
    public int compare(Employee e1, Employee e2){
      int compareTo1 = (int)Math.abs((Employee.this.getSalary() - e1.getSalary())*100);
      int compareTo2 = (int)Math.abs((Employee.this.getSalary() - e2.getSalary())*100);
      return compareTo1 - compareTo2;
    }
  }
}