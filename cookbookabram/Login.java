import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {
	JTextField username;
	JPasswordField password;
	JButton loginBtn;
	public Login(){
		setTitle("Login");
		setLayout(null);
		JLabel l1 = new JLabel("Enter username and password");
		l1.setBounds(10,10,200,30);
		add(l1);
		username = new JTextField();
		username.setBounds(10,40,200,30);
		password = new JPasswordField();
		password.setBounds(10,80,200,30);
		add(username);
		add(password);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginBtn = new JButton("Login");
		loginBtn.setBounds(10,120,200,40);
		add(loginBtn);
		setBounds(0,0,235,200);
		setResizable(false);
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(username.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Login.this, "Username must not be empty", "No name", JOptionPane.ERROR_MESSAGE );
					return;
				}
				if(password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(Login.this, "Password must not be empty", "No password", JOptionPane.ERROR_MESSAGE );
					return;
				}
				for(User user : CookBook.allUsers) {
					if(user.getUsername().equals(username.getText()) && user.getPassword().equals(password.getText())) {
						CookBook.currentUser = user;
						new Menu().show();
						Login.this.dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(Login.this, "Invalid username/password", "Login failed", JOptionPane.ERROR_MESSAGE );
			}
		});
	}
}
