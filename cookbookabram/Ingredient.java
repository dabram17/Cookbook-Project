/*Daniel Abram
 * Cook book application
 * This application was made so that you could log into your personal cook book 
 * and add or view your favorite recipes
 * To log in, the file users.txt, contains the user name: user123 and password: password
 * This file is being read into an array of users that loops through the array to match if the user name
 * and password exists or not every time the login button is pressed. 
 * To add recipes, you first add ingredients by pressing the add button under ingredients. 
 * There, you can add the name of the ingredient and a description.
 * Add as many ingredients as you need for the recipe.
 * I could not get the remove buttons to work so they are there to look pretty for now. This is an addition I will
 * work on in the future.
 * From here, you can add a recipe by pressing add under recipes.
 * There, you can fill out title, description, how many ingredients, and steps for the recipe.
 * when you filled everything out, you press add.
 * To view the recipe, you press the all recipes button under recipes
 * Another thing I would want in a later version is to be able to save the recipes. 
*/
public class Ingredient {
	private String name;
	private String description;
	public Ingredient(String name,String description) {
		setDescription(description);
		setName(name);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString() {
		return this.name;
	}
}
