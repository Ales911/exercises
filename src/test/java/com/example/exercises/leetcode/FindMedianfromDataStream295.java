package com.example.exercises.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FindMedianfromDataStream295 {

    class MedianFinder {

        List<Integer> list = new ArrayList<>();

        public MedianFinder() {
            list.clear();
        }

        public void addNum(int num) {
            list.add(num);
        }

        public double findMedian() {
            if (list.isEmpty()) {
                return 0;
            }
            if (list.size() == 1) {
                return list.get(0);
            }

            list.sort((v1, v2) -> v1 - v2);
            int len = list.size();
            return (len % 2 == 0) ? (list.get(len / 2) + list.get(len / 2 - 1)) / 2.0 : list.get(len / 2);
        }
    }

    class MedianFinderHash {

        Map<Integer, Integer> map = new HashMap<>();
        int size = 0;

        public MedianFinderHash() {
        }

        public void addNum(int num) {
            map.merge(num, 1, Integer::sum);
            size++;
        }

        public double findMedian() {

            double result = 0;

            if (map.isEmpty()) {
                return result;
            }
            if (map.size() == 1) {
                return map.keySet().iterator().next();
            }

            boolean even = size % 2 == 0;
            int middle = size / 2;

            List<Integer> keys = new ArrayList<>(map.keySet());
            Collections.sort(keys);
            int pred;
            int val = keys.get(0);
            int index = map.get(val) - 1;

            for (int i = 1; i < keys.size(); i++) {
                pred = val;
                val = keys.get(i);
                int count = map.get(val);
                index = index + count;

                if (index >= middle) {
                    if (even && middle - (index - count) == 1) {
                        result = (val + pred) / 2.0;
                    } else {
                        result = val;
                    }
                    break;
                }
            }
            return result;
        }
    }

    class MedianFinderTree {

        Map<Integer, Integer> map = new TreeMap<>();
        int size = 0;

        public MedianFinderTree() {
        }

        public void addNum(int num) {
            map.merge(num, 1, Integer::sum);
            size++;
        }

        public double findMedian() {

            double result = 0;

            if (map.isEmpty()) {
                return result;
            }
            if (map.size() == 1) {
                return map.keySet().iterator().next();
            }

            boolean even = size % 2 == 0;
            int middle = size / 2;

            Set<Integer> keys = map.keySet();
            int pred;
            // int val = keys.get(0);
            Iterator<Integer> iterator = keys.iterator();
            int val = iterator.next();
            int index = map.get(val) - 1;

            for (int i = 1; i < keys.size(); i++) {
                pred = val;
//                val = keys.get(i);
                val = iterator.next();
                int count = map.get(val);
                index = index + count;

                if (index >= middle) {
                    if (even && middle - (index - count) == 1) {
                        result = (val + pred) / 2.0;
                    } else {
                        result = val;
                    }
                    break;
                }
            }
            return result;
        }
    }

    // It is easy! You create two Priority Queues. One for the Left Queue (in reverse order), the other for the Right Queue (in natural order).
    class MedianFinderPriorityQueue {

        private final Queue<Integer> hi = new PriorityQueue<>();
        private final Queue<Integer> lo = new PriorityQueue<>((a, b) -> b.compareTo(a));

        public MedianFinderPriorityQueue() {
        }

        public void addNum(int num) {
            if (hi.isEmpty()) {
                hi.add(num);
                return;
            }
            if (num >= hi.peek()) {
                hi.add(num);
            } else {
                lo.add(num);
            }

            // keep size of hi either equal to lo or size of lo + 1
            if (lo.size() > hi.size()) {
                hi.add(lo.poll());
            } else {
                if (hi.size() > lo.size() + 1) {
                    lo.add(hi.poll());
                }
            }
        }

        public double findMedian() {
            return (hi.size() > lo.size()) ? hi.peek() : (lo.peek() + hi.peek()) / 2.0;
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder(); obj.addNum(num); double param_2 =
     * obj.findMedian();
     */
    @Test
    void test1() {
        MedianFinderHash medianFinder = new MedianFinderHash();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        Assertions.assertEquals(1.5, medianFinder.findMedian());
    }

    @Test
    void test3() {
        MedianFinderHash medianFinder = new MedianFinderHash();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
        Assertions.assertEquals(2, medianFinder.findMedian());
    }

    @Test
    void test6() {
        MedianFinderPriorityQueue medianFinder = new MedianFinderPriorityQueue();
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(6);
        medianFinder.addNum(6);
        Assertions.assertEquals(5.5, medianFinder.findMedian());
    }

    @Test
    void test6_2() {
        MedianFinderPriorityQueue medianFinder = new MedianFinderPriorityQueue();
        medianFinder.addNum(5);
        medianFinder.addNum(5);
        medianFinder.addNum(6);
        medianFinder.addNum(6);
        medianFinder.addNum(6);
        medianFinder.addNum(6);
        Assertions.assertEquals(6, medianFinder.findMedian());
    }

    @Test
    void test9() {
        MedianFinderPriorityQueue medianFinder = new MedianFinderPriorityQueue();
        medianFinder.addNum(6);
        Assertions.assertEquals(6, medianFinder.findMedian());
        medianFinder.addNum(10);
        Assertions.assertEquals(8, medianFinder.findMedian());
        medianFinder.addNum(2);
        Assertions.assertEquals(6, medianFinder.findMedian());
        medianFinder.addNum(6);
        Assertions.assertEquals(6, medianFinder.findMedian());
        medianFinder.addNum(5);
        Assertions.assertEquals(6, medianFinder.findMedian());
        medianFinder.addNum(0);
        Assertions.assertEquals(5.5, medianFinder.findMedian());
        medianFinder.addNum(6);
        Assertions.assertEquals(6, medianFinder.findMedian());
        medianFinder.addNum(3);
        Assertions.assertEquals(5.5, medianFinder.findMedian());
        medianFinder.addNum(1);
        Assertions.assertEquals(5, medianFinder.findMedian());
        medianFinder.addNum(0);
        Assertions.assertEquals(4, medianFinder.findMedian());
        medianFinder.addNum(0);
        Assertions.assertEquals(3, medianFinder.findMedian());
    }

    @Test
    void test99() {

        MedianFinderPriorityQueue medianFinder = new MedianFinderPriorityQueue();
        medianFinder.addNum(78);
        Assertions.assertEquals(78, medianFinder.findMedian());
        medianFinder.addNum(14);
        Assertions.assertEquals(46, medianFinder.findMedian());
        medianFinder.addNum(50);
        Assertions.assertEquals(50, medianFinder.findMedian());
        medianFinder.addNum(20);
        Assertions.assertEquals(35, medianFinder.findMedian());
        medianFinder.addNum(13);
        Assertions.assertEquals(20, medianFinder.findMedian());
        medianFinder.addNum(9);
        Assertions.assertEquals(17, medianFinder.findMedian());
        medianFinder.addNum(25);
        Assertions.assertEquals(20, medianFinder.findMedian());
        medianFinder.addNum(6);
        Assertions.assertEquals(17, medianFinder.findMedian());
        medianFinder.addNum(13);
        Assertions.assertEquals(14, medianFinder.findMedian());
        medianFinder.addNum(37);
        Assertions.assertEquals(17, medianFinder.findMedian());
        medianFinder.addNum(29);
        Assertions.assertEquals(20, medianFinder.findMedian());

        medianFinder.addNum(33);
        Assertions.assertEquals(22.5, medianFinder.findMedian());
        medianFinder.addNum(55);
        Assertions.assertEquals(25, medianFinder.findMedian());
        medianFinder.addNum(52);
        Assertions.assertEquals(27, medianFinder.findMedian());
        medianFinder.addNum(6);
        Assertions.assertEquals(25, medianFinder.findMedian());
        medianFinder.addNum(17);
        Assertions.assertEquals(22.5, medianFinder.findMedian());
        medianFinder.addNum(65);
        Assertions.assertEquals(25, medianFinder.findMedian());
        medianFinder.addNum(23);
        Assertions.assertEquals(24, medianFinder.findMedian());
        medianFinder.addNum(74);
        Assertions.assertEquals(25, medianFinder.findMedian());
        medianFinder.addNum(43);
        Assertions.assertEquals(27, medianFinder.findMedian());
        medianFinder.addNum(5);
        Assertions.assertEquals(25, medianFinder.findMedian());

        medianFinder.addNum(29);
        Assertions.assertEquals(27, medianFinder.findMedian());
        medianFinder.addNum(29);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(72);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(7);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(13);
        Assertions.assertEquals(27, medianFinder.findMedian());
        medianFinder.addNum(56);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(21);
        Assertions.assertEquals(27, medianFinder.findMedian());
        medianFinder.addNum(31);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(66);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(69);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(69);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(74);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(12);
        Assertions.assertEquals(29, medianFinder.findMedian());

        medianFinder.addNum(77);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(23);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(10);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(6);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(27);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(63);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(77);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(21);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(40);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(10);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(19);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(59);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(35);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(40);
        Assertions.assertEquals(29, medianFinder.findMedian());

        medianFinder.addNum(44);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(4);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(15);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(29);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(63);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(27);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(46);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(56);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(0);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(60);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(72);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(35);
        Assertions.assertEquals(30, medianFinder.findMedian());

        medianFinder.addNum(54);
        Assertions.assertEquals(31, medianFinder.findMedian());
        medianFinder.addNum(50);
        Assertions.assertEquals(32, medianFinder.findMedian());
        medianFinder.addNum(14);
        Assertions.assertEquals(31, medianFinder.findMedian());
        medianFinder.addNum(29);
        Assertions.assertEquals(30, medianFinder.findMedian());
        medianFinder.addNum(62);
        Assertions.assertEquals(31, medianFinder.findMedian());
        medianFinder.addNum(24);
        Assertions.assertEquals(30, medianFinder.findMedian());
        medianFinder.addNum(18);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(79);
        Assertions.assertEquals(30, medianFinder.findMedian());
        medianFinder.addNum(16);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(19);
        Assertions.assertEquals(29, medianFinder.findMedian());

        medianFinder.addNum(8);
        Assertions.assertEquals(29, medianFinder.findMedian());

        medianFinder.addNum(77);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(10);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(21);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(66);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(42);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(76);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(14);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(58);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(20);
        Assertions.assertEquals(29, medianFinder.findMedian());
        medianFinder.addNum(0);
        Assertions.assertEquals(29, medianFinder.findMedian());
    }

}
