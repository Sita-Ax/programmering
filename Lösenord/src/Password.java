import java.util.Scanner;

public class Password {								//klassen

	public static void main(String[] args) {		//metoden

		Scanner reader = new Scanner(System.in);		//kod f�r input

		System.out.println(" Write the password? You can try 3 times. ");	//kod f�r att skriva ut
		String password = "hej123";
		String user = reader.nextLine();
		if (user.equals(password)) {					//equals hittade man p� alla uppgifter som l�g ute n�r man s�kte
			System.out.println(" You choose right ");	//if else repetera med nya user 3 ggr utan loop
		} else {
			System.out.println(" Wrong try 2 more times. ");
			String user1 = reader.nextLine();
			if (user1.equals(password)) {
				System.out.println(" You choose right ");
			} else {
				System.out.println(" No wrong again. Try 1 more times. ");
				String user2 = reader.nextLine();
				if (user2.equals(password)) {
					System.out.println(" You choose right. ");
				} else {
					System.out.println(" No it is wrong and you got no more trys. ");
				}
			}
		}
	}

}
