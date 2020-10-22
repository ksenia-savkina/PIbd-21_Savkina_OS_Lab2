package com.company;

import java.util.Random;

public class Thread {

    private final int tID;
    private int time;

    public Thread(int tID) {
        Random rnd = new Random();
        this.tID = tID;
        this.time = rnd.nextInt(25) + 5;
    }

    public int runTime(int number) {
        int k;
        if (number < time) {
            k = 0;
            time -= number;
        } else {
            k = number - time;
            time = 0;
        }
        return k;
    }

    public void launch() {
        System.out.println("Поток с ID = " + tID + " Выполнился за " + time);
    }

    public int getTime() {
        return time;
    }
}
