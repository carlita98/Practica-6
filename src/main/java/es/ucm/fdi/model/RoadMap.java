package es.ucm.fdi.model;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import es.ucm.fdi.model.object.Junction;
import es.ucm.fdi.model.object.Road;
import es.ucm.fdi.model.object.SimulatedObject;
import es.ucm.fdi.model.object.Vehicle;

/**
 * Contains a Map with all the SimulatedObjects, and three list with all the
 * Junctions, Roads and Vehicles
 * 
 * @author Carla Martínez
 *
 */
public class RoadMap {
	private Map<String, SimulatedObject> simObjects = new HashMap<String, SimulatedObject>();;
	private List<Junction> junctions = new ArrayList<>();
	private List<Road> roads = new ArrayList<>();
	private List<Vehicle> vehicles = new ArrayList<>();
	private List<Junction> junctionsRO = Collections.unmodifiableList(junctions);
	private List<Road> roadsRO = Collections.unmodifiableList(roads);
	private List<Vehicle> vehiclesRO = Collections.unmodifiableList(vehicles);

	public List<Junction> getJunctionsRO() {
		return junctionsRO;
	}

	public List<Road> getRoadsRO() {
		return roadsRO;
	}

	public List<Vehicle> getVehiclesRO() {
		return vehiclesRO;
	}

	/**
	 * Get the Junction with an specific id
	 * 
	 * @param id
	 * @return Junction
	 */
	public Junction getJunction(String id) {

		if (simObjects.containsKey(id) && simObjects.get(id) instanceof Junction) {
			return (Junction) simObjects.get(id);
		} else {
			throw new NoSuchElementException(
			        "A junction with ID: " + id + " does not exist");
		}
	}

	/**
	 * Get the Road with an specific id
	 * 
	 * @param id
	 * @return Road
	 */
	public Road getRoad(String id) {

		if (simObjects.containsKey(id) && simObjects.get(id) instanceof Road) {
			return (Road) simObjects.get(id);
		} else {
			throw new NoSuchElementException(
			        "A road with ID: " + id +" does not exist");
		}
	}

	/**
	 * Get the Vehicle with an specific id
	 * 
	 * @param id
	 * @return Vehicle
	 */
	public Vehicle getVehicle(String id) {

		if (simObjects.containsKey(id) && simObjects.get(id) instanceof Vehicle) {
			return (Vehicle) simObjects.get(id);
		} else {
			throw new NoSuchElementException(
			        "A vehicle with ID: " + id + " does not exist");
		}
	}

	/**
	 * Getter method for junctions
	 * 
	 * @return List <Juntion>
	 */
	public List<Junction> getJunctions() {
		return junctions;
	}

	/**
	 * Getter method for roads
	 * 
	 * @return roads
	 */
	public List<Road> getRoads() {
		return roads;
	}

	/**
	 * Getter method for vehicles
	 * 
	 * @return vehicles
	 */
	public List<Vehicle> getVehicles() {
		return vehicles;
	}

	/**
	 * Getter method for simObjects
	 * 
	 * @return simOjects
	 */
	public Map<String, SimulatedObject> getMap() {
		return simObjects;
	}

	/**
	 * Add a new Junction to simObjects
	 * 
	 * @param j
	 */
	public void addJunction(Junction j) throws IllegalArgumentException{

		if (simObjects.containsKey(j.getId())) {
			throw new IllegalArgumentException(
			        "This ID: " + j.getId() + " already exists");
		} else {
			junctions.add(j);
			simObjects.put(j.getId(), j);
		}
	}

	/**
	 * Add a new Road to simObjects
	 * 
	 * @param r
	 */
	public void addRoad(Road r) throws IllegalArgumentException{

		if (simObjects.containsKey(r.getId())) {
			throw new IllegalArgumentException(
			        "This ID: " + r.getId() + " already exist");
		} else {
			roads.add(r);
			simObjects.put(r.getId(), r);
		}
	}

	/**
	 * Add a new Vehicle to simObjects
	 * 
	 * @param v
	 */
	public void addVehicle(Vehicle v) throws IllegalArgumentException{

		if (simObjects.containsKey(v.getId())) {
			throw new IllegalArgumentException(
			        "This ID: " + v.getId() + " already exist");
		} else {
			vehicles.add(v);
			simObjects.put(v.getId(), v);
		}
	}
}
