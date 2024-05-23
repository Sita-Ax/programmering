package parseup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseUp {

	public static String COMMA_DELIMITER = ",";
	static int count = 0;

	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>();// l�ser en rad
		try (Scanner scanner = new Scanner(new File("sampleM.csv"));) {// spara per kulumb slipper patch try om inte
			while (scanner.hasNextLine()) {// finns det en rad till slutet p� dockumentet
				records.add(getRecordFromLine(scanner.nextLine()));// records har raderna"arraylist" l�gger till raden
			}
			records.remove(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> nameA = new ArrayList<>();
		for (int i = 0; i < records.size(); i++) {
			List<String> localValues = records.get(i);
			if (localValues.get(1).toLowerCase().contains("a")) {
				nameA.add(localValues.get(1));
			}
			if (localValues.get(2).toLowerCase().contains("a")) {
				nameA.add(localValues.get(2));
			}
		}
		for (String b : nameA) {
		}
		System.out.println(nameA.size() + " names contain both a and A");

		List<Integer> timeS = new ArrayList<>();
		for (int i = 0; i < records.size(); i++) {
			List<String> localV = records.get(i);
			for (List<String> line : records) {
				if ((!line.equals(localV)) && (line.get(0).equals(localV.get(0)))) {
					timeS.add(i);
				}
			}
		}
		System.out.println("These names have the same TimeStamp! ");
		for (Integer i : timeS) {
			System.out.print(records.get(i).get(1));
			System.out.print(" and ");
			System.out.println(records.get(i).get(2));
		}
		System.out.println("It is " + count + " that works whit Android App.");
	}

	public static List<String> getRecordFromLine(String line) {// detta kommer raden inneh�lla
		List<String> values = new ArrayList<>();// sparar
		try (Scanner rowScanner = new Scanner(line)) { // f�r varje rad ny scan.
			rowScanner.useDelimiter(COMMA_DELIMITER);// packar upp radern h�r kan vi anv�nda spliten sparar fr�n listan
			while (rowScanner.hasNext()) { // varje rad en i taget efter 3.dj ggn rad 3 s� l�nge den har n�gon h�r efter
				values.add(rowScanner.next());// h�r �r man inne i varje cell
			}
			if (values.get(6).contains("Android App")) {
				count++;
			}
		}
		return values;
	}
}
