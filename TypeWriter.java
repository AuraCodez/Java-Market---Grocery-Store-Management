import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class TypeWriter {
    private Timer timer;
    private JLabel label;
    private int index;
    private String text;

    public TypeWriter(JLabel label, String text, int delay) {
        this.label = label;
        this.text = text;
        this.index = 0;

        timer = new Timer(60, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (index < text.length()) {
                    label.setText(text.substring(0, index + 1));
                    index++;
                } else {
                    timer.stop();
                }
            }

        });

    }

    public void start() {
        timer.start();
    }

}
