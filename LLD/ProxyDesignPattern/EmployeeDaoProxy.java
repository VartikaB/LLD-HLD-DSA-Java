package LLD.ProxyDesignPattern;

public class EmployeeDaoProxy implements EmployeeDao {
    private final EmployeeDaoImpl employeeDaoImpl;

    public EmployeeDaoProxy() {
        this.employeeDaoImpl = new EmployeeDaoImpl();
    }

    @Override
    public void createEmployee(String name, String position) {
        if(position.equalsIgnoreCase("Manager")) {
            System.out.println("Access denied: Cannot create employee with position 'Manager'");
            return;
        }
        employeeDaoImpl.createEmployee(name, position);
    }

    @Override
    public void updateEmployee(String ID, String name, String position) {
        if(position.equalsIgnoreCase("Manager")) {
            System.out.println("Access denied: Cannot update employee to position 'Manager'");
            return;
        }
        employeeDaoImpl.updateEmployee(ID, name, position);
    }

    @Override
    public void deleteEmployee(String ID) {
        if(ID.equalsIgnoreCase("1")) {
            System.out.println("Access denied: Cannot delete employee with ID '1'");
            return;
        }
        employeeDaoImpl.deleteEmployee(ID);
    }
}
