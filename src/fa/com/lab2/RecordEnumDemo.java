package fa.com.lab2;

/**
 * Практика 2, Задание 5.2: Temperature record + Unit, MathOperation enum с абстрактным apply.
 */
public class RecordEnumDemo {
    public enum Unit { CELSIUS, FAHRENHEIT, KELVIN }

    public record Temperature(double value, Unit unit) {
        public Temperature {
            double k = toKelvin(value, unit);
            if (k < 0) throw new IllegalArgumentException("Temperature below absolute zero");
        }

        private static double toKelvin(double v, Unit u) {
            return switch (u) {
                case CELSIUS -> v + 273.15;
                case FAHRENHEIT -> (v - 32) * 5 / 9.0 + 273.15;
                case KELVIN -> v;
            };
        }

        public Temperature convertTo(Unit target) {
            double k = toKelvin(value, unit);
            double out = switch (target) {
                case CELSIUS -> k - 273.15;
                case FAHRENHEIT -> (k - 273.15) * 9 / 5 + 32;
                case KELVIN -> k;
            };
            return new Temperature(out, target);
        }

        @Override
        public String toString() {
            return switch (unit) {
                case CELSIUS -> String.format("%.2f °C", value);
                case FAHRENHEIT -> String.format("%.2f °F", value);
                case KELVIN -> String.format("%.2f K", value);
            };
        }
    }

    public enum MathOperation {
        ADD { @Override public double apply(double a, double b) { return a + b; } },
        SUBTRACT { @Override public double apply(double a, double b) { return a - b; } },
        MULTIPLY { @Override public double apply(double a, double b) { return a * b; } },
        DIVIDE { @Override public double apply(double a, double b) {
            if (b == 0) throw new ArithmeticException("division by zero");
            return a / b;
        } };
        public abstract double apply(double a, double b);
    }

    public static void main(String[] args) {
        Temperature body = new Temperature(36.6, Unit.CELSIUS);
        System.out.println(body);
        System.out.println(body.convertTo(Unit.FAHRENHEIT));
        System.out.println(body.convertTo(Unit.KELVIN));
        System.out.println();

        double a = 10, b = 3;
        for (MathOperation op : MathOperation.values()) {
            System.out.printf("%s(%g, %g) = %g%n", op.name(), a, b, op.apply(a, b));
        }
    }
}
