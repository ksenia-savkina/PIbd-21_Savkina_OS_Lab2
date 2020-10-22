package com.company;

import java.util.Random;
import java.util.Vector;

public class Core {
    private Vector<Process> processes;

    public void plan() {
        int kvant = 20;
        while (processes.size() > 0) {
            Process process;
            Thread thread;
            int tempKvant;
            for (int i = 0; i < processes.size(); i++) {
                tempKvant = kvant;
                process = processes.get(i);
                System.out.println("Процесс с ID " + process.getPID() + " запустился");
                while (tempKvant > 0 && process.getSizeThread() > 0) {
                    System.out.println("Квант = " + tempKvant);
                    thread = process.createThread();
                    tempKvant = thread.runTime(tempKvant);
                    if (thread != null)
                        thread.launch();
                    if (thread.getTime() == 0)
                        process.removeThread(thread);
                }
                System.out.println("Процесс завершен");
                if (process.getSizeThread() == 0)
                    processes.remove(process);
                System.out.println();
            }
        }
    }

    public void createProcess() {
        Random rnd = new Random();
        processes = new Vector<Process>();
        for (int i = 0; i < rnd.nextInt(5) + 7; i++) {
            Process p = new Process(i);
            p.launch(rnd.nextInt(5) + 4);
            processes.add(p);
        }
    }
}
