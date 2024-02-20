package com.example.java1000._001_Not_deaf_phone;

class StepThread extends Thread {

    // общий для двух потоков lock
    private Object lock;

    public StepThread(Object object) {
        this.lock = object;
    }

    /**
     * Идея такая: выводим имя потока, потом поток засыпает, перед этим уведомив
     * другой поток, о том, что теперь его очередь.
     *
     * После вызова первым потоком lock.notify() второй поток не просыпается
     * сразу, а ждёт, пока lock не будет освобождён. А когда это происходит, уже
     * вызван метод lock.wait(), и первый поток ждёт своей очереди. И так по
     * кругу.
     */
    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    System.out.println(getName());
                    lock.notify();
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}