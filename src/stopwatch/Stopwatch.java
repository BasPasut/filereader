package stopwatch;

/**
 * A Stopwatch that measures elapsed time between a starting time and stopping
 * time, or until the present time.
 * 
 * @author Pasut Kittiprapas
 *
 */
public class Stopwatch {

	private static final double NANOSECONDS = 1.0E-9;
	boolean checkRun;
	private long startTime;
	private long stopTime;

	public Stopwatch() {
		checkRun = false;
	}

	/** Start the stopwatch if it is not already running. */
	void start() {
		if (checkRun)
			return;
		else {
			this.startTime = System.nanoTime();
			checkRun = true;
		}
	}

	/** Stop the stopwatch if it is running. */
	void stop() {
		if (!checkRun)
			return;
		else {
			this.stopTime = System.nanoTime();
			checkRun = false;
		}
	}

	/**
	 * Check whether the stopwatch is running or not.
	 * 
	 * @return the status of the stopwatch whether it start or stop.
	 */
	boolean isRunning() {
		return this.checkRun;

	}

	/**
	 * If the stopwatch is running, then return the elapsed time since start
	 * until the current time but If stopwatch is stopped, then return the time
	 * between the start and stop times.
	 * 
	 * @return the elapsed time in seconds.
	 */
	double getElapsed() {
		if (checkRun) {
			return (System.nanoTime() - startTime) * NANOSECONDS;
		}
		return (stopTime - startTime) * NANOSECONDS;

	}
}
