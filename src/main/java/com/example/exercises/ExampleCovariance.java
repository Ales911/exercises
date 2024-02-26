package com.example.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ExampleCovariance {

    public static void main(String[] args) {
        
        Integer i4 = 4;
        
        // Stream<Integer> s1 =  Stream.of(1,2,3);
//        List<? super Number> l1 = s1.toList();
//        List<Integer> lInteger = l1;

    
//        List<? extends Number> l1 = List.of(1,2,3);
//        l1.add(1);
//        l1.add(2);
//        l1.add(3);
        
//        List<Integer> l2 = List.of(11, 22, 33);

//        l1 = l2;
        
        
//        System.out.println(l1.getClass().getName());

         List<? super Number> l11 = new ArrayList<>();
         l11.add(11);
         l11.add(Long.valueOf(44));
         l11.add(null);
        System.out.println(l11.get(1).getClass().getName());


    }

}
