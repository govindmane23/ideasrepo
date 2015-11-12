package com.ideas.flight.search.engine;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.ideas.flight.search.engin.AirPortTerminal;
import com.ideas.flight.search.engin.SearchShortDistanceAPI;

public class SearchShortDistanceTest {

	@Test
	public void testFindShortestDistance() {

		final SearchShortDistanceAPI api = SearchShortDistanceAPI.getAPI();
		final AirPortTerminal source = api.getTerminal(new AirPortTerminal("MSP"));
		final AirPortTerminal destination = api.getTerminal(new AirPortTerminal("DBU"));
		

		final List<AirPortTerminal> path = api.findSortestRoute(source,
				destination);
		assertFalse("path should not empty", path.isEmpty());
		assertTrue("path should have source", path.contains(source));
		assertTrue("path should have destination", path.contains(destination));
	}
	
	@Test(expected =  NullPointerException.class)
	public void testFindShortestDistanceForException() {

		final SearchShortDistanceAPI api = SearchShortDistanceAPI.getAPI();
		final AirPortTerminal source = new AirPortTerminal("MSP");
		final AirPortTerminal destination = new AirPortTerminal("DBU");

		final List<AirPortTerminal> path = api.findSortestRoute(source,
				destination);
		fail("should not reach here, as source is not configured");
	}

	@Test
	public void testSearch() {
		try {
			final SearchShortDistanceAPI api = SearchShortDistanceAPI.getAPI();
			final AirPortTerminal source = new AirPortTerminal("MSP");
			final AirPortTerminal destination = new AirPortTerminal("DBU");

			api.search(source, destination);
		} catch (Exception ex) {
			fail("shouldnot reach here");
		}
	}

}
