package LLD.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        EmployeeDao employeeDao = new EmployeeDaoProxy();
        employeeDao.createEmployee("Vartika", "Developer");
        employeeDao.updateEmployee("2", "Vartika", "Developer2");
        employeeDao.deleteEmployee("1");
        employeeDao.deleteEmployee("2");
    }
}
