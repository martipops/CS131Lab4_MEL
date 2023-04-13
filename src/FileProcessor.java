
/**
 * The FileProcessor class is responsible for processing a given file and storing
 * its contents in an ArrayList. The maximum length of each string is set
 * during object creation.
 * 
 * @author Marti Lonnemann
 * @version 1.0
 * CS131_Lab4_0_MEL: Files and their Errors
 * S2/2023
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileProcessor {
	private String fileName;
	private int stringLength;
	private ArrayList<String> stringList;
	private Scanner input;

	/**
	 * Constructor that accepts name of a file and maximum string length.
	 * 
	 * @param fileName     name or path of the file to be processed
	 * @param stringLength maximum length of the strings allowed
	 */
	public FileProcessor(String fileName, int stringLength) {
		this.fileName = fileName;
		stringList = new ArrayList<String>();

		if (stringLength < 5) {
			this.stringLength = 5;
		} else {
			this.stringLength = stringLength;
		}
	}

	/**
	 * @return size of the ArrayList containing strings from file
	 */
	public int getArrayListSize() {
		return stringList.size();
	}

	/**
	 * Reads the file and stores the valid strings in stringList variable. Throws
	 * StringTooLongException if a line from file is longer than the allowed
	 * stringLength.
	 */
	public void processFile() {
		try {
			input = new Scanner(new File(fileName));
			while (input.hasNextLine()) {
				String line = input.nextLine();
				if (line.length() > stringLength) {
					throw new StringTooLongException("String is too long!");
				}
				stringList.add(line);
			}

		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + e.getMessage());
		} catch (StringTooLongException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Returns a string representation of the ArrayList containing the file's valid
	 * strings. (For testing purposes)
	 */
	@Override
	public String toString() {
		if (stringList == null)
			return "stringList is empty";
		StringBuilder sb = new StringBuilder("--------stringList--------");
		stringList.forEach((line) -> sb.append("\n" + line));
		return sb.toString();
	}

}

/**
 * Exception class to be thrown when a line in file is longer than the allowed
 * string length.
 */
class StringTooLongException extends Exception {
	public StringTooLongException(String message) {
		super(message);
	}
}
