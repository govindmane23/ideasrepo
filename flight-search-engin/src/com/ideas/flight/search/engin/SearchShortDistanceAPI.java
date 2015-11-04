package com.ideas.flight.search.engin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class SearchShortDistanceAPI {

	private List<AirPortTerminal> terminalList = new ArrayList<AirPortTerminal>();

	private SearchEngine engine = new AirPortSearchEngine();

	private static SearchShortDistanceAPI api = null;

	private SearchShortDistanceAPI() {
		// mark all the vertices
		AirPortTerminal MSP = new AirPortTerminal("MSP");
		AirPortTerminal FFK = new AirPortTerminal("FFK");
		AirPortTerminal AMS = new AirPortTerminal("AMS");
		AirPortTerminal DBU = new AirPortTerminal("DBU");

		MSP.adjacencies = Arrays.asList(new Route[] { new Route(AMS, 620),
				new Route(DBU, 800), new Route(FFK, 220) });
		FFK.adjacencies = Arrays.asList(new Route[] { new Route(AMS, 310),
				new Route(MSP, 220) });
		AMS.adjacencies = Arrays.asList(new Route[] { new Route(FFK, 310),
				new Route(MSP, 620), new Route(DBU, 430) });
		DBU.adjacencies = Arrays.asList(new Route[] { new Route(MSP, 800),
				new Route(AMS, 430) });

		terminalList.add(MSP);
		terminalList.add(FFK);
		terminalList.add(AMS);
		terminalList.add(DBU);
	}

	public static SearchShortDistanceAPI getAPI() {
		if (api == null) {
			api = new SearchShortDistanceAPI();
		}

		return api;
	}

	/**
	 * find the shortest route for given source and destination.
	 * 
	 * @param source
	 * @param destination
	 * @return
	 */
	public List<AirPortTerminal> findSortestRoute(AirPortTerminal source,
			AirPortTerminal destination) {
		engine.computePaths(source);

		System.out.println("Distance to " + destination + " from " + source
				+ " : " + destination.minDistance);
		List<AirPortTerminal> path = engine.getShortestPathTo(destination);
		return path;
	}

	/**
	 * remove path to find the other shortest paths.
	 * 
	 * @param path
	 */
	public void removePath(List<AirPortTerminal> path) {
		for (AirPortTerminal terminal : path) {
			System.out.println(terminal);
			// terminal.adjacencies.remove(nextTerminal);
		}
	}

	/**
	 * search the paths.
	 * 
	 * @param source
	 * @param destination
	 */
	public void search(AirPortTerminal source, AirPortTerminal destination) {
		int searchIndex = 0;
		// do {
		AirPortTerminal orgSource = terminalList.get(terminalList
				.indexOf(source));
		AirPortTerminal orgDestination = terminalList.get(terminalList
				.indexOf(destination));

		List<AirPortTerminal> path = api.findSortestRoute(orgSource,
				orgDestination);
		System.out.println("Path: " + path);
		// api.removePath(path);
		searchIndex++;
		// } while (searchIndex < 32);
	}
}
