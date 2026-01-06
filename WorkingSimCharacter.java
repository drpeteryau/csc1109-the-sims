/**
 * Represents a working Sim with a career.
 * Demonstrates inheritance and method overriding.
 */
public class WorkingSimCharacter extends SimCharacter {

    private String jobTitle;
    private int saving;

    /**
     * Constructor for a working Sim.
     *
     * @param name     Sim name
     * @param age      Sim age
     * @param jobTitle Job title
     * @param saving   Monthly salary
     */
    public WorkingSimCharacter(String name, int age, String jobTitle, int saving) {
        super(name, age); // call parent constructor
        this.jobTitle = jobTitle;
        this.saving = saving;
    }

    // ---------- Getters ----------
    public String getJobTitle() {
        return jobTitle;
    }

    public int getSaving() {
        return saving;
    }

    // ---------- Setters ----------
    public void setSaving(int salary) {
        this.saving += Math.max(0, Math.min(500, salary));
    }

    // ---------- Career Behaviour ----------
    public void work() {
        System.out.println(getName() + " goes to work as a " + jobTitle + ".");

        // Working consumes energy and increases hunger
        setEnergy(getEnergy() - 25);
        setHunger(getHunger() + 20);
        int salary = 500; // fixed monthly salary
        setSaving(salary);

        System.out.println("Earned $" + salary + " this month.");
    }

    /**
     * Override sleep behaviour:
     * A working Sim recovers less energy due to stress.
     */
    @Override
    public void sleep() {
        System.out.println(getName() + " sleeps after a long day at work.");

        // Custom sleep logic
        setEnergy(getEnergy() + 20); // less than base class
        setHunger(getHunger() + 15);
    }

    /**
     * Override status display to include career info.
     */
    @Override
    public void displayStatus() {
        super.displayStatus(); // reuse parent output
        System.out.println("Job    : " + jobTitle);
        System.out.println("Saving : $" + saving);
    }
}
