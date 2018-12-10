import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddIngredients extends JFrame {
	JTextField nameTextField;
	JTextArea descriptiontextArea;
	JButton addIngredientButton;
	public AddIngredients() {
		setTitle("Add Ingredient");
		nameTextField = new JTextField();
		descriptiontextArea = new JTextArea();
		setLayout(null);
		JLabel l1 = new JLabel("Enter Name of ingredient");
		l1.setBounds(10,10,200,30);
		nameTextField.setBounds(10,40,200,30);
		add(l1);
		add(nameTextField);
		JLabel l2 = new JLabel("Describe ingredient");
		l2.setBounds(10,80,200,30);
		JScrollPane sp = new JScrollPane(descriptiontextArea);
		sp.setBounds(10,110,200,100);
		add(sp);
		add(l2);
		addIngredientButton = new JButton("Add Ingredient");
		addIngredientButton.setBounds(10,220,200,40);
		add(addIngredientButton);
		setBounds(0,0,235,310);
		setResizable(false);
		addIngredientButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddIngredients.this, "Name must not be empty", "No name", JOptionPane.ERROR_MESSAGE );
					return;
				}
				if(descriptiontextArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddIngredients.this, "Description must not be empty", "No description", JOptionPane.ERROR_MESSAGE );
					return;
				}
				CookBook.allIngredients.add(new Ingredient(nameTextField.getText(),descriptiontextArea.getText()));
				JOptionPane.showMessageDialog(AddIngredients.this, "Ingredient Added", "Success", JOptionPane.INFORMATION_MESSAGE );
				AddIngredients.this.dispose();
			}
		});
	}
}
