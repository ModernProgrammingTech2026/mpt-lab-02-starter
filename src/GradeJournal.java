

/**
 * Практика 2, Задание 3.2: зубчатый массив оценок, average, min, max, лучший студент.
 */
public class GradeJournal {

    public static double average(int[] grades) {
        if (grades == null || grades.length == 0) return 0;
        int sum = 0;
        for (int g : grades) sum += g;
        return (double) sum / grades.length;
    }

    public static int max(int[] grades) {
        if (grades == null || grades.length == 0) return 0;
        int m = grades[0];
        for (int g : grades) if (g > m) m = g;
        return m;
    }

    public static int min(int[] grades) {
        if (grades == null || grades.length == 0) return 0;
        int m = grades[0];
        for (int g : grades) if (g < m) m = g;
        return m;
    }

    public static void main(String[] args) {
        String[] names = {"Алиса", "Борис", "Вера", "Глеб"};
        int[][] grades = {
            {5, 4, 5, 5, 3},
            {3, 3, 4},
            {5, 5, 5, 5, 5, 4},
            {4, 3, 4, 5}
        };

        System.out.println("=== Журнал оценок ===");
        double bestAvg = -1;
        String bestName = "";

        for (int i = 0; i < names.length; i++) {
            double avg = average(grades[i]);
            System.out.printf("%-6s | Оценок: %d | Средний: %.2f | Мин: %d | Макс: %d%n",
                names[i], grades[i].length, avg, min(grades[i]), max(grades[i]));
            if (avg > bestAvg) {
                bestAvg = avg;
                bestName = names[i];
            }
        }

        System.out.printf("%nЛучший студент: %s (средний балл: %.2f)%n", bestName, bestAvg);
    }
}
