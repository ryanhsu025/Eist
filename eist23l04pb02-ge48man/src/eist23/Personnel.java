package eist23;

public class Personnel {
    private String name;
    private int age;
    private Roles role;

    public Personnel(String name, int age, Roles role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public void introduce() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Role: " + role);
    }

    public void transfer(Roles newRole) {
        System.out.println("Transferring " + name + " to " + newRole);
        role = newRole;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}

