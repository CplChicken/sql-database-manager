package project3;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseManager {
	private static String url;
	private static String username;
	private static String password;
	
	public DatabaseManager() {
		InputStream stream = DatabaseManager.class.getResourceAsStream("/database.properties");
		try {
			init(stream);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void addStudent(String id, String name, String degree) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("INSERT INTO student VALUES ('" + id + "', '" + name + "', '" + degree + "')");
		System.out.println("Successfully added " + name + " to student table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeStudent(String id) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("DELETE FROM student WHERE student_id = '" + id + "'");
		System.out.println("Successfully deleted student from table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStudent(String id, String name, String degree) throws SQLException {
		Connection conn = DatabaseManager.getConnection();
		ResultSet rs;

		Statement st = conn.createStatement();
		
		if(name.equals("")) {
			rs = st.executeQuery("SELECT student_name FROM student WHERE student_id = '" + id + "'");
			while(rs.next()) {
				name = rs.getString("student_name");
			}
		}
		
		if(degree.equals("")) {
			rs = st.executeQuery("SELECT degree_scheme FROM student WHERE student_id = '" + id + "'");
			while(rs.next()) {
				degree = rs.getString("degree_scheme");
			}
		}
		
		st.execute("UPDATE student SET student_name = '" + name + "', degree_scheme = '" + degree + "' WHERE student_id = '" + id + "'");
		System.out.println("Successfully updated student...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addModule(String id, String name, int credits) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("INSERT INTO module VALUES ('" + id + "', '" + name + "', '" + credits + "')");
		System.out.println("Successfully added " + name + " to module table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeModule(String id) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("DELETE FROM module WHERE module_id = '" + id + "'");
		System.out.println("Successfully deleted module from table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateModule(String id, String name, int credits) throws SQLException {
		Connection conn = DatabaseManager.getConnection();
		ResultSet rs;

		Statement st = conn.createStatement();
		
		if(name.equals("")) {
			rs = st.executeQuery("SELECT module_name FROM module WHERE module_id = '" + id + "'");
			while(rs.next()) {
				name = rs.getString("module_name");
			}
		}
		
		if(credits == 0) {
			rs = st.executeQuery("SELECT credits FROM module WHERE module_id = '" + id + "'");
			while(rs.next()) {
				credits = rs.getInt("credits");
			}
		}
		
		st.execute("UPDATE module SET module_name = '" + name + "', credits = '" + credits + "' WHERE module_id = '" + id + "'");
		System.out.println("Successfully updated module...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addRegistration(String studentId, String moduleId) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("INSERT INTO registered VALUES ('" + studentId + "', '" + moduleId + "')");
		System.out.println("Successfully added registration to table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void removeRegistration(String studentId) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("DELETE FROM registered WHERE student_id = '" + studentId + "'");
		System.out.println("Successfully deleted registration from table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateRegistration(String studentId, String moduleId) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("UPDATE registered SET module_id = '" + moduleId +"' WHERE student_id = '" + studentId + "'");
		System.out.println("Successfully updated registration...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addStaff(String id, String name, String grade) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("INSERT INTO staff VALUES ('" + id + "', '" + name + "', '" + grade + "')");
		System.out.println("Successfully added " + name + " to staff table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void removeStaff(String id) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		
		st.execute("DELETE FROM staff WHERE staff_id = '" + id + "'");
		System.out.println("Successfully deleted staff from table...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void updateStaff(String id, String name, String grade) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		ResultSet rs;

		Statement st = conn.createStatement();
		
		if(name.equals("")) {
			rs = st.executeQuery("SELECT staff_name FROM staff WHERE staff_id = '" + id + "'");
			while(rs.next()) {
				name = rs.getString("staff_name");
			}
		}
		
		if(grade.equals("")) {
			rs = st.executeQuery("SELECT staff_grade FROM staff WHERE staff_id = '" + id + "'");
			while(rs.next()) {
				grade = rs.getString("staff_grade");
			}
		}
		
		st.execute("UPDATE staff SET staff_name = '" + name + "', staff_grade = '" + grade + "' WHERE staff_id = '" + id + "'");
		System.out.println("Successfully updated staff...");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void list(int choice) throws SQLException {
		Connection conn = DatabaseManager.getConnection();

		Statement st = conn.createStatement();
		ResultSet rs;
		switch(choice) {
		case 1:
			rs = st.executeQuery("SELECT * FROM student");
			while (rs.next()) {
				System.out.println(rs.getString("student_id") + "\t" + rs.getString("student_name") + "\t" + rs.getString("degree_scheme"));
			}
			break;
		case 2:
			rs = st.executeQuery("SELECT * FROM module");
			while (rs.next()) {
				System.out.println(rs.getString("module_id") + "\t" + rs.getString("module_name") + "\t" + rs.getInt("credits"));
			}
			break;
		case 3:
			rs = st.executeQuery("SELECT * FROM registered");
			while (rs.next()) {
				System.out.println(rs.getString("student_id") + "\t" + rs.getString("module_id"));
			}
			break;
		case 4:
			rs = st.executeQuery("SELECT * FROM staff");
			while (rs.next()) {
				System.out.println(rs.getString("staff_id") + "\t" + rs.getString("staff_name") + "\t" + rs.getString("staff_grade"));
			}
			break;
		}
		System.out.println("Press enter to continue...");
	}
	
	public static void init(InputStream stream) throws IOException, ClassNotFoundException {
		Properties props = new Properties();
	    props.load(stream);

	    String driver = props.getProperty("jdbc.driver");
	    url = props.getProperty("jdbc.url");
	    username = props.getProperty("jdbc.username");
	    password = props.getProperty("jdbc.password");

	    Class.forName(driver);
	}
	
	public static Connection getConnection() throws SQLException
	{
	   return DriverManager.getConnection(url, username, password);
	}
}
