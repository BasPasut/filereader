package stopwatch;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class AppendStringUsingBufferedReader implements Runnable {

	private String filename;

	public AppendStringUsingBufferedReader(String filename) {
		this.filename = filename;
	}

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

	}
	
	public String toString(){
		return String.format("Read file line at a time using BufferedReader.");
	}

}