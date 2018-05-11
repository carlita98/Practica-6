package es.ucm.fdi.view;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that receives three classes and creates a new thread to execute them 
 * @author Beatriz Herguedas, Carla Martínez 
 *
 */
public class Stepper{
	private Runnable before;
	private Runnable during;
	private Runnable after;
	
	private final static Logger log = Logger.getLogger(Stepper.class.getName());
	
	private volatile boolean stopRequested = false;
	private int steps;
	
	public Stepper(Runnable before, Runnable during, Runnable after) {
		this.before = before;
		this.during = during;
		this.after = after;
	}
	
	public Thread start (int steps, int delay) {
		this.steps = steps;
		stopRequested = false;
		
		Thread t = new Thread(()->{
			try {
				before.run();
				while (!stopRequested && Stepper.this.steps > 0) {
					during.run();
					try {
						Thread.sleep(delay);
					}catch(InterruptedException ie) {}
					Stepper.this.steps --;
				}
			}catch(Exception e) {
				log.log(Level.WARNING, "Exception while stepping, "
					+ this.steps + " remaining: "+ e, e);
			}finally {
				after.run();
			}
		});
		t.start();
		return t;
	}
	
	public void stop() {
		stopRequested = true;
	}
}
	
