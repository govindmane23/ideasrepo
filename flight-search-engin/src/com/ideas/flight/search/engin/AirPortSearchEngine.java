package com.ideas.flight.search.engin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class AirPortSearchEngine implements SearchEngine {

	public void computePaths(AirPortTerminal terminal1) {
		terminal1.minDistance = 0.;
		PriorityQueue<AirPortTerminal> terminalQueue = new PriorityQueue<AirPortTerminal>();
		terminalQueue.add(terminal1);

		while (!terminalQueue.isEmpty()) {
			AirPortTerminal u = terminalQueue.poll();

			// Visit each route exiting source
			for (Route e : u.adjacencies) {
				AirPortTerminal v = e.target;
				double distance = e.distance;
				double distanceThroughU = u.minDistance + distance;
				if (distanceThroughU < v.minDistance) {
					terminalQueue.remove(v);

					v.minDistance = distanceThroughU;
					v.previous = u;
					terminalQueue.add(v);
				}
			}

		}

		System.out.println(terminalQueue);
	}

	public List<AirPortTerminal> getPathTo(AirPortTerminal destination) {
		List<AirPortTerminal> path = new ArrayList<AirPortTerminal>();
		for (AirPortTerminal terminal = destination; terminal != null; terminal = terminal.previous)
			path.add(terminal);

		Collections.reverse(path);
		return path;
	}
	
	public List<AirPortTerminal> getShortestPathTo(AirPortTerminal destination) {
		List<AirPortTerminal> path = new ArrayList<AirPortTerminal>();
		for (AirPortTerminal terminal = destination; terminal != null; terminal = terminal.previous)
			path.add(terminal);

		Collections.reverse(path);
		return path;
	}
}
