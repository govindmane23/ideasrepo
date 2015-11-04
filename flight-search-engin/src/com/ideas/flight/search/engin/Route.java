package com.ideas.flight.search.engin;

public class Route {
	public final AirPortTerminal target;
	public final double distance;

	public Route(AirPortTerminal argTarget, double argDistance) {
		target = argTarget;
		distance = argDistance;
	}

}
