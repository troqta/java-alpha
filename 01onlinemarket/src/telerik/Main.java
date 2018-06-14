package telerik;

import java.io.ByteArrayInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static HashMap<String, Product> itemsMap = new HashMap<>();
    public static TreeSet<Product> products = new TreeSet<>(Comparator.comparing(Product::getPrice)
            .thenComparing(Product::getName)
            .thenComparing(Product::getType));
    public static HashMap<String, TreeSet<Product>> typeSets = new HashMap<>();


    public static void fakeInput() {

        String input = "add Milk 1.90 dairy\n" +
                "add Yogurt 1.90 dairy\n" +
                "add Notebook 1111.90 technology\n" +
                "add Orbit 0.90 food\n" +
                "add Rakia 11.90 drinks\n" +
                "add Dress 121.90 clothes\n" +
                "add Jacket 49.90 clothes\n" +
                "add Milk 1.90 dairy\n" +
                "add Eggs 2.34 food\n" +
                "add Cheese 5.55 dairy\n" +
                "filter by type clothes\n" +
                "filter by price from 1.00 to 2.00\n" +
                "add CappyOrange 1.99 juice \n" +
                "add Nestey 2.7 juice \n" +
                "filter by price from 1200\n" +
                "add Socks 2.90 clothes\n" +
                "filter by type fruits\n" +
                "add MacBookPro 1700.1234 technology\n" +
                "filter by price from 1200\n" +
                "filter by price from 1.50\n" +
                "filter by price to 2.00\n" +
                "filter by type clothes\n" +
                "end";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    public static void main(String[] args) {
        fakeInput();
        Scanner in = new Scanner(System.in);
        

        boolean hasEnded = false;
        while (true) {
            String nextLine = in.nextLine();
            String[] command = nextLine.split(" ");

            switch (command[0]) {
                case "add":
                    addProduct(command[1], Double.parseDouble(command[2]), command[3]);
                    break;
                case "filter":
                    switch (command[2]) {
                        case "type":
                            filterByType(command[3]);
                            break;
                        case "price":
                            switch (command[3]) {
                                case "to":
                                    filterByPriceFrom(0, Double.parseDouble(command[4]));
                                    break;
                                case "from":
                                    if (command.length == 7) {
                                        filterByPriceFrom(Double.parseDouble(command[4]), Double.parseDouble(command[6]));
                                    } else filterByPriceFrom(Double.parseDouble(command[4]), Double.MAX_VALUE);
                                    break;
                            }
                            break;
                    }
                    break;
                case "end":
                    return;
            }

        }

    }

    private static void addProduct(String name, double price, String type) {
        if (!itemsMap.containsKey(name)) {
            Product product = new Product(name, price, type);
            itemsMap.put(name, product);
            products.add(product);
            if (typeSets.containsKey(type)) {
                typeSets.get(type).add(product);
            } else {
                TreeSet<Product> itemsWithType = new TreeSet<>(Comparator.comparing(Product::getPrice)
                        .thenComparing(Product::getName)
                        .thenComparing(Product::getType));
                itemsWithType.add(product);
                typeSets.put(type, itemsWithType);
            }
            System.out.println("Ok: Product " + name + " added successfully");
        } else System.out.println("Error: Product " + name + " already exists");
    }

    private static void filterByType(String type) {


        if (typeSets.containsKey(type)) {

            String result = typeSets.get(type).stream()
                    .limit(10)
                    .map(Product::toString)
                    .collect(Collectors.joining(", "));
            System.out.println("Ok: " + result);
        }
        else System.out.println("Error: Type "+type+" does not exists");

    }

    private static void filterByPriceFrom(double price1, double price2) {
        String result = "";
        result = products.stream()
                .filter(x -> x.price >= price1 && x.price <= price2)
                .limit(10)
                .map(Product::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Ok: " + result);
    }

    private static void filterByPriceTo(double price) {
        String result = "";
        result = products.stream()
                .filter(x -> x.price <= price)
                .map(Product::toString)
                .collect(Collectors.joining(", "));
        System.out.println("Ok: " + result);

    }

    public static class Product {
        String name;
        double price;
        String type;

        public Product(String name, double price, String type) {
            this.name = name;
            this.price = price;
            this.type = type;
        }

        @Override
        public String toString() {
            return name + "(" + price + ")";
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getType() {
            return type;
        }
        //        @Override
//        public int compareTo(Object o) {
//            Product product = (Product) o;
//            return Double.compare(price, product.price);
//        }
    }
}
