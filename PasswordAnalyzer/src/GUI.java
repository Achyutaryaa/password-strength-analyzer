import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class GUI {
    public JFrame mainFrame;
    public JPasswordField passwordField;
    public JLabel strengthLabel;
    public JTextArea suggestionArea;
    public JButton submitButton;

    public void GUILayer(ActionListener listener) {
        mainFrame = new JFrame("Password Strength Analyzer");
        mainFrame.setSize(600, 400);
        mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new BorderLayout());

        // Top panel
        JLabel topLabel = new JLabel("Password Strength Analyzer");
        topLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        JPanel topPanel = new JPanel(new GridBagLayout());
        topPanel.setBackground(Color.CYAN);
        topPanel.setPreferredSize(new Dimension(0, 100));
        topPanel.add(topLabel);

        // Main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBackground(Color.YELLOW);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridy = 0;
        gbc.weighty = 1;

        // Alert Panel
        JPanel alertPanel = new JPanel(new BorderLayout());
        alertPanel.setBackground(Color.BLACK);
        strengthLabel = new JLabel("Password Strength: ");
        strengthLabel.setFont(new Font("Arial", Font.BOLD, 20));
        strengthLabel.setForeground(Color.WHITE);

        suggestionArea = new JTextArea(6, 20);
        suggestionArea.setEditable(false);
        suggestionArea.setLineWrap(true);
        suggestionArea.setWrapStyleWord(true);
        suggestionArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
        suggestionArea.setBackground(Color.BLACK);
        suggestionArea.setForeground(Color.WHITE);

        alertPanel.add(strengthLabel, BorderLayout.NORTH);
        alertPanel.add(new JScrollPane(suggestionArea), BorderLayout.CENTER);

        gbc.gridx = 0;
        gbc.weightx = 0.4;
        mainPanel.add(alertPanel, gbc);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        GridBagConstraints inputGbc = new GridBagConstraints();
        inputGbc.insets = new Insets(10, 10, 10, 10);
        inputGbc.fill = GridBagConstraints.HORIZONTAL;
        inputGbc.gridx = 0;
        inputGbc.gridy = 0;

        JLabel inputLabel = new JLabel("Enter Password:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(inputLabel, inputGbc);

        inputGbc.gridy++;
        passwordField = new JPasswordField(20);
        passwordField.setFont(new Font("Arial", Font.PLAIN, 18));
        inputPanel.add(passwordField, inputGbc);

        inputGbc.gridy++;
        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Arial", Font.PLAIN, 18));
        submitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        submitButton.setBackground(new Color(139, 214, 217));
        submitButton.setForeground(Color.BLUE);
        submitButton.setBorder(new LineBorder(Color.BLUE, 0, true));
        submitButton.addActionListener(listener); // connect to PasswordAnalyzer
        inputPanel.add(submitButton, inputGbc);

        gbc.gridx = 1;
        gbc.weightx = 0.6;
        mainPanel.add(inputPanel, gbc);

        mainFrame.add(topPanel, BorderLayout.NORTH);
        mainFrame.add(mainPanel, BorderLayout.CENTER);
        mainFrame.getRootPane().setDefaultButton(submitButton);

        mainFrame.setVisible(true);
    }
}
