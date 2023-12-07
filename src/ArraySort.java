import java.util.Arrays;
import java.util.stream.Collectors;

public class ArraySort {
    public static void main(String[] args) {
        String[] array = {"1, 2, 0", "4, 5"};
        String result = getSortedNumbers(array);
        System.out.println(result);
    }
    public static String getSortedNumbers(String[] array) {
        String result = Arrays.stream(array)
                .flatMap(s -> Arrays.stream(s.split(",\\s*")))
                .map(String::trim)
                .sorted()
                .collect(Collectors.joining(", "));
        return result;
    }
}
