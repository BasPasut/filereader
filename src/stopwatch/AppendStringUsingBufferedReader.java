package stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Append a char from a file to String by using BufferedReader.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class AppendStringUsingBufferedReader implements Runnable {

	private String filename;
	private double size;
	
	public AppendStringUsingBufferedReader(String filename) {
		this.filename = filename;
	}

	/**
	 * Add char from the file that we input to String by using BufferedReader until it reach the last
	 * char in the file
	 */
	@Override
	public void run() {
		// create a string for the data to read
		String data = "";
		BufferedReader br = null;
		try {
			FileReader reader = new FileReader(filename);
			br = new BufferedReader(reader);
			String count;
			while ((count = br.readLine()) != null) {
				data = data + count + "\n";
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (br != null)
			try {
				br.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		size = data.length();
	}
	
	/**
	 * The detail of the file that we input.
	 */
	public String toString(){
		return String.format("Read file line at a time using BufferedReader.\nThis file have %.0f characters.",size);
	}

}
