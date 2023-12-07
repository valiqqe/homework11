package arrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Ivan"));
        people.add(new Person("Peter"));
        people.add(new Person("John"));
        people.add(new Person("Mary"));
        people.add(new Person("Alice"));

        String result = firstEx(people);
        System.out.println(result);

        List<String> result2 = secondEx(people.stream().map(Person::getName).collect(Collectors.toList()));
        result2.forEach(System.out::println);
    }

    public static String firstEx(List<Person> people) {
        String result = IntStream.range(0, people.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(i -> (i + 1) + ". " + people.get(i).getName())
                .collect(Collectors.joining(", "));

        return result;
    }
    public static List<String> secondEx(List<String> strings) {
        List<String> upperCaseStrings = strings.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        Collections.sort(upperCaseStrings, Collections.reverseOrder());
        return upperCaseStrings;
    }
}
