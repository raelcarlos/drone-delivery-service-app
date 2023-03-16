package com.velozient.drone_delivery_app.utils;

import static java.lang.Double.parseDouble;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.velozient.drone_delivery_app.model.Drone;
import com.velozient.drone_delivery_app.model.Location;

public class InputFileReader {
	
	private List<String> fileLines;
	
	public InputFileReader(String filePath) throws IOException {
		this.fileLines = Files.readAllLines(Paths.get(filePath), Charset.defaultCharset());
	}
	
	public List<Drone> readDronesInfo() {
		List<Drone> drones = new ArrayList<>();
		String[] lines = getFileLines().get(0).split("\\,");
        for (int i = 0; i < lines.length; i+=2) {
        	String name = lines[i].replace("[", "").replace("]", "").trim();
        	String maximumWeight = lines[i+1].replace("[", "").replace("]", "").trim();
        	drones.add(new Drone(name, parseDouble(maximumWeight)));
        	if (drones.size() > 100) {
        		throw new RuntimeException("The maximum number of drones has been exceeded.");
        	}
        }
        Collections.sort(drones);
        return drones;
	}
	
	public List<Location> readLocationsInfo() {
		List<Location> locations = new ArrayList<>();
        for (int i = 1; i < getFileLines().size(); i++) {
        	String[] locationInfo = getFileLines().get(i).split("\\,");
        	String locationName = locationInfo[0].replace("[", "").replace("]", "").trim();
        	String deliveryWeight = locationInfo[1].replace("[", "").replace("]", "").trim();
        	locations.add(new Location(locationName, parseDouble(deliveryWeight)));
        }
        Collections.sort(locations);
        return locations;
	}
	
	public List<String> getFileLines() {
		return fileLines;
	}

}
