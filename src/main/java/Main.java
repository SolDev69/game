import javax.swing.*;

import static javax.swing.JFrame.*;

public class Main {
    static JFrame frame = new JFrame("Block Breaker");
    public static void main(String[] args) {


        Logger.log("hello, world!");

        BlockBreakerPanel panel = new BlockBreakerPanel();

        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        JOptionPane jOptionPane = new JOptionPane("");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setSize(500, 600);
        frame.setResizable(false);
    }
}
