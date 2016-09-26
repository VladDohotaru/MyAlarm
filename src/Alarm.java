
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.time.LocalDateTime;

public class Alarm extends JFrame implements ActionListener {
    private JButton button;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JTextField hour;
    private JTextField min;


    public  Alarm() {
        label1 = new JLabel("set hour");
        panel1 = new JPanel(new FlowLayout());
        label2 = new JLabel("set minute:");
        hour = new JTextField(10);
        min = new JTextField(10);
        panel1.add(label1);
        panel1.add(hour);
        panel1.add(label2);
        panel1.add(min);
        new JFrame("My Alarm ( Pezdos Alarm)");
        setLayout(new FlowLayout());
        add(panel1);
        button = new JButton("SET");
        add(button);
        button.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int wakeupHour = 0;
        int wakeUpMinute = 0;
        if(e.getSource() == button) {
            wakeupHour = Integer.parseInt(hour.getText());
            wakeUpMinute = Integer.parseInt(min.getText());
        }
        while(true) {
            if(wakeupHour == LocalDateTime.now().getHour() && wakeUpMinute == LocalDateTime.now().getMinute()) {
                new Player().playSound();
                break;
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Alarm();
            }
        });
    }
}