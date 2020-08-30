import java.util.Random;//slumptal
import java.util.Scanner;//användare in

public class Paper {

	// static Scanner scanner = new Scanner(System.in);// indata för användaren och
	// lärde mig att lägga in den i metoderna istället så när programmet går vidare
	// blir det en ny scanner.
	static Random random = new Random();// indata för att ha random som datain
	static int rounds = 0; // ronuds börjar alltid på 0 och sedan med ++ ökas den en gång varje gång den körs från början har den värdet 0
	static int player;
	static int player1; // alla dessa är egenskaper som beskriver vad som finns i klassen alltså dess innehåll
	static int player2; // tomma variabler
	static String user;
	static String computer;
	static int p1Points = 0; // poäng samma funktion som rounds men denna håller poäng räkningar
	static int p2Points = 0; // poäng samma funktion som rounds men denna håller poäng räkningar
	static int Computer;
	static String computerName;

	public static void menu() { // metoder beskriver funktioner som klassen hantera

		System.out.println("Welcome to my game select how you whant to play.");
		System.out.println("Select 1 to play whit the computer.");
		System.out.println("Select 2 to play whit a friend.");
		System.out.println("Select 3 to Exit.");
		Scanner scanner = new Scanner(System.in);
		int Start = scanner.nextInt();
		if (Start == 1) {
			System.out.println("You what to play whit the computer ");
			System.out.println();
			theWinner(); // läser in metoden för att spela mot datorna då man ska skriva med bokstäver
		} else if (Start == 2) {
			System.out.println("You what to play whit a friend ");
			System.out.println();
			play(); // läser in metoden för att spela p vs p och skrivs i med siffror
		} else if (Start == 3) {
			System.out.println("You what to Exit ");
			System.exit(0); // ska kunna avsluta spelet fungera inte
		} else {
			System.out.println("You what to go back to the menu ");
			System.out.println();
			menu(); // metoden som går tebax till menyn
		}
	}

	public static void theWinner() {

		System.out.println("Hello whats your name? ");// skriva ut meddeladet till användaren
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine(); // läsa in en textrad som spara variablens värde i scannern ska i detta fallet  hålla namnet för spelaren						
		// en metod som håller vilken som vinner över vilken och vad som skrivs ut då.
		// name = scanner.nextLine();// måste ha den här oxå för att det ska bli rätt
		while (p1Points != 3 && p2Points != 3) { // while loop så länge playerns poäng inte är 3
			Computer = random.nextInt(3) + 1;// jag plussar med ett för att få fram värdet 1,2,3 annars är bara 3 värden 0,1,2
												
			if (Computer == 1) {
				computerName = "Rock";
			} else if (Computer == 2) {
				computerName = "Paper";
			} else if (Computer == 3) {
				computerName = "Scissors";
			}

			System.out.println("Choose Rock, Paper or Scissors ");// skriva ut textraden
			System.out.println();
			user = scanner.nextLine(); // läser in värdet från spelaren
			System.out.println(name + " choose " + user);
			System.out.println("Computer choose " + computerName);
//			try {			
//				System.out.println("You are in try. "); //kommer in men skriver inte ut cathchen och fungera inte med bokstäver
//			}catch(NumberFormatException e) {
//				System.out.println("No number! " + e);
//			}
			if (computerName.equals(user)) { // man ska använda equals när det är strängar och == när det är tal
				System.out.println("Equal");
				System.out.println();
			} // man skriver in rock och gå sen in i nästa if sats
			if (computerName.equals("Rock") && user.equals("Scissors")) {
				p2Points++; // måste ha poäng räkning över för att plussa på i textraden ut
				System.out.println("Computer get: " + p2Points + " points");

			} else if (user.equals("Rock") && computerName.equals("Scissors")) {
				p1Points++;
				System.out.println(name + " get: " + p1Points + " points");
				System.out.println();

			}
			if (computerName.equals("Paper") && user.equals("Rock")) {
				p2Points++;
				System.out.println("Computer get: " + p2Points + " points");

			} else if (user.equals("Paper") && computerName.equals("Rock")) {
				p1Points++;
				System.out.println(name + " get: " + p1Points + " points");
				System.out.println();

			}
			if (computerName.equals("Scissors") && user.equals("Paper")) {
				p2Points++;
				System.out.println("Computer get: " + p2Points + " points");

			} else if (user.equals("Scissors") && computerName.equals("Paper")) {
				p1Points++;
				System.out.println(name + " get: " + p1Points + " points");
				System.out.println();
			}
		}
		System.out.println(name + " got: " + p1Points + " Compurer got: " + p2Points);
		System.out.println();
		reset();
		menu();
	}

