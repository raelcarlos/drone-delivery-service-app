package com.velozient.drone_delivery_app;

import static com.velozient.drone_delivery_app.utils.OutputFileGenerator.generateOutputFile;

import java.io.IOException;

import com.velozient.drone_delivery_app.service.TripManagerService;

public class DroneDeliveryServiceApp {
	
	private static final String OUTPUT_FILE_PATH = "src/main/resources/Output.txt";
	
    public static void main( String[] args ) throws IOException {
        generateOutputFile(new TripManagerService().generateTrips(), OUTPUT_FILE_PATH);
    }

}
