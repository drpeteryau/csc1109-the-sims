/**
 * Represents a Sim character in the CLI Sims game.
 */
public class SimCharacter {

    private String name;
    private int age;
    private int hunger;   // 0 = full, 100 = starving
    private int energy;   // 0 = exhausted, 100 = fully rested

    /**
     * Constructor for SimCharacter.
     *
     * @param name Sim name
     * @param age  Sim age
     */
    public SimCharacter(String name, int age) {
        this.name = name;
        this.age = age;
        this.hunger = 50;
        this.energy = 50;
    }

    // ---------- Getters ----------
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getHunger() {
        return hunger;
    }

    public int getEnergy() {
        return energy;
    }

    // ---------- Setters ----------
    public void setHunger(int hunger) {
        this.hunger = Math.max(0, Math.min(100, hunger));
    }

    public void setEnergy(int energy) {
        this.energy = Math.max(0, Math.min(100, energy));
    }

    // ---------- Behaviours ----------
    public void eat() {
        setHunger(hunger - 20);
        System.out.println(name + " eats a meal. Hunger decreases.");
    }

    public void sleep() {
        setEnergy(energy + 30);
        setHunger(hunger + 10);
        System.out.println(name + " sleeps and feels rested.");
    }

    public void displayStatus() {
        System.out.println("\n--- Sim Status ---");
        System.out.println("Name   : " + name);
        System.out.println("Age    : " + age);
        System.out.println("Hunger : " + hunger);
        System.out.println("Energy : " + energy);
    }
}
