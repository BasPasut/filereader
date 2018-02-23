package stopwatch;

import java.io.*;
import java.util.Scanner;

public class FileTasks {

	public static String readFiletoString(String filename) {
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

		return data.toString();
	}

	public static String readFilebyStringBuilder(String filename) {
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

		return data.toString();
	}

	public static String readFiletoBufferedReader(String filename) {
		// create a string for the data to read
		String data = "";
		BufferedReader br = null;
		try {
			FileReader reader = new FileReader(filename);
			br = new BufferedReader(reader);
			String count;
			while ((count = br.readLine()) !=null) {
				data = data + count + '\n';
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		if(br != null)try{
			br.close();
		}
		catch(IOException e){
			System.out.println(e.getMessage());
		}
		return data;
	}

	public static void countTimeString(String filename) {
		Stopwatch s = new Stopwatch();
		s.start();
		String file = readFiletoString(filename);
		s.stop();
		System.out.printf("Read %d char in %.6f sec.\n", file.length(), s.getElapsed());
	}

	public static void countTimeStringBuilder(String filename) {
		Stopwatch s = new Stopwatch();
		s.start();
		String file = readFilebyStringBuilder(filename);
		s.stop();
		System.out.printf("Read %d char in %.6f sec.\n", file.length(), s.getElapsed());
	}

	public static void countTimebyBuffer(String filename) {
		Stopwatch s = new Stopwatch();
		s.start();
		String file = readFiletoBufferedReader(filename);
		s.stop();
		System.out.printf("Read %d char in %.6f sec.\n", file.length(), s.getElapsed());
	}

	public static void main(String[] args) {
		String alice = "Alice-in-Wonderland.txt";
		countTimeString(alice);
		countTimeStringBuilder(alice);
		countTimebyBuffer(alice);
		System.out.println("---------------------------------");
	}
}
