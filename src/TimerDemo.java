import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by peter on 2/18/16.
 *
 * This is an example of using an ActionListener in
 * conjunction with a timer. You may find this useful in
 * implementing your slideshow.
 *
 */
public class TimerDemo {
    protected int time;
    protected Timer timer;
    protected ActionListener timerListener;

    public TimerDemo()
    {
        time = 0;

        timerListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time += 1;

                if (time <= 10) {
                    System.out.println("listener time: " + time);
                } else {
                    System.out.println("listener complete");
                    timer.stop();
                }
            }
        };
    }

    public void startTimer() {
        // slideshowListener is called every 1000 milliseconds (1 second)
        timer = new Timer(1000, timerListener );
        System.out.print("listener starting...");
        timer.start();
    }

    public static void main(String[] args) {
        System.out.println("welcome to the timer demo\n");
        TimerDemo t = new TimerDemo();
        t.startTimer();
        System.out.println("listener started.");
    }
}