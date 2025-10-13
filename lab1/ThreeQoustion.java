public class ThreeQoustion {
    public static void main(String[] args) {
        Wagon w1 = new Wagon(50, 100.5);
        Wagon w2 = new Wagon(40, 120.0);
        Wagon w3 = new Wagon(60, 90.0);

        Train train = new Train(w1, w2, w3, 80, 90, 70);

        System.out.println("Реальный доход: " + train.actualRevenue());

        Wagon minWagon = train.wagonWithLeastExpectedRevenue();
        System.out.println("Вагон с наименьшей ожидаемой суммой продаж: " +
            minWagon.seats + " мест, цена билета " + minWagon.ticketPrice);

        SmallNumber num1 = new SmallNumber(1, 2, 3);
        SmallNumber num2 = new SmallNumber(8, 7, 6);
        SmallNumber sum = num1.add(num2);

        System.out.println("Сумма чисел: " + sum.toString());
    }
}

// Остальные классы без изменения, но без модификатора public
class Wagon {
    int seats;
    double ticketPrice;

    public Wagon(int seats, double ticketPrice) {
        this.seats = seats;
        this.ticketPrice = ticketPrice;
    }

    public double expectedRevenue() {
        return seats * ticketPrice;
    }
}

class Train {
    Wagon wagon1, wagon2, wagon3;
    int fillRate1, fillRate2, fillRate3;

    public Train(Wagon w1, Wagon w2, Wagon w3, int fill1, int fill2, int fill3) {
        this.wagon1 = w1;
        this.wagon2 = w2;
        this.wagon3 = w3;
        this.fillRate1 = fill1;
        this.fillRate2 = fill2;
        this.fillRate3 = fill3;
    }

    public double actualRevenue() {
        double r1 = wagon1.seats * wagon1.ticketPrice * fillRate1 / 100.0;
        double r2 = wagon2.seats * wagon2.ticketPrice * fillRate2 / 100.0;
        double r3 = wagon3.seats * wagon3.ticketPrice * fillRate3 / 100.0;
        return r1 + r2 + r3;
    }

    public Wagon wagonWithLeastExpectedRevenue() {
        double rev1 = wagon1.expectedRevenue();
        double rev2 = wagon2.expectedRevenue();
        double rev3 = wagon3.expectedRevenue();
        if (rev1 <= rev2 && rev1 <= rev3) return wagon1;
        if (rev2 <= rev1 && rev2 <= rev3) return wagon2;
        return wagon3;
    }
}

class SmallNumber {
    private int digit1;
    private int digit2;
    private int digit3;

    public SmallNumber(int digit1, int digit2, int digit3) {
        if (digit1 < 0 || digit1 > 9 || digit2 < 0 || digit2 > 9 || digit3 < 0 || digit3 > 9) {
            throw new IllegalArgumentException("Цифры должны быть от 0 до 9");
        }
        this.digit1 = digit1;
        this.digit2 = digit2;
        this.digit3 = digit3;
    }

    public int toInt() {
        return digit1 * 100 + digit2 * 10 + digit3;
    }

    public SmallNumber add(SmallNumber other) {
        int sum = this.toInt() + other.toInt();
        if (sum > 999) {
            return new SmallNumber(0, 0, 0);
        }
        int d1 = sum / 100;
        int d2 = (sum / 10) % 10;
        int d3 = sum % 10;
        return new SmallNumber(d1, d2, d3);
    }

    @Override
    public String toString() {
        return String.format("%d%d%d", digit1, digit2, digit3);
    }
}
