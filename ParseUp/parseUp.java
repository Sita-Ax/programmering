package ParseUp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class parseUp<E> {

	public static String COMMA_DELIMITER = ",";
	static int count = 0;
	static int nameCount = 0;
	static int timeCount = 0;
	static String stamp = "";
	public static String content = "";

	public static void main(String[] args) {

		List<List<String>> records = new ArrayList<>();// läser en rad
		try (Scanner scanner = new Scanner(new File("sampleM.csv"));) {// spara per kulumb slipper patch try om inte
			while (scanner.hasNextLine()) {// finns det en rad till slutet på dockumentet
				records.add(getRecordFromLine(scanner.nextLine()));// records har raderna"arraylist" lägger till raden
			}
			records.remove(0);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		List<String> nameA = new ArrayList<String>();
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
					
					System.out.println(i);
					timeS.add(i);
				}
			}
		}System.out.println("This TimeStamp is the same! ");
		for (Integer i: timeS)
			System.out.println(records.get(i));

		System.out.println("It is " + count + " that works whit Android App.");
	}

	public static List<String> getRecordFromLine(String line) {// detta kommer raden innehålla
		List<String> values = new ArrayList<String>();// sparar
		try (Scanner rowScanner = new Scanner(line)) { // för varje rad ny scan.
			rowScanner.useDelimiter(COMMA_DELIMITER);// packar upp radern här kan vi använda spliten sparar från listan
			while (rowScanner.hasNext()) { // varje rad en i taget efter 3.dj ggn rad 3 så länge den har någon här efter
				values.add(rowScanner.next());// h'r är man inne i varje cell
			}
			if (values.get(6).contains("Android App")) {
				count++;
				count++;
			}
		}
		return values;
	}
}
