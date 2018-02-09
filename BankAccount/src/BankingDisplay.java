import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class BankingDisplay extends JFrame {

    private JPanel contentPane;
    private JTextField withdrawField;
    private JTextField depositField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BankingDisplay frame = new BankingDisplay();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public BankingDisplay() {
        Customer c = new Customer("Test Name", 001);
        BankAccount b1 = new BankAccount(c, 0);
        String startBalance = "" + c.getBalance();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 181);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);

        JLabel lblCurrentBalance = new JLabel("Current Balance: " + startBalance);
        contentPane.add(lblCurrentBalance, BorderLayout.SOUTH);

        JLabel lblCustomer = new JLabel(c.getName());
        contentPane.add(lblCustomer, BorderLayout.NORTH);

        withdrawField = new JTextField();
        panel.add(withdrawField);
        withdrawField.setColumns(10);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = extractNum(withdrawField.getText());
                double inputNum = Double.parseDouble(s);
                c.withdraw(inputNum);
                String balance = "Current Balance: " + c.getBalance();
                lblCurrentBalance.setText(balance);
            }
        });
        panel.add(withdrawButton);

        depositField = new JTextField();
        panel.add(depositField);
        depositField.setColumns(10);

        JButton depositButton = new JButton("Deposit");
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = extractNum(depositField.getText());
                double inputNum = Double.parseDouble(s);
                c.deposit(inputNum);
                String balance = "Current Balance: " + c.getBalance();
                lblCurrentBalance.setText(balance);
            }
        });
        panel.add(depositButton);

    }

    /**
     * This method is used to extract numbers from a textField string
     * 
     * @param str
     * @return
     */
    public static String extractNum(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("No number found");
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean ifFound = false;
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) || c == '.' || c == '-') {
                sb.append(c);
                ifFound = true;
            } else if (ifFound) {
                break;
            }
        }
        return sb.toString();
    }

}
