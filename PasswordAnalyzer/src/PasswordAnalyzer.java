import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PasswordAnalyzer implements ActionListener {

    private final GUI gui;

    public PasswordAnalyzer() {
        gui = new GUI();
        gui.GUILayer(this); // Pass this class as listener
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String password = new String(gui.passwordField.getPassword());
        StringBuilder suggestions = new StringBuilder();

        boolean hasUpper = password.matches(".*[A-Z].*");
        boolean hasLower = password.matches(".*[a-z].*");
        boolean hasDigit = password.matches(".*\\d.*");
        boolean hasSpecial = password.matches(".*[_@#$%&*!\\-+.].*");
        boolean hasLength = password.length() >= 8;

        int score = 0;
        if (hasUpper) score++;
        if (hasLower) score++;
        if (hasDigit) score++;
        if (hasSpecial) score++;
        if (hasLength) score++;

        String strength;
        Color color;

        if (score <= 2) {
            strength = "Weak";
            color = Color.RED;
        } else if (score <= 4) {
            strength = "Medium";
            color = Color.ORANGE;
        } else {
            strength = "Strong";
            color = new Color(0, 200, 0);
        }

        gui.strengthLabel.setText("Password Strength: " + strength);
        gui.strengthLabel.setForeground(color);

        if (!hasLength) suggestions.append("• At least 8 characters\n");
        if (!hasUpper) suggestions.append("• Add an uppercase letter\n");
        if (!hasLower) suggestions.append("• Add a lowercase letter\n");
        if (!hasDigit) suggestions.append("• Add a digit (0–9)\n");
        if (!hasSpecial) suggestions.append("• Add a special character\n");

        if (score == 5) suggestions.append("✔ Your password meets all security requirements.");

        gui.suggestionArea.setText(suggestions.toString());
        gui.suggestionArea.setForeground(color);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(PasswordAnalyzer::new);
    }
}
