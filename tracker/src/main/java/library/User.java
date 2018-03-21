package library;

public class User {
	String name;
	int count;

	User(String userName) {
		name = userName;
		count = 0;
	}

	public User() {

	}

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}
}
