import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class AllRecipe extends JFrame {
	JComboBox<String> recipes;
	JTextArea recipeDetails;
	public AllRecipe() {
		recipes = new JComboBox<>();
		for(Recipe r : CookBook.allRecipes) {
			recipes.addItem(r.toString());
		}
		recipeDetails = new JTextArea();
		recipeDetails.setEditable(false);
		
		recipeDetails.setText("");
		recipes.setBounds(10,10,380,30);
		
		recipes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showRecipe();
			}
		});

		JScrollPane sp = new JScrollPane(recipeDetails);
		sp.setBounds(10,50,380,540);
		add(sp);
		showRecipe();
		setLayout(null);
		setBounds(0,0,410,600);
		setResizable(false);
		setTitle("Recipe");
		add(recipes);
	}
	public void showRecipe() {
		Recipe recipe = CookBook.allRecipes.get(recipes.getSelectedIndex());
		String details = "";
		details = "Title : "+ recipe.getTitle()+"\n";
		details += "\nDescription: "+recipe.getDescription()+"\n";
		details += "\nIngredients:\n";
		for(int i=0;i<recipe.getIngredients().size();i++) {
			details += (i+1)+") "+recipe.getIngredients().get(i).getName()+" - "+recipe.getQuatity().get(i)+"\n";
		}
		details += "\nSteps:\n";
		for(int i=0;i<recipe.getSteps().size();i++) {
			details += (i+1)+") "+recipe.getSteps().get(i)+"\n";
		}
		recipeDetails.setText(details);	
	}
}
