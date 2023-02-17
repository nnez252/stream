import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

 public class Main {


    public static void main(String[] args) {
        Stream<Integer> stream = new ArrayList<>(Arrays.asList(1, 2, 3, 5, 8, 10, 12)).stream();
        findMinMax(stream,
                (x, y) -> x.compareTo(y),
                (x, y) -> System.out.println(String.format(" min: %s, max: %s", x, y)));
        stream.close();
findEvenNumbers();
    }
        public static <T> void findMinMax(
                Stream<? extends T> stream,
                Comparator<? super T> order,
                BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> items = stream.sorted(order).collect(Collectors.toList());
            if (!items.isEmpty()) {
                minMaxConsumer.accept(items.get(0), items.get(items.size() - 1));
            } else {
                minMaxConsumer.accept(null, null);
            }
    }

    public static void findEvenNumbers() {
        List<Integer> al = new ArrayList<>();
        int number;
        number = ((int) (Math.random() * 100));
        al.add(number);
        System.out.println(al);
        int n2 = (int)(al.stream().filter((n)->(n%2)==0)).count();
        System.out.println("n2 = " + n2);
    }
}