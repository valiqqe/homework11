package Random;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomAlgStream {
    public static void main(String[] args) {
        RandomAlg ra = new RandomAlg();
        Stream<Integer> iterate1 = Stream.iterate(485222, (seed) -> ra.withSeed(seed).next());
        Stream<Integer> iterate2 = Stream.iterate(485222, (seed) -> ra.withSeed(seed).next());

        List<Integer> collect1 = iterate1
                //.peek(System.out::println)
                .limit(10)
                .collect(Collectors.toList());

        List<Integer> collect2 = iterate2
                //.peek(System.out::println)
                .limit(8)
                .collect(Collectors.toList());

        Stream<Integer> res;
        Stream<Integer> stream1 = collect1.stream();
        Iterator<Integer> iterator = stream1.iterator();
        Stream<Integer> stream2 = collect2.stream();


        List<Integer> collect = stream2.map(i -> {
                    if (iterator.hasNext()) {
                        return List.of(i, iterator.next());
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(collect.size());
        System.out.println();
        for (int i : collect) {
            System.out.println(i);
        }

    }
}
