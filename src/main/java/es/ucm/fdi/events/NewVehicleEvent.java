package es.ucm.fdi.events;

import es.ucm.fdi.launcher.RoadMap;
import es.ucm.fdi.simulatedObjects.Vehicle;

public class NewVehicleEvent extends Event{
	
	public NewVehicleEvent (String time, String id, String maxSpeed, String itinerary) {
		//EventList.add(new Vehicle (Integer.parseInt(time), id, Integer.parseInt (maxSpeed), ));
	}
	
	public void execute(RoadMap m) {
		//Hay que comprobar que no existe ningún objeto con ese identificador 
		m.addVehicle (new Vehicle ())
	}
}
