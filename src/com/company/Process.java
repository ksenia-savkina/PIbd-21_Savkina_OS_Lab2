package com.company;

import java.util.Vector;

public class Process {
    private final int pID;
    private Vector<Thread> threads;
    private int extraTID = 0;

    public Process(int pID) {
        this.pID = pID;
        threads = new Vector<Thread>();
    }

    public void launch(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(getExtraTID()));
        }
    }

    public Thread createThread() {
        if (getSizeThread() > 0) {
            return threads.get(getSizeThread() - 1);
        }
        return null;
    }

    public void removeThread(Thread thread) {
        if (thread != null)
            threads.remove(thread);
    }

    private int getExtraTID() {
        extraTID++;
        return extraTID;
    }

    public int getPID() {
        return pID;
    }

    public int getSizeThread() {
        return threads.size();
    }
}
