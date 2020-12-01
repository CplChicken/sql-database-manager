package project3;

import java.sql.SQLException;

public class DatabaseMain {
	public static void main(String[] args) throws SQLException {
		DatabaseTextInterface UI = new DatabaseTextInterface();
		
		UI.run();
	}
}
