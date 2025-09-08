import java.util.Scanner;
import java.util.Random;

/*
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
*/

// ==============================
// Base Character class (Abstract)
// Demonstrates inheritance + information hiding
// ==============================
abstract class Character {
    // Private fields (information hiding)
    private String name;
    private String race;
    private int health;
    private int maxHealth;
    private int attackPower;
    private int mana;
    private int maxMana;

    // Constructor
    public Character(String name, String race, int health, int attackPower, int mana) {
        this.name = name;
        this.race = race;
        this.health = health;
        this.maxHealth = health;
        this.attackPower = attackPower;
        this.mana = mana;
        this.maxMana = mana;
    }

    // Getter methods (public interface)
    public String getName() { return name; }
    public String getRace() { return race; }
    public int getHealth() { return health; }
    public int getMaxHealth() { return maxHealth; }
    public int getAttackPower() { return attackPower; }
    public int getMana() { return mana; }
    public int getMaxMana() { return maxMana; }

    // Protected setters (encapsulation)
    protected void setHealth(int health) {
        this.health = Math.max(0, Math.min(health, maxHealth));
    }

    protected void setMana(int mana) {
        this.mana = Math.max(0, Math.min(mana, maxMana));
    }

    // Abstract methods (subclasses MUST implement these attacks)
    public abstract boolean normalAttack(Character target);
    public abstract boolean uniqueAttack(Character target);
    public abstract boolean specialAttack(Character target);
    public abstract boolean ultimateAttack(Character target);

    // Common methods for all characters
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) this.health = 0;
    }

    public boolean consumeMana(int amount) {
        if (this.mana >= amount) {
            this.mana -= amount;
            return true;
        }
        return false;
    }

    public void regenerateMana(int amount) {
        this.mana = Math.min(this.mana + amount, this.maxMana);
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public void displayStats() {
        System.out.println(getName() + " (" + getRace() + ") - HP: " + getHealth() + "/" + getMaxHealth() +
                ", MP: " + getMana() + "/" + getMaxMana() + ", Attack: " + getAttackPower());
    }
}

