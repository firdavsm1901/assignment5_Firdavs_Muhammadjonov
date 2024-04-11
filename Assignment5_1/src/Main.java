import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Character {
    private String name;
    private Appearance appearance;
    private List<Ability> abilities;
    private List<Equipment> equipment;
    private Map<String, Attribute> attributes;

    public Character(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes) {
        this.name = name;
        this.appearance = appearance;
        this.abilities = abilities;
        this.equipment = equipment;
        this.attributes = attributes;
    }

    public void updateAppearance(String newAppearanceDetails) {
        this.appearance.setAppearanceDetails(newAppearanceDetails);
    }

    public void addAbility(Ability newAbility) {
        this.abilities.add(newAbility);
    }

    public void removeAbility(Ability abilityToRemove) {
        this.abilities.remove(abilityToRemove);
    }

    public void addEquipment(Equipment newEquipment) {
        this.equipment.add(newEquipment);
    }

    public void removeEquipment(Equipment equipmentToRemove) {
        this.equipment.remove(equipmentToRemove);
    }

    public void updateAttribute(String attributeName, Object attributeValue) {
        if (attributes.containsKey(attributeName)) {
            attributes.get(attributeName).setValue(attributeValue);
        } else {
            throw new IllegalArgumentException("Attribute '" + attributeName + "' does not exist.");
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Appearance getAppearance() {
        return appearance;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Equipment> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = equipment;
    }

    public Map<String, Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Attribute> attributes) {
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Character: ").append(name).append("\n");
        sb.append("Appearance: ").append(appearance.getAppearanceDetails()).append("\n");
        sb.append("Abilities: ").append(abilities).append("\n");
        sb.append("Equipment: ").append(equipment).append("\n");
        sb.append("Attributes: ").append(attributes).append("\n");
        return sb.toString();
    }

}

abstract class CharacterFactory {
    public abstract Character createCharacter(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes);
}

class WarriorFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes) {
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class MageFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes) {
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}

class ArcherFactory extends CharacterFactory {
    @Override
    public Character createCharacter(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes) {
        return new Character(name, appearance, abilities, equipment, attributes);
    }
}


class Appearance {
    private String appearanceDetails;

    public Appearance(String appearanceDetails) {
        this.appearanceDetails = appearanceDetails;
    }

    public String getAppearanceDetails() {
        return appearanceDetails;
    }

    public void setAppearanceDetails(String appearanceDetails) {
        this.appearanceDetails = appearanceDetails;
    }

    @Override
    public String toString() {
        return appearanceDetails;
    }
}

class Ability {
    private String name;

    public Ability(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}

class Equipment {
    private String name;

    public Equipment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}

class Attribute {
    private String name;
    private Object value;

    public Attribute(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
class CharacterCreator {
    private CharacterFactory factory;

    public void setFactory(CharacterFactory factory) {
        this.factory = factory;
    }

    public Character createCharacter(String name, Appearance appearance, List<Ability> abilities, List<Equipment> equipment, Map<String, Attribute> attributes) {
        if (factory != null) {
            return factory.createCharacter(name, appearance, abilities, equipment, attributes);
        } else {
            throw new IllegalStateException("Factory not set.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        CharacterCreator creator = new CharacterCreator();

        creator.setFactory(new WarriorFactory());

        Character warrior = creator.createCharacter("Warrior Bob",
                new Appearance("Warrior's Appearance"),
                new ArrayList<>(List.of(new Ability("Warrior Ability 1"), new Ability("Warrior Ability 2"), new Ability("Warrior Ability 3"))),
                new ArrayList<>(List.of(new Equipment("Sword"), new Equipment("Shield"), new Equipment("Axe"))),
                Map.of("Strength", new Attribute("Strength ", 15), "Defense", new Attribute("Defense", 10)));

        creator.setFactory(new MageFactory());

        Character mage = creator.createCharacter("Mage Alice",
                new Appearance("Mage's Appearance"),
                new ArrayList<>(List.of(new Ability("Mage Ability 1"), new Ability("Mage Ability 2"), new Ability("Mage Ability 3"))),
                new ArrayList<>(List.of(new Equipment("Staff"), new Equipment("Robe"), new Equipment("Book"))),
                Map.of("Magic Power", new Attribute("Magic Power", 20), "Mana", new Attribute("Mana", 150)));

        creator.setFactory(new ArcherFactory());

        Character archer = creator.createCharacter("Archer Charlie",
                new Appearance("Archer's Appearance"),
                new ArrayList<>(List.of(new Ability("Archer Ability 1"), new Ability("Archer Ability 2"), new Ability("Archer Warrior 3"))),
                new ArrayList<>(List.of(new Equipment("Bow"), new Equipment("Quiver"))),
                Map.of("Dexterity", new Attribute("Dexterity", 18), "Accuracy", new Attribute("Accuracy", 95)));

        System.out.println("Warrior:");
        System.out.println(warrior);
        System.out.println("\nMage:");
        System.out.println(mage);
        System.out.println("\nArcher:");
        System.out.println(archer);

        warrior.updateAppearance("New Warrior Appearance");
        mage.addAbility(new Ability("New Mage Ability"));

        archer.removeEquipment(archer.getEquipment().get(0));

        warrior.updateAttribute("Strength", 20);

        System.out.println("\nUpdated Warrior Appearance: " + warrior.getAppearance());
        System.out.println("\nUpdated Mage Ability: " + mage.getAbilities());
        System.out.println("\nUpdated Archer Equipment: " + archer.getEquipment());

    }
}