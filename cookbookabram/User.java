import java.util.ArrayList;

public class User {
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	public User(String fn,String ln,String un,String pass){
		setLastName(ln);
		setFirstName(fn);
		setUsername(un);
		setPassword(pass);
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
