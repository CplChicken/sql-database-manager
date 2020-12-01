package project3;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseTextInterface {
	
	private DatabaseManager DBM = new DatabaseManager();
	private Scanner scanner = new Scanner(System.in);
	private String input;
	
	public void run() throws SQLException {
		System.out.println("Database Menu");
		System.out.println("*****************");
		System.out.println("1. Students");
		System.out.println("2. Modules");
		System.out.println("3. Registrations");
		System.out.println("4. Staff");
		System.out.println("0. Quit");
		System.out.print(":> ");
		
		while(true) {
			input = scanner.nextLine();
			
			if(input.equals("1")) {
				students();
			}
			else if(input.equals("2")) {
				modules();
			}
			else if(input.equals("3")) {
				registrations();
			}
			else if(input.equals("4")) {
				staff();
			}
			else if(input.equals("0")) {
				System.exit(0);;
			}
		}
	}
	
	public void students() throws SQLException {
		String id;
		String name;
		String degree;
		
		System.out.println("Students Menu");
		System.out.println("*****************");
		System.out.println("1. Add Student");
		System.out.println("2. Remove Student");
		System.out.println("3. Update Student");
		System.out.println("4. List Students");
		System.out.println("0. Return to Main Menu");
		System.out.print(":> ");
		
		while(true) {
			input = scanner.nextLine();
			
			if(input.equals("1")) {
				System.out.print("Enter Student ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Enter Student Name:> ");
				name = scanner.nextLine();
				
				System.out.print("Enter Student's Degree Scheme:> ");
				degree = scanner.nextLine();
				
				DBM.addStudent(id, name, degree);
				students();
			}
			else if(input.equals("2")) {
				System.out.print("Enter Student ID:> ");
				id = scanner.nextLine();
				
				DBM.removeStudent(id);
				students();
			}
			else if(input.equals("3")) {
				System.out.print("Enter Student ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Update Name? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Student Name:> ");
					name = scanner.nextLine();
				}
				else {
					name = "";
				}
				
				System.out.print("Update Degree Scheme? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Degree Scheme:> ");
					degree = scanner.nextLine();
				}
				else {
					degree = "";
				}
				
				DBM.updateStudent(id, name, degree);
				students();
			}
			else if(input.equals("4")) {
				DBM.list(1);
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				students();
			}
			else if(input.equals("0")) {
				run();
			}
			
		}
	}
	
	public void modules() throws SQLException {
		String id;
		String name;
		int credits;
		
		System.out.println("Modules Menu");
		System.out.println("*****************");
		System.out.println("1. Add Module");
		System.out.println("2. Remove Module");
		System.out.println("3. Update Module");
		System.out.println("4. List Modules");
		System.out.println("0. Return to Main Menu");
		System.out.print(":> ");
		
		while(true) {
			input = scanner.nextLine();
			
			if(input.equals("1")) {
				System.out.print("Enter Module ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Enter Module Name:> ");
				name = scanner.nextLine();
				
				System.out.print("Enter Module Credits:> ");
				credits = scanner.nextInt();
				
				DBM.addModule(id, name, credits);
				modules();
			}
			else if(input.equals("2")) {
				System.out.print("Enter Module ID:> ");
				id = scanner.nextLine();
				
				DBM.removeModule(id);
				modules();
			}
			else if(input.equals("3")) {
				System.out.print("Enter Module ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Update Name? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Module Name:> ");
					name = scanner.nextLine();
				}
				else {
					name = "";
				}
				
				System.out.print("Update Module Credits? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Module Credits:> ");
					credits = scanner.nextInt();
				}
				else {
					credits = 0;
				}
				
				DBM.updateModule(id, name, credits);
				modules();
			}
			else if(input.equals("4")) {
				DBM.list(2);
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}	
				modules();
			}
			else if(input.equals("0")) {
				run();
			}
		}
	}
	
	public void registrations() throws SQLException {
		String studentId;
		String moduleId;
		
		System.out.println("Registrations Menu");
		System.out.println("*****************");
		System.out.println("1. Add Registration");
		System.out.println("2. Remove Registration");
		System.out.println("3. Update Registration");
		System.out.println("4. List Registrations");
		System.out.println("0. Return to Main Menu");
		System.out.print(":> ");
		
		while(true) {
			input = scanner.nextLine();
			
			if(input.equals("1")) {
				System.out.print("Enter Student ID:> ");
				studentId = scanner.nextLine();
				
				System.out.print("Enter Module ID:> ");
				moduleId = scanner.nextLine();
				
				DBM.addRegistration(studentId, moduleId);
				registrations();
			}
			else if(input.equals("2")) {
				System.out.print("Enter Student ID:> ");
				studentId = scanner.nextLine();
				
				DBM.removeRegistration(studentId);
				registrations();
			}
			else if(input.equals("3")) {
				System.out.print("Enter Student ID:> ");
				studentId = scanner.nextLine();
				
				System.out.print("Enter New Module ID:> ");
				moduleId = scanner.nextLine();
				
				DBM.updateRegistration(studentId, moduleId);
				registrations();
			}
			else if(input.equals("4")) {
				DBM.list(3);
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				registrations();
			}
			else if(input.equals("0")) {
				run();
			}
		}
	}
	
	public void staff() throws SQLException {
		String id;
		String name;
		String grade;
		
		System.out.println("Staff Menu");
		System.out.println("*****************");
		System.out.println("1. Add Staff");
		System.out.println("2. Remove Staff");
		System.out.println("3. Update Staff");
		System.out.println("4. List Staff");
		System.out.println("0. Return to Main Menu");
		System.out.print(":> ");
		
		while(true) {
			input = scanner.nextLine();
			
			if(input.equals("1")) {
				System.out.print("Enter Staff ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Enter Staff Name:> ");
				name = scanner.nextLine();
				
				System.out.print("Enter Staff Grade:> ");
				grade = scanner.nextLine();
				
				DBM.addStaff(id, name, grade);
				staff();
			}
			else if(input.equals("2")) {
				System.out.print("Enter Staff ID:> ");
				id = scanner.nextLine();
				
				DBM.removeStaff(id);
				staff();
			}
			else if(input.equals("3")) {
				System.out.print("Enter Staff ID:> ");
				id = scanner.nextLine();
				
				System.out.print("Update Name? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Staff Name:> ");
					name = scanner.nextLine();
				}
				else {
					name = "";
				}
				
				System.out.print("Update Staff Grade? (y/n):> ");
				input = scanner.nextLine();
				if (input.equals("y")) {
					System.out.print("Enter New Staff Grade:> ");
					grade = scanner.nextLine();
				}
				else {
					grade = "";
				}
				
				DBM.updateStaff(id, name, grade);
				staff();
			}
			else if(input.equals("4")) {
				DBM.list(4);
				try {
					System.in.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
				staff();
			}
			else if(input.equals("0")) {
				run();
			}
		}
	}
}
