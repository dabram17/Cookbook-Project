import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Menu extends JFrame {
	JButton addIngredient,removeIngredient;
	JButton addRecipe,removeRecipe,allRecipe;
	public Menu() {
		setTitle("Cookbook");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		JLabel l1 = new JLabel("Ingredients");
		addIngredient = new JButton("Add");
		addIngredient.setBounds(10, 40, 100, 40);
		removeIngredient = new JButton("Remove");
		removeIngredient.setBounds(120, 40, 100, 40);
		setBounds(0,0,250,300);
		l1.setBounds(10,10,220,30);
		add(l1);
		add(addIngredient);
		add(removeIngredient);
		addIngredient.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddIngredients().show();				
			}
		});
		
		JLabel l2 = new JLabel("Recipes");
		addRecipe = new JButton("Add");
		addRecipe.setBounds(10, 120, 100, 40);
		removeRecipe = new JButton("Remove");
		removeRecipe.setBounds(120, 120, 100, 40);
		l2.setBounds(10,90,220,30);
		add(l2);
		add(addRecipe);
		add(removeRecipe);
		addRecipe.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent evt) {
				if(CookBook.allIngredients.isEmpty()) {
					JOptionPane.showMessageDialog(Menu.this, "No Ingredients present. Atleast one ingredient required for recipe.", "Error", JOptionPane.OK_OPTION);
					return;
				}
				int numIngredients,numSteps;
				String _numIngredients = JOptionPane.showInputDialog(Menu.this, "Enter number of ingredients", "Ingredients", JOptionPane.OK_CANCEL_OPTION);
				if(_numIngredients == null) {
					JOptionPane.showMessageDialog(Menu.this, "Cancelled by user", "Error", JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					numIngredients = Integer.parseInt(_numIngredients);
					if(numIngredients > CookBook.allIngredients.size()) {
						JOptionPane.showMessageDialog(Menu.this, "Too many ingredients.\nTry adding ingredients.", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					new AddRecipe(numIngredients).show();
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(Menu.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		allRecipe = new JButton("All Recipe");
		allRecipe.setBounds(10,170,210,40);
		add(allRecipe);
		allRecipe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(CookBook.allRecipes.isEmpty()) {
					JOptionPane.showMessageDialog(Menu.this, "No Recipes present", "Error", JOptionPane.OK_OPTION);
					return;
				}
				new AllRecipe().show();
			}
		});
	}
}
