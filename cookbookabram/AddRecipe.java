import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class AddRecipe extends JFrame {
	JTextField nameTextField;
	JTextArea descriptiontextArea;
	JTextArea stepsTextArea;
	JButton addRecipeButton;
	ArrayList<JComboBox<String>> ingredients;
	ArrayList<JTextField> quantity;
	public AddRecipe(int numIngredients) {
		setTitle("Add Ingredient");
		setBounds(0,0,450,800);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		ingredients = new ArrayList<>();
		quantity = new ArrayList<>();
		nameTextField = new JTextField();
		descriptiontextArea = new JTextArea();
		JLabel l1 = new JLabel("Enter Name of recipe");
		l1.setBounds(10,10,300,30);
		nameTextField.setBounds(10,40,300,30);
		panel.add(l1);
		panel.add(nameTextField);
		JLabel l2 = new JLabel("Describe recipe");
		l2.setBounds(10,80,400,30);
		panel.add(l2);
		JLabel l3 = new JLabel("Add Ingredients");
		l3.setBounds(10,220,400,30);
		panel.add(l3);
		
		int y = 250;
		
		for(int i=0;i<numIngredients;i++) {
			JComboBox<String> ingredientComboBox= new JComboBox<>();
			for (Ingredient ii : CookBook.allIngredients) {
				ingredientComboBox.addItem(ii.getName());	
				System.out.println(ii.getName());
			}
			ingredientComboBox.setBounds(10,y,200,30);
			ingredients.add(ingredientComboBox);
			
			JFormattedTextField ingredientQty = new JFormattedTextField();
			ingredientQty.setBounds(220,y,190,30);
			panel.add(ingredientQty);
			ingredientQty.setValue(0.0);
			quantity.add(ingredientQty);

			panel.add(ingredientComboBox);
			y += 40;
		}

		JLabel l4 = new JLabel("Add Steps");
		l4.setBounds(10,y,400,30);
		
		panel.add(l4);
		stepsTextArea = new JTextArea();

		JScrollPane sp2 = new JScrollPane(stepsTextArea);
		sp2.setBounds(10,y+40,400,200);
		panel.add(sp2);
		JScrollPane sp = new JScrollPane(descriptiontextArea);
		sp.setBounds(10,110,400,100);
		panel.add(sp);
		addRecipeButton = new JButton("Add");
		addRecipeButton.setBounds(320,30,90,40);
		panel.add(addRecipeButton);
		addRecipeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(nameTextField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddRecipe.this, "Name must not be empty", "No name", JOptionPane.ERROR_MESSAGE );
					return;
				}
				if(descriptiontextArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddRecipe.this, "Description must not be empty", "No description", JOptionPane.ERROR_MESSAGE );
					return;
				}

				if(stepsTextArea.getText().isEmpty()) {
					JOptionPane.showMessageDialog(AddRecipe.this, "Steps must not be empty", "No Steps", JOptionPane.ERROR_MESSAGE );
					return;
				}
				ArrayList<Ingredient> ing = new ArrayList<>();
				for(JComboBox<String> cb : ingredients) {
					ing.add(CookBook.allIngredients.get(cb.getSelectedIndex()));
				}
				ArrayList<Double> qty = new ArrayList<>();
				for(JTextField cb : quantity) {
					qty.add(Double.parseDouble(cb.getText()));
				}
				Recipe recipe= new Recipe();
				recipe.setTitle(nameTextField.getText());
				recipe.setDescription(descriptiontextArea.getText());
				recipe.setOwner(CookBook.currentUser);
				ArrayList<String> steps = new ArrayList<>();
				String _steps[] = stepsTextArea.getText().split("\n"); 
				for(String s : _steps) {
					steps.add(s);
				}
				recipe.setQuatity(qty);
				recipe.setIngredients(ing);
				recipe.setSteps(steps);
				CookBook.allRecipes.add(recipe);
				JOptionPane.showMessageDialog(AddRecipe.this, "Recipe Added", "Success", JOptionPane.INFORMATION_MESSAGE );
				AddRecipe.this.dispose();
			}
		});

		JScrollPane jScrollPane = new JScrollPane(panel);
		jScrollPane.setBounds(0,0,WIDTH,HEIGHT);
		getContentPane().add(jScrollPane);
	}
}
