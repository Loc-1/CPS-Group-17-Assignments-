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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * This class is a frame to display the user's balance. Includes a GUI to allow
 * deposits and withdrawls.
 * 
 * @author Lachlan
 *
 */
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
        setBounds(100, 100, 309, 190);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5, 0, 312, 143);
        contentPane.add(panel);

        withdrawField = new JTextField();
        withdrawField.setBounds(13, 29, 116, 22);
        withdrawField.setColumns(10);
        
        JLabel lblCurrentBalance = new JLabel("Current Balance: " + startBalance);
        lblCurrentBalance.setBounds(13, 114, 152, 16);
        panel.add(lblCurrentBalance);

        JLabel lblCustomer = new JLabel(c.getName());
        lblCustomer.setBounds(12, 0, 67, 16);
        panel.add(lblCustomer);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(12, 64, 117, 25);
        /**
         * withdraw button withdraws a amount selected by the user in the withdraw text
         * field
         */
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = extractNum(withdrawField.getText());
                double inputNum = Double.parseDouble(s);
                c.withdraw(inputNum);
                String balance = "Current Balance: " + c.getBalance();
                lblCurrentBalance.setText(balance);
            }
        });

        depositField = new JTextField();
        depositField.setBounds(157, 29, 116, 22);
        depositField.setColumns(10);

        JButton depositButton = new JButton("Deposit");
        depositButton.setBounds(157, 64, 116, 25);
        /**
         * deposit button deposits a amount selected by the user in the deposit text
         * field
         */
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String s = extractNum(depositField.getText());
                double inputNum = Double.parseDouble(s);
                c.deposit(inputNum);
                String balance = "Current Balance: " + c.getBalance();
                lblCurrentBalance.setText(balance);
            }
        });
        panel.setLayout(null);
        panel.add(withdrawField);
        panel.add(withdrawButton);
        panel.add(depositButton);
        panel.add(depositField);

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
