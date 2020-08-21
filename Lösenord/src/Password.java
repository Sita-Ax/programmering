import java.util.Scanner;

public class Password {								//klassen

	public static void main(String[] args) {		//metoden

		Scanner reader = new Scanner(System.in);		//kod för input

		System.out.println(" Write the password? You can try 3 times. ");	//kod för att skriva ut
		String password = "hej123";
		String user = reader.nextLine();
		if (user.equals(password)) {					//equals hittade man på alla uppgifter som låg ute när man sökte
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
