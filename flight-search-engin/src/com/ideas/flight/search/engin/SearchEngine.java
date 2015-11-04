package com.ideas.flight.search.engin;

import java.util.List;

public interface SearchEngine {
	/**
	 * compute the all paths from the given terminal.
	 * 
	 * @param terminal1
	 */
	public void computePaths(AirPortTerminal terminal1);

	/**
	 * find the shortest distance using the computed path to the destination.
	 * 
	 * @param destination
	 * @return
	 */
	public List<AirPortTerminal> getShortestPathTo(AirPortTerminal destination);
}
