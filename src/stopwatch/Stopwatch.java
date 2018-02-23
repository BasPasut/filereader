package stopwatch;

/**
 * A Stopwatch that measures elapsed time between a starting time and stopping
 * time, or until the present time.
 * @author Pasut Kittiprapas
 *
 */
public class Stopwatch {
	
	private static final double NANOSECONDS = 1.0E-9;
	boolean checkRun;
	private long startTime;
	private long stopTime;
	
	public Stopwatch(){
		checkRun = false;
	}
	
	void start(){
		if(checkRun) return;
		else{
			this.startTime = System.nanoTime();
			checkRun = true;
		}
	}
	
	void stop(){
		if(!checkRun) return;
		else{
			this.stopTime = System.nanoTime();
			checkRun = false;
		}
	}
	
	boolean isRunning(){
		return this.checkRun;
		
	}
	
	double getElapsed(){
		if(checkRun){
			return (System.nanoTime() - startTime) * NANOSECONDS;
		}
		return (stopTime-startTime) * NANOSECONDS ;
		
	}
}
