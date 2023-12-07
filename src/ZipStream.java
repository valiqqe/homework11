import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class ZipStream {

    public static void main(String[] args) {
        Stream<Integer> firstStream = Stream.of(1, 2, 3, 4);
        Stream<Integer> secondStream = Stream.of(5, 6, 7, 8, 9);

        Stream<Integer> zippedStream = zip(firstStream, secondStream);
        zippedStream.forEach(System.out::println);
    }

    public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iteratorFirst = first.iterator();
        Iterator<T> iteratorSecond = second.iterator();

        Iterator<T> zippedIterator = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return iteratorFirst.hasNext() || iteratorSecond.hasNext();
            }

            @Override
            public T next() {
                if (iteratorFirst.hasNext()) {
                    T elementFirst = iteratorFirst.next();
                    return iteratorSecond.hasNext() ? elementFirst : null;
                } else if (iteratorSecond.hasNext()) {
                    return iteratorSecond.next();
                } else {
                    throw new NoSuchElementException();
                }
            }
        };

        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(zippedIterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }
}