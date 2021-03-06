package stopwatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Append a char from a file to the StringBuilder.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class AppendStringBuilderTask implements Runnable {

	private String filename;
	private double size;

	public AppendStringBuilderTask(String filename) {
		this.filename = filename;
	}

	/**
	 * Add char from the file that we input to StringBuilder until it reach the
	 * last char in the file
	 */
	@Override
	public void run() {
		// create a string for the data to read
		StringBuilder data = new StringBuilder();
		InputStream in = null;
		try {
			// open the file
			in = new FileInputStream(filename);
			// read as characters
			InputStreamReader reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) {
				c = reader.read();
				if (c < 0)
					break;
				data = data.append((char) c);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		// close the file
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		size = data.length();
	}

	/**
	 * The detail of the file that we input.
	 */
	public String toString() {
		return String.format("Read file 1-char at a time to StringBuilder.\nThis file have %.0f characters.", size);
	}
}
