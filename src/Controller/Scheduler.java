package Controller;

import java.util.Timer;
import java.util.TimerTask;

public class Scheduler {
  private Timer timer;
    private int executionInterval;

    public Scheduler(TimerTask timerTask) {
        executionInterval = 3000;
        timer = new Timer();
        timer.scheduleAtFixedRate(timerTask,0,executionInterval);
    }


    public void terminateTimer(){
        timer.cancel();
    }
}
