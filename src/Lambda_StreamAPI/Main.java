package Lambda_StreamAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int[] arr = new int[10];
        List<Integer> list = new ArrayList<Integer>();

        fillArray(arr, list);

        System.out.println(list);
        System.out.println(Arrays.toString(arr));

        //filter()
//        list = list.stream()
//                .filter(a -> a % 2 == 0)
//                .collect(Collectors.toList());
//
//        arr = Arrays.stream(arr)
//                .filter(a -> a % 2 != 0)
//                .toArray();

        //map(), reduce()
        int reducedList = list.stream()
                .map(a -> a * 2)
                .filter(a -> a % 2 == 0)
                .reduce((acc, el) -> acc + el).get();

        int reducedArray = Arrays.stream(arr)
                .map(a -> a * 2)
                .filter(a -> a % 4 == 0)
                .reduce((acc, el) -> acc * el)
                .getAsInt();

        System.out.println(reducedList);
        System.out.println(reducedArray);
    }

    private static void fillArray(int[] arr, List<Integer> list) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
            list.add(i + 1);
        }
    }
}
