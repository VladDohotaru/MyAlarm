import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class Alarm extends JFrame implements ActionListener {
    Player alarm;
    private JButton setButton;
    private JButton stopButton;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel1;
    private JComboBox hour;
    private JComboBox min;
    private String wakeUpHour;
    private String wakeUpMinute;


    public  Alarm() {
        alarm = new Player();
        String validHours[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                                "17", "18", "19", "20", "21", "22", "23"};
        String validMinutes[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
                "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27","28","29","30",
                "31", "32", "33", "34", "35", "36", "37","38","39","40", "41", "42", "43", "44", "45", "46", "47","48","49","50",
                "51", "52", "53", "54", "55", "56", "57","58","59"};

        label1 = new JLabel("set hour");
        panel1 = new JPanel(new FlowLayout());
        label2 = new JLabel("set minute:");
        hour = new JComboBox<>(validHours);
        hour.setEditable(true);
        hour.addActionListener(this);
        min = new JComboBox<>(validMinutes);
        min.setEditable(true);
        min.addActionListener(this);
        panel1.add(label1);
        panel1.add(hour);
        panel1.add(label2);
        panel1.add(min);
        new JFrame("My Alarm");
        setLayout(new FlowLayout());
        add(panel1);
        setButton = new JButton("SET");
        stopButton = new JButton("STOP");
        add(setButton);
        add(stopButton);
        setButton.addActionListener(this);
        stopButton.addActionListener(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(400, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == min) {
            wakeUpMinute = min.getSelectedItem().toString();
            System.out.println(wakeUpMinute);
        }
        if(e.getSource() == hour) {
            wakeUpHour = hour.getSelectedItem().toString();
            System.out.println(wakeUpHour);
        }
        if(e.getSource() == setButton) {
            while (true) {
                if (Integer.parseInt(wakeUpHour) == LocalDateTime.now().getHour() && Integer.parseInt(wakeUpMinute) == LocalDateTime.now().getMinute()) {
                    alarm.playSound();
                    break;
                }
            }
        }
        if(e.getSource() == stopButton) {
            alarm.stopSound();
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch(InstantiationException e) {
            e.printStackTrace();
        } catch(IllegalAccessException e) {
            e.printStackTrace();
        }
        Runnable task1 = () -> {
            System.out.println("Running thread: " + Thread.currentThread().getName() + " with lambda! ");
            new Alarm();
        };
//        Runnable task2 = () -> {
//            System.out.println("Running second pharralel " + Thread.currentThread().getName() + "thread task !");
//            new Alarm();
//        };
        new Thread(task1).start();
//        new Thread(task2).start();
    }
}