// view.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class view extends JPanel 
{
    private JTextField display;
    private controller calcController;

    public static void main(String[] args) 
    {
        JFrame frame = new JFrame("Calculadora");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        view calculator = new view();
        frame.add(calculator);

        frame.setVisible(true);
    }

    public view() 
    {
        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setPreferredSize(new Dimension(400, 50));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        String[] buttonLabels = 
        {
            "7", "8", "9", "/", 
            "4", "5", "6", "*", 
            "1", "2", "3", "-", 
            "0", ".", "=", "+"
        };

        calcController = new controller(this);

        for (String label : buttonLabels) 
        {
            JButton button = new JButton(label);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(calcController);
            buttonPanel.add(button);
        }

        setLayout(new BorderLayout());
        add(display, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
    }

    public JTextField getDisplay() 
    {
        return display;
    }
}
