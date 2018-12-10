import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class CookBook {
	public static User currentUser = null;
	public static ArrayList<Ingredient> allIngredients = new ArrayList<>();
	public static ArrayList<Recipe> allRecipes = new ArrayList<>();
	public static ArrayList<User> allUsers = new ArrayList<>();
	public static void loadUserNames() {
		try {
			Scanner scin = new Scanner(new File("users.txt"));
			while(scin.hasNextLine()) {
				String data[] = scin.nextLine().split(" ");
				CookBook.allUsers.add(new User(data[0],data[1],data[2],data[3]));
			}
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "Data file missing","ERROR",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
	}
	public static void main(String[] args) {
		loadUserNames();
		new Login().show();
	}

}
