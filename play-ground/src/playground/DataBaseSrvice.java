package playground;

public class DataBaseSrvice {

	public void connect() {
		System.out.println("Data Base connected");
	}

	public String execute(String query) {
		return "Executed! Query: " + query;
	}

	public void disconnect() {
		System.out.println("Data Base disconnected");
	}

}
