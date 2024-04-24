package com.example.exercises.threads;

import static java.lang.Thread.sleep;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Lighter {

    static class Foo {

        final CopyOnWriteArrayList<String> out;

        Foo(CopyOnWriteArrayList<String> out) {
            this.out = out;
        }

        void first() {
            out.add("first");
        }

        void second() {
            out.add("second");
        }

        void third() {
            out.add("third");
        }

    }
    
    void lighter1() throws InterruptedException {
        var out = new CopyOnWriteArrayList<String>();
        var foo = new Foo(out);

        var third = new Thread(() -> foo.third());

        var second = new Thread(() -> {
            try {
                third.join();
                foo.second();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lighter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        var first = new Thread(() -> {
            try {
                second.join();
                foo.first();
            } catch (InterruptedException ex) {
                Logger.getLogger(Lighter.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        first.start();
        second.start();
        third.start();

        Thread.sleep(500);

        System.out.println(out);
    }

    AtomicBoolean bFirst = new AtomicBoolean(true);
    
    List<String> lighter2() throws InterruptedException {
        var out = new CopyOnWriteArrayList<String>();

        var first = new Thread(() -> {
            int count = 1;
            while (count <= 3) {
                if (bFirst.get()) {
                    out.add("first");
                    bFirst.getAndSet(false);
                    count++;
                } else {
                    Thread.yield();
                }
            }
        });

        var second = new Thread(() -> {
            int count = 1;
            while (count <= 3) {
                if (!bFirst.get()) {
                    out.add("second");
                    bFirst.getAndSet(true);
                    count++;
                } else {
                    Thread.yield();
                }
            }
        });

        first.start();
        second.start();

        Thread.sleep(50);

        System.out.println(out);

        return out;
    }

    public static void main(String[] args) throws InterruptedException {

        // new Lighter().lighter1();
        new Lighter().lighter2();

    }

}
