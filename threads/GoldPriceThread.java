package threads;
import service.ThreadService;
import service.ThreadServiceImplement;

public class GoldPriceThread implements Runnable {
    ThreadService threadService = new ThreadServiceImplement();

    @Override
    public void run() {
        threadService.updatePrice("./resource/gold.txt");
    }
}