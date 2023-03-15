package com.velozient.drone_delivery_app.utils;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.velozient.drone_delivery_app.model.Location;
import com.velozient.drone_delivery_app.model.Trip;

public class OutputFileGenerator {
	
	public static void generateOutputFile(Map<String, List<Trip>> tripsByDrone) throws IOException {
        OutputStream os = new FileOutputStream("src/main/resources/Output.txt");
        BufferedWriter br = new BufferedWriter(new OutputStreamWriter(os));
        
        for (Map.Entry<String, List<Trip>> entry : tripsByDrone.entrySet()) { 
        	String droneName = entry.getKey();
        	List<Trip> droneTrips = entry.getValue();
        	int tripNumber = 1;
        	br.write("[" + droneName + "]");
        	br.newLine();
        	for (Trip trip : droneTrips) {
        		br.write("Trip #" + tripNumber);
        		br.newLine();
        		for (Iterator<Location> iter = trip.getLocations().iterator(); iter.hasNext();) {
        			Location location = iter.next();
        			br.write("[" + location.getName() + "]");
        			if (iter.hasNext()) {
        				br.write(",");
        			}
        		}
        		tripNumber++;
        		br.newLine();
        	}
        	br.newLine();
        }
        br.close();
	}

}
