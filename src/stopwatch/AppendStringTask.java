package stopwatch;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Append a char from a file to the String.
 * @author Pasut Kittiprapas
 *
 */
public class AppendStringTask implements Runnable {

	private String filename;
	private double size;

	public AppendStringTask(String filename) {
		this.filename = filename;
	}

	@Override
	public void run() {
		// create a string for the data to read
		String data = "";
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
				data = data + (char) c;
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

	public String toString() {
		return String.format("Read file 1-char at a time to String.\nThis file have %.0f characters.",size);
		
	}

}
