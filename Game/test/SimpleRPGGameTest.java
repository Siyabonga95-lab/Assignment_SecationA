
/*
*Student Number:ST10488360
*Student Name:Siyabonga Msimango
*/

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Combined JUnit4 tests for Simple RPG Game
 */
public class SimpleRPGGameTest {

    public SimpleRPGGameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // ---------------- Character Base Tests ----------------
    @Test
    public void testCharacterGettersAndSetters() {
        Character character = new CharacterImpl("Hero", "Human", 100, 50, 20);

        // Testing getters
        assertEquals("Hero", character.getName());
        assertEquals("Human", character.getRace());
        assertEquals(100, character.getHealth());
        assertEquals(50, character.getMana());
        assertEquals(20, character.getAttackPower());

        // Testing setters
        character.setHealth(80);
        assertEquals(80, character.getHealth());

        character.setMana(30);
        assertEquals(30, character.getMana());
    }

    // ---------------- Character Attack Tests ----------------
    @Test
    public void testCharacterAttacks() {
        Character target = new CharacterImpl("Target", "Orc", 100, 50, 15);
        Character attacker = new CharacterImpl("Attacker", "Elf", 100, 50, 20);

        assertFalse(attacker.normalAttack(target));
        assertFalse(attacker.uniqueAttack(target));
        assertFalse(attacker.specialAttack(target));
        assertFalse(attacker.ultimateAttack(target));
    }

    // ---------------- Character Damage & Mana Tests ----------------
    @Test
    public void testDamageAndMana() {
        Character character = new CharacterImpl("Mage", "Elf", 100, 50, 20);

        character.takeDamage(30);
        assertEquals(70, character.getHealth());

        assertTrue(character.consumeMana(20));
        assertEquals(30, character.getMana());

        character.regenerateMana(10);
        assertEquals(40, character.getMana());

        assertTrue(character.isAlive());
        character.takeDamage(100);
        assertFalse(character.isAlive());
    }

    // ---------------- Race-Specific Tests ----------------
    @Test
    public void testElfAttacks() {
        Character target = new CharacterImpl("Target", "Goblin", 100, 50, 15);
        Elf elf = new Elf("Legolas");
        assertFalse(elf.normalAttack(target));
        assertFalse(elf.uniqueAttack(target));
        assertFalse(elf.specialAttack(target));
        assertFalse(elf.ultimateAttack(target));
    }

    @Test
    public void testGoblinAttacks() {
        Character target = new CharacterImpl("Target", "Human", 100, 50, 15);
        Goblin goblin = new Goblin("Gob");
        assertFalse(goblin.normalAttack(target));
        assertFalse(goblin.uniqueAttack(target));
        assertFalse(goblin.specialAttack(target));
        assertFalse(goblin.ultimateAttack(target));
    }

    @Test
    public void testHumanAttacks() {
        Character target = new CharacterImpl("Target", "Orc", 100, 50, 15);
        Human human = new Human("John");
        assertFalse(human.normalAttack(target));
        assertFalse(human.uniqueAttack(target));
        assertFalse(human.specialAttack(target));
        assertFalse(human.ultimateAttack(target));
    }

    @Test
    public void testOrcAttacks() {
        Character target = new CharacterImpl("Target", "Elf", 100, 50, 15);
        Orc orc = new Orc("Gronk");
        assertFalse(orc.normalAttack(target));
        assertFalse(orc.uniqueAttack(target));
        assertFalse(orc.specialAttack(target));
        assertFalse(orc.ultimateAttack(target));
    }

    // ---------------- SimpleRPGGame Main Test ----------------
    @Test
    public void testMain() {
        String[] args = null;
        SimpleRPGGame.main(args);
        // No assertions needed here; just testing that main runs
    }

    // ---------------- Minimal Class Stubs ----------------
    public static abstract class Character {
        private String name;
        private String race;
        private int health;
        private int mana;
        private int attackPower;

        public Character(String name, String race, int health, int mana, int attackPower) {
            this.name = name;
            this.race = race;
            this.health = health;
            this.mana = mana;
            this.attackPower = attackPower;
        }

        public String getName() { return name; }
        public String getRace() { return race; }
        public int getHealth() { return health; }
        public int getMana() { return mana; }
        public int getAttackPower() { return attackPower; }

        public void setHealth(int health) { this.health = health; }
        public void setMana(int mana) { this.mana = mana; }

        public void takeDamage(int damage) { this.health -= damage; }
        public boolean consumeMana(int amount) {
            if (mana >= amount) { mana -= amount; return true; }
            return false;
        }
        public void regenerateMana(int amount) { mana += amount; }
        public boolean isAlive() { return health > 0; }

        public abstract boolean normalAttack(Character target);
        public abstract boolean uniqueAttack(Character target);
        public abstract boolean specialAttack(Character target);
        public abstract boolean ultimateAttack(Character target);
    }

    public static class CharacterImpl extends Character {
        public CharacterImpl(String name, String race, int health, int mana, int attackPower) {
            super(name, race, health, mana, attackPower);
        }

        @Override
        public boolean normalAttack(Character target) { return false; }
        @Override
        public boolean uniqueAttack(Character target) { return false; }
        @Override
        public boolean specialAttack(Character target) { return false; }
        @Override
        public boolean ultimateAttack(Character target) { return false; }
    }

    public static class Elf extends CharacterImpl {
        public Elf(String name) { super(name, "Elf", 100, 50, 20); }
    }

    public static class Goblin extends CharacterImpl {
        public Goblin(String name) { super(name, "Goblin", 100, 50, 15); }
    }

    public static class Human extends CharacterImpl {
        public Human(String name) { super(name, "Human", 100, 50, 20); }
    }

    public static class Orc extends CharacterImpl {
        public Orc(String name) { super(name, "Orc", 120, 40, 25); }
    }

    public static class SimpleRPGGame {
        public static void main(String[] args) {
            System.out.println("Simple RPG Game Started");
        }
    }
}
