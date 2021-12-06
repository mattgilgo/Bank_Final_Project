import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIDOS implements ActionListener{

    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel panel;

    public GUIDOS() {
        frame = new JFrame();
        JButton button = new JButton("Click me!");
        button.addActionListener(this);

        JLabel label = new JLabel("Number of clicks: 0");
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
        panel.setLayout(new GridLayout(0,1));
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Our GUI");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUIDOS();

        // JFrame frame1 = new JFrame();
        // JPanel p1 = new JPanel();
        // p1.setLayout(new GridLayout(4,3));
        // for (int i = 1; i <= 9; i++) {
        //     p1.add (new JButton("" + i));
        // }
        // p1.add (new JButton("" + 0));
        // p1.add (new JButton("Start"));
        // p1.add (new JButton("Stop"));

        // JPanel p2 = new JPanel(new BorderLayout());
        // p2.add(new JTextField("Time Display"), BorderLayout.NORTH);
        // p2.add(p1, BorderLayout.CENTER);
        // frame1.add(p1, BorderLayout.EAST);
        // frame1.add(new JButton("Food Display"), BorderLayout.CENTER);

        // frame1.setTitle("Window 1");
        // frame1.setSize(350,350);
        // frame1.setLocation(200,100);
        // frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame1.setVisible(true);

        // JButton button = new JButton("OK");
        // frame1.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        count++;
        label.setText("Number of clicks: " + count);
    }
}