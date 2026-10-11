package LLD.ProxyDesignPattern;
public interface EmployeeDao {
    public void createEmployee(String name, String position);
    public void updateEmployee(String ID , String name, String position);
    public void deleteEmployee(String ID);
}
