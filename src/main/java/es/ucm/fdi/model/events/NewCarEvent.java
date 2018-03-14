package es.ucm.fdi.model.events;

import java.util.ArrayList;
import java.util.Random;

import es.ucm.fdi.model.RoadMap.RoadMap;
import es.ucm.fdi.model.simulatedObjects.Car;
import es.ucm.fdi.model.simulatedObjects.Junction;
import es.ucm.fdi.model.simulatedObjects.Vehicle;

public class NewCarEvent extends NewVehicleEvent{
	private String type;
	private int resistance;
	private double faultyProbability;
	private int maxFaultDuration;
	private long seed;
	
	public NewCarEvent(int time, String id, int maxSpeed, ArrayList<String> itinerary, String type,
			 int resistance, double faultyProbability, int maxFaultDuration, long seed) {
		super(time, id, maxSpeed, itinerary);
		this.type = type;
		this.resistance = resistance;
		this.faultyProbability = faultyProbability;
		this.maxFaultDuration = maxFaultDuration;
		if (seed == System.currentTimeMillis()) {
			this.seed = new Random().nextInt (1000);
		}
		else this.seed = seed;
	}
	
	public void execute(RoadMap m) {
		ArrayList <Junction> jList = new ArrayList <>();
		for (int i = 0; i < itinerary.size(); i++){
			jList.add(m.getJunction(itinerary.get(i))) ;
		}
		try{
			m.addVehicle(new Car ( id, maxSpeed, jList, type, resistance, faultyProbability, maxFaultDuration, seed));
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException("There has been a problem while adding Car ", e);
		}
	}

}
