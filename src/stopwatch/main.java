package stopwatch;

public class main {

	public static void main(String[] args) {
		String filename = "Alice-in-Wonderland.txt";
		TaskTimer t1 = new TaskTimer();
		Runnable ast = new AppendStringTask(filename);
		Runnable asbt = new AppendStringBuilderTask(filename);
		Runnable asubr = new AppendStringUsingBufferedReader(filename);
		t1.runTask(ast);
		t1.runTask(asbt);
		t1.runTask(asubr);
				
	}

}
