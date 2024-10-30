import java.util.ArrayList;
import java.util.Scanner;

class MenuItem {
    String name;
    int price;

    public MenuItem(String name, int price) {
        this.name = name;
        this.price = price;
    }
}

class Order {
    MenuItem item;
    int quantity;

    public Order(MenuItem item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    //live template rumusx
    public int getTotalPrice() {
        return item.price * quantity;
    }
}

class RestaurantOrder {
    private static int queueNumber = 1;
    private ArrayList<Order> foodOrders = new ArrayList<>();
    private ArrayList<Order> drinkOrders = new ArrayList<>();
    private String customerName;
    private int totalAmount = 0;

    public RestaurantOrder(String customerName) {
        this.customerName = customerName;
        queueNumber++;
    }


    public void addFoodOrder(MenuItem food, int quantity) {
        foodOrders.add(new Order(food, quantity));
        totalAmount += food.price * quantity;
    }

    //live template rumusx2
    public void addDrinkOrder(MenuItem drink, int quantity) {
        drinkOrders.add(new Order(drink, quantity));
        totalAmount += drink.price * quantity;
    }

    public void printReceipt(int payment) {
        System.out.println("\t\t\t======= RECEIPT =======");
        System.out.println("\t\t\tNomor Antrian: " + queueNumber);
        System.out.println("\t\t\tNama Pemesan: " + customerName);
        System.out.println("\t\t\t------------------------");
        System.out.println("\t\t\tMakanan:");
        for (Order order : foodOrders) {
            System.out.println("\t\t\t- " + order.item.name + " x" + order.quantity + " = Rp " + order.getTotalPrice());
        }
        System.out.println("\t\t\tMinuman:");
        for (Order order : drinkOrders) {
            System.out.println("\t\t\t- " + order.item.name + " x" + order.quantity + " = Rp " + order.getTotalPrice());
        }
        System.out.println("\t\t\t-------------------------");
        System.out.println("\t\t\tTotal Belanja: Rp " + totalAmount);
        System.out.println("\t\t\t-------------------------");
        System.out.println("\t\t\tUang Bayar: Rp " + payment);
        System.out.println("\t\t\tKembalian: Rp " + (payment >= totalAmount ? payment - totalAmount : 0));
        System.out.println("\t\t\t======= THANK YOU =======");
    }

    public void totalAmount(){
        System.out.println("Total Harga: Rp "+ totalAmount);
    }

    public void ya(){
        System.out.println("Total Harga: Rp "+ totalAmount);
    }

    public class Example {
        public void featureX() {
            System.out.println("This is feature X");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu makanan
        MenuItem[] foodMenu = {
                new MenuItem("Sushi", 50000),
                new MenuItem("Ramen", 30000),
                new MenuItem("Katsudon", 40000),
                new MenuItem("Onigiri", 25000),
                new MenuItem("Sashimi", 30000)
        };

        // Menu minuman
        MenuItem[] drinkMenu = {
                new MenuItem("Kyoto Soup", 25000),
                new MenuItem("The Japanese Cocktail", 28000),
                new MenuItem("Sakura Lychee Fizz", 25000),
                new MenuItem("Mineral Water", 10000),
                new MenuItem("Yuzu Whiskey Sour", 25000)
        };

        System.out.print("Masukkan nama pemesan: ");
        String customerName = scanner.nextLine();

        RestaurantOrder order = new RestaurantOrder(customerName);

        // Pemesanan makanan
        boolean addMoreFood = true;
        while (addMoreFood) {
            System.out.println("\nPilih Makanan:");
            for (int i = 0; i < foodMenu.length; i++) {
                System.out.println((i + 1) + ". " + foodMenu[i].name + " - Rp " + foodMenu[i].price);
            }

            System.out.print("Pilih nomor makanan: ");
            int foodChoice = scanner.nextInt();
            System.out.print("Masukkan jumlah pesanan: ");
            int quantity = scanner.nextInt();
            order.addFoodOrder(foodMenu[foodChoice - 1], quantity);

            System.out.print("Apakah ingin menambah makanan lagi? (Y/N): ");
            addMoreFood = scanner.next().equalsIgnoreCase("Y");
        }

        // Pemesanan minuman
        boolean addMoreDrink = true;
        while (addMoreDrink) {
            System.out.println("\nPilih Minuman:");
            for (int i = 0; i < drinkMenu.length; i++) {
                System.out.println((i + 1) + ". " + drinkMenu[i].name + " - Rp " + drinkMenu[i].price);
            }

            System.out.print("Pilih nomor minuman: ");
            int drinkChoice = scanner.nextInt();
            System.out.print("Masukkan jumlah pesanan: ");
            int quantity = scanner.nextInt();
            order.addDrinkOrder(drinkMenu[drinkChoice - 1], quantity);

            System.out.print("Apakah ingin menambah minuman lagi? (Y/N): ");
            addMoreDrink = scanner.next().equalsIgnoreCase("Y");
        }

        order.totalAmount();
        order.totalAmount();

        System.out.print("\nMasukkan uang yang diberikan: Rp ");
        int payment = scanner.nextInt();


        // Cetak nota
        order.printReceipt(payment);
        order.printReceipt(payment);
    }
}