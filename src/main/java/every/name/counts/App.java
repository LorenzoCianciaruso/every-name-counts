/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package every.name.counts;

import java.util.List;

public class App {

    public static void main(String[] args) {
        List<String> strings = new TextExtractor().extractText();
        strings.forEach(System.out::println);
    }
}
