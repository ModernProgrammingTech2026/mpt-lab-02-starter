package fa.com.lab2;

import java.util.*;

/**
 * Практика 2, Задание 5.1: enum Grade, record Student, EnumMap, EnumSet.
 */
public class GradeSystem {

    public enum Grade {
        A("Отлично", 4.0),
        B("Хорошо", 3.0),
        C("Удовлетворительно", 2.0),
        D("Неудовлетворительно", 1.0),
        F("Провал", 0.0);

        private final String description;
        private final double gpaValue;

        Grade(String description, double gpaValue) {
            this.description = description;
            this.gpaValue = gpaValue;
        }

        public String getDescription() { return description; }
        public double getGpaValue() { return gpaValue; }

        public boolean isPassing() {
            return this != F && this != D;
        }

        public static Grade fromScore(int score) {
            if (score >= 90) return A;
            if (score >= 80) return B;
            if (score >= 70) return C;
            if (score >= 60) return D;
            return F;
        }
    }

    public record Student(String name, int id) {
        public Student {
            if (name == null || name.isBlank()) throw new IllegalArgumentException("name must not be null or empty");
            if (id <= 0) throw new IllegalArgumentException("id must be positive");
        }
    }

    public static void main(String[] args) {
        List<Student> students = List.of(
            new Student("Алиса", 1),
            new Student("Борис", 2),
            new Student("Вера", 3),
            new Student("Глеб", 4),
            new Student("Дарья", 5)
        );
        int[] scores = {95, 72, 88, 65, 91};

        EnumMap<Grade, List<Student>> byGrade = new EnumMap<>(Grade.class);
        for (Grade g : Grade.values()) {
            byGrade.put(g, new ArrayList<>());
        }

        double totalGpa = 0;
        int count = 0;
        for (int i = 0; i < students.size(); i++) {
            Grade g = Grade.fromScore(scores[i]);
            byGrade.get(g).add(students.get(i));
            totalGpa += g.getGpaValue();
            count++;
        }

        EnumSet<Grade> passing = EnumSet.noneOf(Grade.class);
        for (Grade g : Grade.values()) {
            if (g.isPassing()) passing.add(g);
        }
        System.out.println("Проходные оценки: " + passing);

        for (Grade g : Grade.values()) {
            List<Student> list = byGrade.get(g);
            if (!list.isEmpty()) {
                System.out.println(g + " (" + g.getDescription() + "): " + list + " — " + list.size() + " чел.");
            }
        }

        System.out.printf("Средний GPA: %.2f%n", totalGpa / count);
    }
}
