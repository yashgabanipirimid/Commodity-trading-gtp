package threads;

import service.ThreadService;
import service.ThreadServiceImplement;

import java.io.*;

public class SilverPriceThread implements Runnable {
    ThreadService threadService = new ThreadServiceImplement();

    @Override
    public void run() {
        threadService.updatePrice("./resource/oil.txt");
    }
}