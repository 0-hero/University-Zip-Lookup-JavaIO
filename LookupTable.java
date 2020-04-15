import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Code for HW6
 * 
 * @author Ankit Reddi
 */
public class LookupTable {
	private ArrayList<Item> Zip_key;
	private ArrayList<Item> University_key;
	private String outp;
	private Item temp;

	/**
	 * Constructs a LookupTable object.
	 */
	public LookupTable() {
		// Two array lists are created.
		Zip_key = new ArrayList<Item>(); // Zip is the key in this array list
		University_key = new ArrayList<Item>(); // University is the key in this array list
	}

	/**
	 * Reads key/value pairs. Given the Scanner object "in", the method should read
	 * the input file. Write a while loop to read the text file attached
	 * ("university.txt"). Tip1: You can read two lines in one iteration of the
	 * while loop. The first and second lines are for university and zip,
	 * respecively Tip2: sort the arraylist of Item objects after reading all data
	 * 
	 * @param in: the scanner for reading the input
	 */
	public void read(Scanner in) {
		// COMPLETE this method
		while (in.hasNextLine()) {
			String name = in.nextLine();
			String zip = in.nextLine();
			Item zipk = new Item(zip, name);
			Item unik = new Item(name, zip);
			Zip_key.add(zipk);
			University_key.add(unik);
		}
		Collections.sort(Zip_key);
		Collections.sort(University_key);

	}

	/**
	 * Looks up an item in the table. This method returns a university for the given
	 * zip code.
	 * 
	 * @param zip: zip code to search
	 * @return a university name for the given zip, or null if zip does not have a
	 *         university.
	 */
	public String lookup_by_zip(String zip) {
		// COMPLETE this method
		for (int i = 0; i < Zip_key.size(); i++) {
			temp = Zip_key.get(i);
			if (zip.equals(temp.getKey())) {
				outp = temp.getValue();
				break;
			}
		}
		return outp;

	}

	/**
	 * Looks up an item in the table. This method returns a zip code for the given
	 * university
	 * 
	 * @param univ: university name to search
	 * @return the zip code of the given university, or null if no such university.
	 */
	public String lookup_by_university(String univ) {
		// COMPLETE this method
		for (int i = 0; i < University_key.size(); i++) {
			temp = University_key.get(i);
			if (univ.equals(temp.getKey())) {
				outp = temp.getValue();
				break;
			}
		}
		return outp;
	}
}
