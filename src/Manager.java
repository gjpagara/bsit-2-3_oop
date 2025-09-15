public class Manager extends Employee {
    private double bonus;
    private int teamSize;

    public Manager(String name, int employeeId, double baseSalary, String department, double bonus, int teamSize) {
        super(name, employeeId, baseSalary, department); // Call parent constructor
        this.bonus = bonus;
        this.teamSize = teamSize;
        System.out.println(name + " has been promoted to Manager");
    }

    @Override
    public double calculateSalary() {
        return super.calculateSalary() + bonus; // Base + Bonus
    }

    @Override
    public void work() {
        super.work(); // Call parent work method
        System.out.println(name + " is managing a team of " + teamSize + " employees");
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); // Display parent info
        System.out.println("Bonus: $" + bonus);
        System.out.println("Team Size: " + teamSize);
    }
}
