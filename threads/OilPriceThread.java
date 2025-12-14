package threads;

import service.ThreadService;
import service.ThreadServiceImplement;

import java.io.*;
public class OilPriceThread implements Runnable {
    ThreadService threadService = new ThreadServiceImplement();

    @Override
    public void run() {
        threadService.updatePrice("./resource/silver.txt");
    }
}