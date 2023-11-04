
import java.util.ArrayList;
import java.util.List;


// Employee class
class Employee {
    private String name;
    private List<Administrator> administrators;

    public Employee(String name) {
        this.name = name;
        this.administrators = new ArrayList<>();
    }

    public void addAdministrator(Administrator administrator) {
        administrators.add(administrator);
    }

    public void removeAdministrator(Administrator administrator) {
        administrators.remove(administrator);
    }

    public void listAdministrators() {
        System.out.println("Administrators for Employee " + name + ".");
        for (Administrator admin : administrators) {
            System.out.println(admin.getName());
        }
    }

    public String getName() {
        return name;
    }
}

