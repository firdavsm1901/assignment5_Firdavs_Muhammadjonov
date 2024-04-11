import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a character class:");
        System.out.println("1. Warrior");
        System.out.println("2. Mage");
        System.out.println("3. Archer");
        System.out.print("Enter the number corresponding to your choice: ");
        int classChoice = scanner.nextInt();
        scanner.nextLine();
        String characterClass;
        switch (classChoice) {
            case 1:
                characterClass = "Warrior";
                break;
            case 2:
                characterClass = "Mage";
                break;
            case 3:
                characterClass = "Archer";
                break;
            default:
                System.out.println("Invalid choice. Defaulting to Warrior.");
                characterClass = "Warrior";
        }

        System.out.println("\nChoose a weapon type:");
        switch (characterClass) {
            case "Warrior":
                System.out.println("1. Sword");
                System.out.println("2. Axe");
                System.out.println("3. Hammer");
                break;
            case "Mage":
                System.out.println("1. Staff");
                System.out.println("2. Wand");
                System.out.println("3. Book");
                break;
            case "Archer":
                System.out.println("1. Bow");
                System.out.println("2. Crossbow");
                System.out.println("3. Longbow");
                break;
            default:
                System.out.println("Invalid character class.");
                return;
        }
        System.out.print("Enter the number corresponding to your choice: ");
        int weaponChoice = scanner.nextInt();
        scanner.nextLine();
        CharacterFactory factory = createFactory(characterClass, weaponChoice);
        if (factory != null) {
            CharacterCreator characterCreator = new CharacterCreator();
            characterCreator.setFactory(factory);
            Character character = characterCreator.createCharacter("Player", characterClass);
            Weapon weapon = character.getWeapon();

            System.out.println("\nCharacter created:");
            System.out.println("Name: " + character.getName());
            System.out.println("Class: " + character.getCharacterClass());
            System.out.println("Health: " + character.getHealth());
            System.out.println("Mana: " + character.getMana());
            System.out.println("Weapon: " + weapon.getType());
            System.out.println("Damage: " + weapon.getDamage());
            System.out.println("Speed: " + weapon.getSpeed());
            System.out.println("Range: " + weapon.getRange());

        } else {
            System.out.println("Invalid character class or weapon choice.");
        }

        scanner.close();
    }

    public static CharacterFactory createFactory(String characterClass, int weaponChoice) {
        switch (characterClass) {
            case "Warrior":
                switch (weaponChoice) {
                    case 1:
                        return new WarriorSwordFactory();
                    case 2:
                        return new WarriorAxeFactory();
                    case 3:
                        return new WarriorHammerFactory();
                    default:
                        return null;
                }
            case "Mage":
                switch (weaponChoice) {
                    case 1:
                        return new MageStaffFactory();
                    case 2:
                        return new MageWandFactory();
                    case 3:
                        return new MageBookFactory();
                    default:
                        return null;
                }
            case "Archer":
                switch (weaponChoice) {
                    case 1:
                        return new ArcherBowFactory();
                    case 2:
                        return new ArcherCrossbowFactory();
                    case 3:
                        return new ArcherLongbowFactory();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }
}

class Character {
    private String name;
    private String characterClass;
    private Weapon weapon;
    private int health;
    private int mana;

    public Character(String name, String characterClass, Weapon weapon, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.weapon = weapon;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}

class Weapon {
    private String type;
    private int damage;
    private int speed;
    private int range;

    public Weapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}

class ConcreteCharacter {
    private String name;
    private String characterClass;
    private int health;
    private int mana;

    public ConcreteCharacter(String name, String characterClass, int health, int mana) {
        this.name = name;
        this.characterClass = characterClass;
        this.health = health;
        this.mana = mana;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterClass() {
        return characterClass;
    }

    public void setCharacterClass(String characterClass) {
        this.characterClass = characterClass;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }
}

class ConcreteWeapon {
    private String type;
    private int damage;
    private int speed;
    private int range;

    public ConcreteWeapon(String type, int damage, int speed, int range) {
        this.type = type;
        this.damage = damage;
        this.speed = speed;
        this.range = range;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}


abstract class CharacterFactory {
    public abstract Character createCharacter(String name, String characterClass);
    public abstract List<Weapon> getAvailableWeapons();
}

class WarriorSwordFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Sword", 20, 10, 5);
        return new Character(name, characterClass, weapon, 100, 50);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Sword", 20, 10, 5));
        return weapons;
    }
}

class WarriorAxeFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Axe", 25, 8, 4);
        return new Character(name, characterClass, weapon, 100, 50);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Axe", 25, 8, 4));
        return weapons;
    }
}

class WarriorHammerFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Hammer", 22, 9, 6);
        return new Character(name, characterClass, weapon, 100, 50);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Hammer", 22, 9, 6));
        return weapons;
    }
}

class MageStaffFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Staff", 15, 15, 10);
        return new Character(name, characterClass, weapon, 80, 100);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Staff", 15, 15, 10));
        return weapons;
    }
}

class MageWandFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Wand", 18, 12, 8);
        return new Character(name, characterClass, weapon, 80, 100);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Wand", 18, 12, 8));
        return weapons;
    }
}

class MageBookFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Book", 12, 10, 12);
        return new Character(name, characterClass, weapon, 80, 100);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Book", 12, 10, 12));
        return weapons;
    }
}

class ArcherBowFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Bow", 25, 8, 20);
        return new Character(name, characterClass, weapon, 90, 70);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Bow", 25, 8, 20));
        return weapons;
    }
}

class ArcherCrossbowFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Crossbow", 30, 7, 18);
        return new Character(name, characterClass, weapon, 90, 70);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Crossbow", 30, 7, 18));
        return weapons;
    }
}

class ArcherLongbowFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, String characterClass) {
        Weapon weapon = new Weapon("Longbow", 22, 9, 22);
        return new Character(name, characterClass, weapon, 90, 70);
    }

    @Override
    public List<Weapon> getAvailableWeapons() {
        List<Weapon> weapons = new ArrayList<>();
        weapons.add(new Weapon("Longbow", 22, 9, 22));
        return weapons;
    }
}

class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name, String characterClass) {
        if (factory == null) {
            throw new IllegalStateException("CharacterFactory has not been set.");
        }

        return factory.createCharacter(name, characterClass);
    }
}
