package LLD.ProxyDesignPattern;

public class EmployeeDaoImpl implements EmployeeDao{
    public void createEmployee(String name, String position) {
        System.out.println("Creating employee {name: " + name + ", position: " + position + "}");
    }
    public void updateEmployee(String ID , String name, String position) {
        System.out.println("Updating employee {ID: " + ID + ", name: " + name + ", position: " + position + "}");
    }
    public void deleteEmployee(String ID) {
        System.out.println("Deleting employee {ID: " + ID + "}");
    }
    
}
