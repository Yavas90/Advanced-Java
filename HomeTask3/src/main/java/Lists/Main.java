package Lists;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List wordList = new ArrayList<String>();

        wordList.add("Moscov");
        wordList.add("SPB");
        wordList.add("Paris");
        wordList.add("Pekin");
        wordList.add("Berlin");
        wordList.add("Dubai");
        wordList.add("SPB");
        wordList.add("Barcelona");
        wordList.add("Madrid");
        wordList.add("Paris");

        words(wordList);
        System.out.println(" ");
        task2();

    }

    public static void words(List<String> wordList) {
        Map<String, Integer> wordsWithCount = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++) {
            String word = wordList.get(i);
            if (!wordsWithCount.containsKey(word)) {
                wordsWithCount.put(word, 1);
            } else {
                wordsWithCount.put(word, wordsWithCount.get(word) + 1);
            }
        }
        Object[] wordsWithCountEntries = wordsWithCount.entrySet().toArray();
        for (int i = 0; i < wordsWithCountEntries.length; i++) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) wordsWithCountEntries[i];
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void task2() {

        PhoneList phoneList = new PhoneList();

        phoneList.add("Kirill", "79181992345");
        phoneList.add("Petr", "79181991245");
        phoneList.add("Stepan", "79181292345");
        phoneList.add("Fedor", "79181992345");
        phoneList.add("Stepan", "79181592314");
        phoneList.add("Ilya", "79181992317");
        phoneList.add("Viktor", "79181163084");

        System.out.println(phoneList.get("Kirill"));
        System.out.println(phoneList.get("Petr"));
        System.out.println(phoneList.get("Stepan"));
        System.out.println(phoneList.get("Fedor"));
        System.out.println(phoneList.get("Ilya"));
        System.out.println(phoneList.get("Viktor"));
    }
}
