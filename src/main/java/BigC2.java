import java.util.*;
public class BigC2 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		try {
			String menu;
			do {
				System.out.println("********** Data Management for BigC Customer **********\nMENU\n0. Exit");
				System.out.println("1. Showing All of Databases Name\n2. Showing All of Document of the Customer Collection");
				System.out.println("3. Adding the Person information\n4. Editing the Person information\n5. Removing the Person information");
				System.out.print("Input Number: ");
				menu=kb.next();
				switch(menu) {
				case "0":
					System.out.println("\n\n********** Exit *************\nThank you for Data Managing\nGoodbye\n\n");
					break;
				case "1":
					System.out.println("\n\n********** Show All of Databases Name *************\n\n");
					break;
				case "2":
					System.out.println("\n\n********* Showing All of Document of the Customer Collection ********\n\n");
					break;
				case "3":
					System.out.println("\n\n************ Adding the Person information ************************\n\n");
					break;
				case "4":
					System.out.println("\n\n************ Editing the Person information *************************\n\n");
					break;
				case "5":
					System.out.println("\n\n************ Removing the Person information *************************\n\n");
					break;
				default:
					System.out.println("\n\nYour input are mismatch, please enter the correct number.\n\n");
				}
			}while(!menu.equals("0"));
			
		}catch(Exception e) {
			
		}

	}

}
