import java.util.ArrayList;

public class Recipe {
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Double> quatity;
	private ArrayList<String> steps;
	private String description;
	private String title;
	private User owner;
	Recipe(){
		setDescription("");
		setTitle("");
		setIngredients(new ArrayList<>());
		setQuatity(new ArrayList<>());
		setSteps(new ArrayList<>());
	}
	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}
	public ArrayList<Double> getQuatity() {
		return quatity;
	}
	public void setQuatity(ArrayList<Double> quatity) {
		this.quatity = quatity;
	}
	public ArrayList<String> getSteps() {
		return steps;
	}
	public void setSteps(ArrayList<String> steps) {
		this.steps = steps;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String toString() {
		return this.getTitle();
	}
}
