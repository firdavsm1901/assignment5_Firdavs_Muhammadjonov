import java.util.*;

class Furniture {
    private String name;
    private String style;
    private String material;
    private float price;

    public Furniture(String name, String style, String material, float price) {
        this.name = name;
        this.style = style;
        this.material = material;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
abstract class FurnitureFactory {
    public abstract Chair createChair();
    public abstract Table createTable();
    public abstract Sofa createSofa();
}
class Chair {
    private String name;
    private float price;

    public Chair(String name, float price) {
        this.name = name;
        this.price = price;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
class Table {
    private String name;
    private float price;

    public Table(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
class Sofa {
    private String name;
    private float price;

    public Sofa(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
class ModernWoodFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Modern Wood Chair", 150.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Modern Wood Table", 300.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Modern Wood Sofa", 500.0f);
    }
}
class TraditionalMetalFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Traditional Metal Chair", 120.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Traditional Metal Table", 250.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Traditional Metal Sofa", 450.0f);
    }
}
class IndustrialGlassFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Industrial Glass Chair", 180.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Industrial Glass Table", 350.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Industrial Glass Sofa", 550.0f);
    }
}
class ModernMetalFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Modern Metal Chair", 170.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Modern Metal Table", 320.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Modern Metal Sofa", 520.0f);
    }
}

class TraditionalWoodFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Traditional Wood Chair", 130.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Traditional Wood Table", 280.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Traditional Wood Sofa", 480.0f);
    }
}

class TraditionalGlassFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Traditional Glass Chair", 160.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Traditional Glass Table", 330.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Traditional Glass Sofa", 530.0f);
    }
}

class IndustrialWoodFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Industrial Wood Chair", 190.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Industrial Wood Table", 340.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Industrial Wood Sofa", 540.0f);
    }
}

class IndustrialMetalFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Industrial Metal Chair", 200.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Industrial Metal Table", 350.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Industrial Metal Sofa", 550.0f);
    }
}

class ModernGlassFactory extends FurnitureFactory {
    @Override
    public Chair createChair() {
        return new Chair("Modern Glass Chair", 180.0f);
    }

    @Override
    public Table createTable() {
        return new Table("Modern Glass Table", 330.0f);
    }

    @Override
    public Sofa createSofa() {
        return new Sofa("Modern Glass Sofa", 530.0f);
    }
}


class FurnitureCreator {
    private FurnitureFactory factory;

    public void setFactory(FurnitureFactory factory) {
        this.factory = factory;
    }

    public Chair createChair() {
        return factory.createChair();
    }

    public Table createTable() {
        return factory.createTable();
    }

    public Sofa createSofa() {
        return factory.createSofa();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Available Styles:");
        System.out.println("1. Modern");
        System.out.println("2. Traditional");
        System.out.println("3. Industrial");

        System.out.print("Enter style number: ");
        int styleChoice = scanner.nextInt();
        System.out.println();
        System.out.println("Available Materials:");
        System.out.println("1. Wood");
        System.out.println("2. Metal");
        System.out.println("3. Glass");
        System.out.print("Enter material number: ");
        int materialChoice = scanner.nextInt();

        FurnitureFactory factory = createFactory(styleChoice, materialChoice);
        if (factory != null) {
            FurnitureCreator furnitureCreator = new FurnitureCreator();
            furnitureCreator.setFactory(factory);

            Chair chair = furnitureCreator.createChair();
            Table table = furnitureCreator.createTable();
            Sofa sofa = furnitureCreator.createSofa();

            System.out.println("\nAvailable Products:");
            System.out.println("Chair: " + chair.getName() + ", Price: $" + chair.getPrice());
            System.out.println("Table: " + table.getName() + ", Price: $" + table.getPrice());
            System.out.println("Sofa: " + sofa.getName() + ", Price: $" + sofa.getPrice());
            System.out.println("\nSelect the type of furniture you want to create:");
            System.out.println("1. Chair");
            System.out.println("2. Table");
            System.out.println("3. Sofa");
            System.out.print("Enter the number of the furniture type: ");
            int furnitureChoice = scanner.nextInt();
            System.out.println();
            switch (furnitureChoice) {
                case 1:
                    System.out.println("Created Chair: " + chair.getName() + ", Price: $" + chair.getPrice());
                    break;
                case 2:
                    System.out.println("Created Table: " + table.getName() + ", Price: $" + table.getPrice());
                    break;
                case 3:
                    System.out.println("Created Sofa: " + sofa.getName() + ", Price: $" + sofa.getPrice());
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid number.");
            }

        } else {
            System.out.println("Invalid style or material choice.");
        }


    }
    public static FurnitureFactory createFactory(int styleChoice, int materialChoice) {
        switch (styleChoice) {
            case 1:
                switch (materialChoice) {
                    case 1: return new ModernWoodFactory();
                    case 2: return new ModernMetalFactory();
                    case 3: return new ModernGlassFactory();
                    default: return null;
                }
            case 2:
                switch (materialChoice) {
                    case 1: return new TraditionalWoodFactory();
                    case 2: return new TraditionalMetalFactory();
                    case 3: return new TraditionalGlassFactory();
                    default: return null;
                }
            case 3:
                switch (materialChoice) {
                    case 1: return new IndustrialWoodFactory();
                    case 2: return new IndustrialMetalFactory();
                    case 3: return new IndustrialGlassFactory();
                    default: return null;
                }
            default: return null;
        }
    }
}
