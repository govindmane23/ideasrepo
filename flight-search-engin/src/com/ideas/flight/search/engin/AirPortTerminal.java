package com.ideas.flight.search.engin;

import java.util.List;

public class AirPortTerminal implements Comparable<AirPortTerminal> {
	public final String name;
	public List<Route> adjacencies;
	public double minDistance = Double.POSITIVE_INFINITY;
	public AirPortTerminal previous;

	public AirPortTerminal(String argName) {
		name = argName;
	}

	public String toString() {
		return name;
	}

	@Override
	public boolean equals(Object arg0) {
		if (arg0 instanceof AirPortTerminal) {
			return this.name.equalsIgnoreCase(((AirPortTerminal) arg0).name);
		}

		return false;
	}

	public int compareTo(AirPortTerminal other) {
		return Double.compare(minDistance, other.minDistance);
	}
}