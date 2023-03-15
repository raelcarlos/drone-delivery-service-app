package com.velozient.drone_delivery_app.utils;

import static java.lang.Double.valueOf;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.velozient.drone_delivery_app.model.Drone;
import com.velozient.drone_delivery_app.model.Location;

public class InputFileReaderTest {

	private static final String FILE_PATH_1 = "src/test/java/com/velozient/drone_delivery_app/utils/files/InputFileTest1.txt";
	private static final String FILE_PATH_2 = "src/test/java/com/velozient/drone_delivery_app/utils/files/InputFileTest2.txt";

	@Test
	public void readDronesInfoTest() throws IOException {
		InputFileReader inputFileReader = new InputFileReader(FILE_PATH_1);
		List<Drone> dronesInfo = inputFileReader.readDronesInfo();

		Assert.assertEquals(4, dronesInfo.size());

		Assert.assertEquals("DroneA", dronesInfo.get(0).getName());
		Assert.assertEquals(valueOf(400d), dronesInfo.get(0).getMaximumWeight());

		Assert.assertEquals("DroneC", dronesInfo.get(1).getName());
		Assert.assertEquals(valueOf(300d), dronesInfo.get(1).getMaximumWeight());

		Assert.assertEquals("DroneB", dronesInfo.get(2).getName());
		Assert.assertEquals(valueOf(150d), dronesInfo.get(2).getMaximumWeight());

		Assert.assertEquals("DroneD", dronesInfo.get(3).getName());
		Assert.assertEquals(valueOf(100d), dronesInfo.get(3).getMaximumWeight());
	}

	@Test
	public void readLocationsInfoTest() throws IOException {
		InputFileReader inputFileReader = new InputFileReader(FILE_PATH_1);
		List<Location> locationsInfo = inputFileReader.readLocationsInfo();

		Assert.assertEquals(8, locationsInfo.size());

		Assert.assertEquals("LocationC", locationsInfo.get(0).getName());
		Assert.assertEquals(valueOf(50), locationsInfo.get(0).getDeliveryWeight());

		Assert.assertEquals("LocationG", locationsInfo.get(1).getName());
		Assert.assertEquals(valueOf(50), locationsInfo.get(1).getDeliveryWeight());

		Assert.assertEquals("LocationH", locationsInfo.get(2).getName());
		Assert.assertEquals(valueOf(80d), locationsInfo.get(2).getDeliveryWeight());

		Assert.assertEquals("LocationE", locationsInfo.get(3).getName());
		Assert.assertEquals(valueOf(100d), locationsInfo.get(3).getDeliveryWeight());

		Assert.assertEquals("LocationB", locationsInfo.get(4).getName());
		Assert.assertEquals(valueOf(150d), locationsInfo.get(4).getDeliveryWeight());

		Assert.assertEquals("LocationD", locationsInfo.get(5).getName());
		Assert.assertEquals(valueOf(150d), locationsInfo.get(5).getDeliveryWeight());

		Assert.assertEquals("LocationA", locationsInfo.get(6).getName());
		Assert.assertEquals(valueOf(200d), locationsInfo.get(6).getDeliveryWeight());

		Assert.assertEquals("LocationF", locationsInfo.get(7).getName());
		Assert.assertEquals(valueOf(200d), locationsInfo.get(7).getDeliveryWeight());
	}

	@Test(expected = RuntimeException.class)
	public void readDronesInfoTestWhenTheMaximumNumberOfDronesHasBeenExceededTest() throws IOException {
		try {
			InputFileReader inputFileReader = new InputFileReader(FILE_PATH_2);
			inputFileReader.readDronesInfo();
		} catch (RuntimeException e) {
			Assert.assertEquals("The maximum number of drones has been exceeded.", e.getMessage());
			throw e;
		}
	}

}
