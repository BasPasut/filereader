package stopwatch;

/**
 * TaskTimer is the tool that used to measure and print the elapsed for specific
 * task.
 * @author Pasut Kittiprapas
 *	
 */
public class TaskTimer{

	/**
	 * Run the task and print the elapsed runtime of the task.
	 * @param run
	 */
	public void runTask(Runnable run){
		Stopwatch s = new Stopwatch();
		s.start();
		run.run();
		System.out.println(run.toString());
		s.stop();
		System.out.printf("Elasped time for running task : %.6f sec.\n",s.getElapsed());
	}

}
