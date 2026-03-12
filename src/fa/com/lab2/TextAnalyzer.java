package fa.com.lab2;

/**
 * Практика 2, Задание 4.1: wordCount, longestWord, reverseWords, countOccurrences, isPalindrome.
 */
public class TextAnalyzer {
    private final String text;

    public TextAnalyzer(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

    public int wordCount() {
        if (text == null || text.isBlank()) return 0;
        return text.trim().split("\\s+").length;
    }

    public String longestWord() {
        if (text == null || text.isBlank()) return "";
        String[] words = text.trim().split("\\s+");
        String longest = "";
        for (String w : words) {
            if (w.length() > longest.length()) longest = w;
        }
        return longest;
    }

    public String reverseWords() {
        if (text == null || text.isBlank()) return "";
        String[] words = text.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }

    public int countOccurrences(String target) {
        if (text == null || target == null || target.isEmpty()) return 0;
        String lower = text.toLowerCase();
        String t = target.toLowerCase();
        int count = 0;
        int idx = 0;
        while ((idx = lower.indexOf(t, idx)) >= 0) {
            count++;
            idx += t.length();
        }
        return count;
    }

    public boolean isPalindrome() {
        if (text == null) return false;
        String cleaned = text.replaceAll("[^a-zA-Zа-яА-ЯёЁ]", "").toLowerCase();
        int i = 0, j = cleaned.length() - 1;
        while (i < j) {
            if (cleaned.charAt(i++) != cleaned.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TextAnalyzer ta = new TextAnalyzer("Java Programming is Fun and Java is Powerful");
        System.out.println("Текст: " + ta);
        System.out.println("Слов: " + ta.wordCount());
        System.out.println("Самое длинное слово: " + ta.longestWord());
        System.out.println("Слова наоборот: " + ta.reverseWords());
        System.out.println("'Java' встречается: " + ta.countOccurrences("java") + " раз(а)");
        System.out.println("'is' встречается: " + ta.countOccurrences("is") + " раз(а)");
        System.out.println("Палиндром: " + ta.isPalindrome());
        System.out.println();

        TextAnalyzer palindrome = new TextAnalyzer("А роза упала на лапу Азора");
        System.out.println("Текст: " + palindrome);
        System.out.println("Палиндром: " + palindrome.isPalindrome());
    }
}
