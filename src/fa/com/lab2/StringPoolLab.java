package fa.com.lab2;

/**
 * Практика 2, Задание 4.2: String Pool — s1..s7 разными способами, сравнение == и equals.
 * Перед каждым сравнением напишите в комментарии прогноз.
 */
public class StringPoolLab {
    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        String s5 = s3.intern();
        String s6 = "Hel" + "lo";
        String half = "Hel";
        String s7 = half + "lo";

        // s1 == s2: оба литералы, один объект в пуле -> true
        System.out.println("s1 == s2: " + (s1 == s2) + ", equals: " + s1.equals(s2));

        // s1 == s3: s3 в куче -> false
        System.out.println("s1 == s3: " + (s1 == s3) + ", equals: " + s1.equals(s3));

        // s3 == s4: два разных new -> false
        System.out.println("s3 == s4: " + (s3 == s4) + ", equals: " + s3.equals(s4));

        // s1 == s5: s5 = s3.intern() возвращает ссылку из пула -> true
        System.out.println("s1 == s5: " + (s1 == s5) + ", equals: " + s1.equals(s5));

        // s1 == s6: конкатенация литералов, константа времени компиляции -> true
        System.out.println("s1 == s6: " + (s1 == s6) + ", equals: " + s1.equals(s6));

        // s1 == s7: half + "lo" создаёт новый объект в runtime -> false
        System.out.println("s1 == s7: " + (s1 == s7) + ", equals: " + s1.equals(s7));

        StringBuilder sb = new StringBuilder();
        sb.append('H').append('e').append('l').append('l').append('o');
        String fromSb = sb.toString();
        System.out.println("fromSb == s1: " + (fromSb == s1) + ", equals: " + fromSb.equals(s1));
    }
}
