package com.ideas.flight.search.engin;

public class B2CApp {
	public static void main(String[] args) {
		SearchShortDistanceAPI api = SearchShortDistanceAPI.getAPI();
		AirPortTerminal source = new AirPortTerminal("MSP");
		AirPortTerminal destination = new AirPortTerminal("DBU");

		api.search(source, destination);
	}
}
