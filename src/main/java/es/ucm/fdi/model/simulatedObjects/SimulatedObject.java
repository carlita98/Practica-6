package es.ucm.fdi.model.simulatedObjects;

import java.util.Map;

public abstract class SimulatedObject {
	protected String id;
	protected int time;
	public String getId() {
		return id;
	}
	
	public SimulatedObject(String id) {
		this.id = id;
	}
	
	public void report (Map <String, String> out) {
		out.put("", getReportHeader());
		out.put("id", id);
		out.put("time", "" + time);
		fillReportDetails (out);
	}
	protected abstract String getReportHeader();
	protected abstract void fillReportDetails (Map <String, String> out);
	public abstract void moveForward();


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + time;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimulatedObject other = (SimulatedObject) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (time != other.time)
			return false;
		return true;
	}
	
}
