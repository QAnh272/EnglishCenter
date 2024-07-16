package EnglishCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;

	public LoginForm() {
		initialize();
		frame.setVisible(true);
	}

	private void initialize() {
		frame = new JFrame("Login Form");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(50, 50, 80, 30);
		frame.getContentPane().add(usernameLabel);

		usernameField = new JTextField();
		usernameField.setBounds(140, 50, 200, 30);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(50, 100, 80, 30);
		frame.getContentPane().add(passwordLabel);

		passwordField = new JPasswordField();
		passwordField.setBounds(140, 100, 200, 30);
		frame.getContentPane().add(passwordField);

		JButton loginButton = new JButton("Login");
		loginButton.setBounds(150, 150, 100, 30);
		frame.getContentPane().add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				if (authenticate(username, password)) {
					openRegistrationForm();
				} else {
					JOptionPane.showMessageDialog(frame, "Invalid username or password");
				}
			}
		});
	}

	private boolean authenticate(String username, String password) {
		return username.equals("admin") && password.equals("admin");
	}

	private void openRegistrationForm() {
		frame.dispose();
		RegistrationForm registrationForm = new RegistrationForm(); //
		registrationForm.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				frame.setVisible(true);
			}
		});
		registrationForm.showForm();

	}
}
