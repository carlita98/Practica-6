package es.ucm.fdi.view;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import es.ucm.fdi.control.Controller;
import es.ucm.fdi.model.Simulator.EventType;

public class RunThread extends Thread{
	private int timeUnits;
	private Controller ctrl;
	private int timeDelay;
	
	public RunThread(int timeUnits, Controller ctrl, int timeDelay) {
		this.timeUnits = timeUnits;
		this.ctrl = ctrl;
		this.timeDelay = timeDelay;
	}
	
	public void run () {
		for (int i = 0; i < timeUnits; i++) {
			ctrl.getSim().execute(1, new ByteArrayOutputStream());
			try {
				this.sleep(timeDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
