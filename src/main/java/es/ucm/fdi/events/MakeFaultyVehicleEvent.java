package es.ucm.fdi.events;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import es.ucm.fdi.launcher.RoadMap;
import es.ucm.fdi.simulatedObjects.Vehicle;

public class MakeFaultyVehicleEvent extends Event {
	private ArrayList<String> id = new ArrayList<>();
	private int duration;
	public MakeFaultyVehicleEvent(int t, ArrayList<String> i, int d) {
		time = t;
		id = i;
		duration = d;
	}
	
	public void execute(RoadMap m) {
		for(int i = 0; i < id.size(); i++){
			try{
				m.getVehicle(id.get(i)).setFaultyTime(duration);
			}catch(NoSuchElementException e){
				e.printStackTrace();
			}
		}
	}
}