// ==============================
// Subclasses (Elf, Goblin, Orc, Human)
// ==============================
class Elf extends Character {
    public Elf(String name) {
        super(name, "Elf", 90, 20, 60);
    }
    @Override
    public boolean normalAttack(Character target) {
        int damage = this.getAttackPower();
        System.out.println(this.getName() + " shoots an arrow for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean uniqueAttack(Character target) {
        if (!consumeMana(10)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Precise Shot!");
            return false;
        }
        int damage = this.getAttackPower() + 5;
        System.out.println(this.getName() + " uses Precise Shot for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean specialAttack(Character target) {
        if (!consumeMana(20)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Nature’s Wrath!");
            return false;
        }
        int damage = this.getAttackPower() + 10;
        System.out.println(this.getName() + " casts Nature’s Wrath for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean ultimateAttack(Character target) {
        if (!consumeMana(35)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Storm of Arrows!");
            return false;
        }
        int damage = this.getAttackPower() + 20;
        System.out.println(this.getName() + " unleashes Storm of Arrows for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
}

class Goblin extends Character {
    public Goblin(String name) {
        super(name, "Goblin", 70, 15, 40);
    }
    @Override
    public boolean normalAttack(Character target) {
        int damage = this.getAttackPower();
        System.out.println(this.getName() + " stabs with a rusty knife for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean uniqueAttack(Character target) {
        if (!consumeMana(10)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Sneaky Strike!");
            return false;
        }
        int damage = this.getAttackPower() + 8;
        System.out.println(this.getName() + " uses Sneaky Strike for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean specialAttack(Character target) {
        if (!consumeMana(20)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Poison Dagger!");
            return false;
        }
        int damage = this.getAttackPower() + 12;
        System.out.println(this.getName() + " throws Poison Dagger for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean ultimateAttack(Character target) {
        if (!consumeMana(35)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Assassinate!");
            return false;
        }
        int damage = this.getAttackPower() + 25;
        System.out.println(this.getName() + " uses Assassinate for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
}

class Orc extends Character {
    public Orc(String name) {
        super(name, "Orc", 120, 25, 45);
    }
    @Override
    public boolean normalAttack(Character target) {
        int damage = this.getAttackPower();
        System.out.println(this.getName() + " swings a big axe for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean uniqueAttack(Character target) {
        if (!consumeMana(10)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Heavy Strike!");
            return false;
        }
        int damage = this.getAttackPower() + 5;
        System.out.println(this.getName() + " uses Heavy Strike for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean specialAttack(Character target) {
        if (!consumeMana(20)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Berserker Rage!");
            return false;
        }
        int damage = this.getAttackPower() + 10;
        System.out.println(this.getName() + " performs Berserker Rage for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean ultimateAttack(Character target) {
        if (!consumeMana(35)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Devastating Blow!");
            return false;
        }
        int damage = this.getAttackPower() + 15;
        System.out.println(this.getName() + " unleashes Devastating Blow for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
}

class Human extends Character {
    public Human(String name) {
        super(name, "Human", 100, 18, 50);
    }
    @Override
    public boolean normalAttack(Character target) {
        int damage = this.getAttackPower();
        System.out.println(this.getName() + " attacks with a sword for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean uniqueAttack(Character target) {
        if (!consumeMana(10)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Combo Strike!");
            return false;
        }
        int damage = this.getAttackPower() + 7;
        System.out.println(this.getName() + " uses Combo Strike for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean specialAttack(Character target) {
        if (!consumeMana(20)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Magic Blade!");
            return false;
        }
        int damage = this.getAttackPower() + 12;
        System.out.println(this.getName() + " casts Magic Blade for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
    @Override
    public boolean ultimateAttack(Character target) {
        if (!consumeMana(35)) {
            System.out.println(this.getName() + " doesn’t have enough mana for Hero’s Strike!");
            return false;
        }
        int damage = this.getAttackPower() + 18;
        System.out.println(this.getName() + " uses Hero’s Strike for " + damage + " damage!");
        target.takeDamage(damage);
        return true;
    }
}

// ==============================
// Main Game Class (with PvP vs PvC option)
// ==============================
public class SimpleRPGGame {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("      SIMPLE RPG BATTLE GAME");
        System.out.println("In this Players take turns selecting actions to attack each other to defeat the Opponent" );
        System.out.println("=================================");

        // Ask game mode
        System.out.println("\nCHOOSE GAME MODE:");
        System.out.println("1. Player vs Computer (PvC)");
        System.out.println("2. Player vs Player (PvP)");
        System.out.print("Enter choice (1 or 2): ");
        int mode = scanner.nextInt();

        // Create players
        System.out.println("\n==== CHOOSE YOUR PLAYER ====");
        Character player1 = chooseCharacter("Player 1");

        Character player2;
        if (mode == 1) { // Player vs Computer
            System.out.println("\n==== CHOOSE YOUR ENEMY (Computer Controlled) ====");
            player2 = chooseCharacter("Computer");
        } else { // Player vs Player
            System.out.println("\n==== CHOOSE YOUR ENEMY (Player 2) ====");
            player2 = chooseCharacter("Player 2");
        }

        // Start battle
        startBattle(player1, player2, mode);
    }

    // Character selection
    private static Character chooseCharacter(String playerName) {
        System.out.println("Select race for " + playerName + ":");
        System.out.println("1. Elf");
        System.out.println("2. Goblin");
        System.out.println("3. Orc");
        System.out.println("4. Human");
        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: return new Elf(playerName);
            case 2: return new Goblin(playerName);
            case 3: return new Orc(playerName);
            case 4: return new Human(playerName);
            default: return new Human(playerName);
        }
    }

    // Battle loop
    private static void startBattle(Character player1, Character player2, int mode) {
        System.out.println("\n=== BATTLE START ===");
        while (player1.isAlive() && player2.isAlive()) {
            System.out.println("\n-- Player 1's Turn --");
            takeTurn(player1, player2);

            if (!player2.isAlive()) break;

            System.out.println("\n-- " + player2.getName() + "'s Turn --");
            if (mode == 1 && player2.getName().equals("Computer")) {
                computerTurn(player2, player1);
            } else {
                takeTurn(player2, player1);
            }
        }

        // Result
        if (player1.isAlive()) {
            System.out.println("\n*** " + player1.getName() + " Wins! ***");
        } else {
            System.out.println("\n*** " + player2.getName() + " Wins! ***");
        }
    }

    // Player turn (manual choice)
    private static void takeTurn(Character attacker, Character target) {
        attacker.displayStats();
        target.displayStats();
        System.out.println("\nChoose Attack:");
        System.out.println("1. Normal Attack (Free)");
        System.out.println("2. Unique Attack (10 MP)");
        System.out.println("3. Special Attack (20 MP)");
        System.out.println("4. Ultimate Attack (35 MP)");
        System.out.println("5. Regenerate Mana (+8 MP)");
        System.out.print("Your choice: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1: attacker.normalAttack(target); break;
            case 2: attacker.uniqueAttack(target); break;
            case 3: attacker.specialAttack(target); break;
            case 4: attacker.ultimateAttack(target); break;
            case 5: attacker.regenerateMana(8);
                    System.out.println(attacker.getName() + " regenerates 8 mana!");
                    break;
            default: attacker.normalAttack(target); break;
        }
    }

    // Computer AI turn
    private static void computerTurn(Character computer, Character target) {
        Random rand = new Random();
        int choice = rand.nextInt(5) + 1; // random 1-5
        switch (choice) {
            case 1: computer.normalAttack(target); break;
            case 2: computer.uniqueAttack(target); break;
            case 3: computer.specialAttack(target); break;
            case 4: computer.ultimateAttack(target); break;
            case 5: computer.regenerateMana(8);
                    System.out.println(computer.getName() + " regenerates 8 mana!");
                    break;
        }
    }
}