	private static void play() {

		while (p1Points != 3 && p2Points != 3) {

			System.out.println("Player1 Select 1 for Rock, 2 for Paper and 3 for Scissors. First to 3 winns.");
			Scanner scanner = new Scanner(System.in);
			String plays = scanner.nextLine();
			player1 = Integer.parseInt(plays);
			System.out.println("Player2 select 1 for Rock, 2 for Paper and 3 for Scissors. First to 3 winns.");
			String play2 = scanner.nextLine();
			player2 = Integer.parseInt(play2);

			if (player1 < 1 || player2 < 1 || player1 > 3 || player2 > 3) {
//					try {			
//							System.out.println("You are in try. "); //kommer in men skriver inte ut cathchen och fungera inte med bokstäver
//						}catch(NumberFormatException e) {
//							System.out.println("No number! " + e);
//						}
				System.out.println("Not number over 4");
			} 		
			if (player1 == player2) {
				System.out.println(player1);
				System.out.println(player2);
				System.out.println("It is equal! ");
				System.out.println();
			} else {

				if (player1 == 1 && player2 == 3) {
					System.out.println("Player1 selected rock ");
					System.out.println("Player2 selected scissors ");
					System.out.println("Player1 won. ");
					p1Points++;
					rounds++;
					System.out.println("Player1 you have: " + p1Points + " points on round " + rounds);
					System.out.println();

				} else if (player2 == 1 && player1 == 3) {
					System.out.println("Player1 selected scissors ");
					System.out.println("Player2 selected rock ");
					System.out.println("Player2 won. ");
					p2Points++;
					rounds++;
					System.out.println("Player2 you have: " + p2Points + " on round " + rounds);
					System.out.println();
				}
				if (player1 == 2 && player2 == 1) {
					System.out.println("Player1 selected paper ");
					System.out.println("Player2 selected rock ");
					System.out.println("Player1 won.  ");
					p1Points++;
					rounds++;
					System.out.println("Player1 you have: " + p1Points + " on round " + rounds);
					System.out.println();

				} else if (player2 == 2 && player1 == 1) {
					System.out.println("Player1 selected rock ");
					System.out.println("Player2 selected paper ");
					System.out.println("Player2 won. ");
					p2Points++;
					rounds++;
					System.out.println("Player2 you have: " + p2Points + " on round " + rounds);
					System.out.println();
				}
				if (player1 == 3 && player2 == 1) {
					System.out.println("Player1 selected scissors ");
					System.out.println("Player2 selected rock ");
					System.out.println("Player2 won. ");
					p2Points++;
					rounds++;
					System.out.println("Player2 you have: " + p2Points + " on round " + rounds);
					System.out.println();

				} else if (player2 == 3 && player1 == 1) {
					System.out.println("Player1 selected rock ");
					System.out.println("Player2 selected scissors ");
					System.out.println("Player1 won. ");
					p1Points++;
					rounds++;
					System.out.println("Player1 you have: " + p1Points + " on round " + rounds);
					System.out.println();
				}
				if (p1Points == 3) {
					System.out.println("Player1 You win congrats! ");
					System.out.println();
					reset();
					rounds++;
					menu();
				}
				if (p2Points == 3) {
					System.out.println("Player2 You win congrats! ");
					System.out.println();
					reset();
					rounds++;
					menu();
				}
			}
		}
	}

	public static void reset() { // skapade denna metod för att nollställa poängen mellan spelet och nästa spel
		p1Points = 0;
		p2Points = 0;
	}

	public static void main(String[] args) {

		menu(); // Räcker att sätta in metoden menu för att köra programmet sedan anropar jag de
				// andra metoderna i menyn.
	}
}
