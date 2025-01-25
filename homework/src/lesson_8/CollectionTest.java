package lesson_8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CollectionTest {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "pig", "cat", "rabbit", "lion", "dog", "monkey", "dog", "parrot", "bear", "tiger"};
        Map<String, Integer> countWord = new HashMap<>();

        for (String s : words) {
            countWord.put(s, countWord.getOrDefault(s, 0) + 1);
        }

        System.out.println("Каждое слово встречается:");
        for (String s : countWord.keySet()) {
            System.out.println(s + " " + countWord.get(s));
        }

        System.out.println("Список уникальных слов: ");
        for (String s : countWord.keySet()) {
            System.out.println(s);
        }
        PhoneBook book = new PhoneBook();
        book.add("Petrov","+375298758137");
        book.add("Trigubov","+375449087766");
        book.add("Petrov","+375298099900");
        book.add("Rusov","+375442339089");
         ArrayList<String> petrov=book.get("Petrov");
        System.out.println("Petrov");
         for(String s :petrov){
             System.out.println(s);
         }

    }
}