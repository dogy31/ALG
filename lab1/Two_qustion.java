public class TwoQustion {
    private int digit1; // сотни
    private int digit2; // десятки
    private int digit3; // единицы

    public Two_qustion(int digit1, int digit2, int digit3) {
        // Проверка корректности цифр (от 0 до 9)
        if (digit1 < 0 || digit1 > 9 || digit2 < 0 || digit2 > 9 || digit3 < 0 || digit3 > 9) {
            throw new IllegalArgumentException("Digits must be between 0 and 9");
        }
        this.digit1 = digit1;
        this.digit2 = digit2;
        this.digit3 = digit3;
    }

    // Метод преобразования в обычное целое число
    public int toInt() {
        return digit1 * 100 + digit2 * 10 + digit3;
    }

    // Метод сложения двух SmallNumber с проверкой переполнения
    public SmallNumber add(SmallNumber other) {
        int sum = this.toInt() + other.toInt();
        if (sum > 999) { // переполнение
            return new SmallNumber(0, 0, 0); // нуль
        }
        int d1 = sum / 100;
        int d2 = (sum / 10) % 10;
        int d3 = sum % 10;
        return new SmallNumber(d1, d2, d3);
    }

    // Для удобства - вывод числа в строку
    @Override
    public String toString() {
        return String.format("%d%d%d", digit1, digit2, digit3);
    }

    // Пример использования
    public static void main(String[] args) {
        SmallNumber n1 = new SmallNumber(1, 2, 3);
        SmallNumber n2 = new SmallNumber(8, 7, 6);
        SmallNumber sum = n1.add(n2);

        System.out.println("n1 = " + n1.toInt());       // 123
        System.out.println("n2 = " + n2.toInt());       // 876
        System.out.println("sum = " + sum.toInt());     // 999

        SmallNumber n3 = new SmallNumber(9, 9, 9);
        SmallNumber n4 = new SmallNumber(0, 0, 1);
        SmallNumber sum2 = n3.add(n4);

        System.out.println("sum2 = " + sum2.toInt());   // 0 (переполнение)
    }
}
