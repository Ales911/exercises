package com.example.exercises.patterns;

/* Complex parts */
class CPU {

    public void freeze() {
        System.out.println("freeze");
    }

    public void jump(long position) {
        System.out.println("jump position = " + position);
    }

    public void execute() {
        System.out.println("execute");
    }
}

class Memory {

    public void load(long position, byte[] data) {
        System.out.println("load position = " + position + ", data = " + data);
    }
}

class HardDrive {

    public byte[] read(long lba, int size) {
        System.out.println("read lba = " + lba + ", size = " + size);
        return new byte[size];
    }
}

/* Facade */
class Computer {

    private final static long BOOT_ADDRESS = 1L;
    private final static long BOOT_SECTOR = 2L;
    private final static int SECTOR_SIZE = 3;

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public Computer() {
        this.cpu = new CPU();
        this.memory = new Memory();
        this.hardDrive = new HardDrive();
    }

    public void startComputer() {
        cpu.freeze();
        memory.load(BOOT_ADDRESS, hardDrive.read(BOOT_SECTOR, SECTOR_SIZE));
        cpu.jump(BOOT_ADDRESS);
        cpu.execute();
    }
}

public class Facade {

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.startComputer();
    }
}
