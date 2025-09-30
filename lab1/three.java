import java.util.Scanner;

// Вспомогательный класс Вагон
class Wagon {
    private int seats;      // количество мест
    private double ticketPrice;  // цена билета

    public void init() {
        seats = 0;
        ticketPrice = 0;
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество мест в вагоне:");
        seats = scanner.nextInt();
        System.out.println("Введите цену билета в вагоне:");
        ticketPrice = scanner.nextDouble();
        //scanner.close(); // Не закрываем scanner, чтобы не закрыть System.in
    }

    public void display() {
        System.out.println("Мест: " + seats + ", Цена билета: " + ticketPrice);
    }

    // Вычислить ожидаемую сумму от продажи всех билетов в вагоне
    public double expectedRevenue() {
        return seats * ticketPrice;
    }

    public int getSeats() {
        return seats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
}

// Основной класс Поезд
class Train {
    private String name;        // название поезда
    private Wagon wagon1;
    private Wagon wagon2;
    private Wagon wagon3;
    private int fill1;  // процент заполнения первого вагона
    private int fill2;  // второго
    private int fill3;  // третьего

    public void init() {
        name = "";
        wagon1 = new Wagon();
        wagon2 = new Wagon();
        wagon3 = new Wagon();
        fill1 = 0;
        fill2 = 0;
        fill3 = 0;
        wagon1.init();
        wagon2.init();
        wagon3.init();
    }

    public void read() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите название поезда:");
        name = scanner.nextLine();

        System.out.println("Ввод данных первого вагона:");
        wagon1.read();
        System.out.println("Введите процент заполнения первого вагона:");
        fill1 = scanner.nextInt();

        System.out.println("Ввод данных второго вагона:");
        wagon2.read();
        System.out.println("Введите процент заполнения второго вагона:");
        fill2 = scanner.nextInt();

        System.out.println("Ввод данных третьего вагона:");
        wagon3.read();
        System.out.println("Введите процент заполнения третьего вагона:");
        fill3 = scanner.nextInt();
    }

    public void display() {
        System.out.println("Поезд: " + name);
        System.out.print("Вагон 1: ");
        wagon1.display();
        System.out.println("Процент заполнения: " + fill1 + "%");
        System.out.print("Вагон 2: ");
        wagon2.display();
        System.out.println("Процент заполнения: " + fill2 + "%");
        System.out.print("Вагон 3: ");
        wagon3.display();
        System.out.println("Процент заполнения: " + fill3 + "%");
    }

    // Вычислить реальный доход от данного маршрута
    public double actualRevenue() {
        double revenue1 = wagon1.expectedRevenue() * fill1 / 100.0;
        double revenue2 = wagon2.expectedRevenue() * fill2 / 100.0;
        double revenue3 = wagon3.expectedRevenue() * fill3 / 100.0;
        return revenue1 + revenue2 + revenue3;
    }

    // Найти вагон с наименьшей ожидаемой суммой продаж
    public int wagonWithMinExpectedRevenue() {
        double r1 = wagon1.expectedRevenue();
        double r2 = wagon2.expectedRevenue();
        double r3 = wagon3.expectedRevenue();
        if (r1 <= r2 && r1 <= r3) return 1;
        else if (r2 <= r1 && r2 <= r3) return 2;
        else return 3;
    }

    public static void main(String[] args) {
        Train train = new Train();
        train.init();

        train.read();

        train.display();

        System.out.printf("Реальный доход по маршруту: %.2f%n", train.actualRevenue());

        int minWagon = train.wagonWithMinExpectedRevenue();
        System.out.println("Вагон с наименьшей ожидаемой суммой продаж: Вагон " + minWagon);
    }
}
