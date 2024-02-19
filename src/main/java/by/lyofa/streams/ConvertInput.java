package by.lyofa.streams;

import java.util.Comparator;
import java.util.List;

public class ConvertInput {
   
    public static void main(String[] args) {
        final List<Integer> inputList = List.of(1, 3, 2, 4, 3, 1, 2);
        final List<Integer> outputArrayList = inputList.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println(outputArrayList);  // Output: [4, 3, 2, 1]
    }
    
}
