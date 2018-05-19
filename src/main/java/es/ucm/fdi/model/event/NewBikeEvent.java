package es.ucm.fdi.model.event;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import es.ucm.fdi.model.RoadMap;
import es.ucm.fdi.model.SimulatorException;
import es.ucm.fdi.model.object.Bike;
import es.ucm.fdi.model.object.Junction;
import es.ucm.fdi.model.object.Vehicle;

/**
 * Introduce a new Bike in the RoadMap
 * 
 * @author Carla Martínez, Beatriz Herguedas
 *
 */

public class NewBikeEvent extends NewVehicleEvent {

	private String type;

	/**
	 * Constructor
	 * 
	 * @param time
	 * @param id
	 * @param maxSpeed
	 * @param itinerary
	 * @param type
	 */
	public NewBikeEvent(int time, String id, int maxSpeed, ArrayList<String> itinerary, String type) {
		super(time, id, maxSpeed, itinerary);
		this.type = type;
	}

	/**
	 * Introduce a new Bike in the RoadMap
	 * @throws SimulatorException 
	 */
	public void execute(RoadMap m) throws SimulatorException {
		ArrayList<Junction> jList = new ArrayList<>();
		try {
			for (int i = 0; i < itinerary.size(); i++) {
				jList.add(m.getJunction(itinerary.get(i)));
			}

			Vehicle v = new Bike(id, maxSpeed, jList, type);
			m.addVehicle(v);

		} catch (Exception e) {
			throw new SimulatorException(
					"There has been a problem while adding bike ", e);
		}
	}
}
