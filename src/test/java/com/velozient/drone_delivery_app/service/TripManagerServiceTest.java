package com.velozient.drone_delivery_app.service;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.velozient.drone_delivery_app.utils.OutputFileGenerator;

import junit.framework.Assert;

public class TripManagerServiceTest {
	
	private static final String OUTPUT_TEST_FILE_PATH = "src/test/java/com/velozient/drone_delivery_app/utils/files/OutputFileTest2.txt";
	
	@Test
	public void generateTripsTest() throws IOException {
		OutputFileGenerator.generateOutputFile(new TripManagerService().generateTrips(), OUTPUT_TEST_FILE_PATH);
		
		List<String> fileLines = Files.readAllLines(Paths.get(OUTPUT_TEST_FILE_PATH), Charset.defaultCharset());
		
		Assert.assertEquals(19, fileLines.size());
		Assert.assertEquals("[DroneA]", fileLines.get(0));
		Assert.assertEquals("Trip #1", fileLines.get(1));
		Assert.assertEquals("[LocationA]", fileLines.get(2));
		Assert.assertEquals("Trip #2", fileLines.get(3));
		Assert.assertEquals("[LocationB],[LocationJ]", fileLines.get(4));
		Assert.assertEquals("", fileLines.get(5));
		Assert.assertEquals("[DroneB]", fileLines.get(6));
		Assert.assertEquals("Trip #1", fileLines.get(7));
		Assert.assertEquals("[LocationF],[LocationM]", fileLines.get(8));
		Assert.assertEquals("Trip #2", fileLines.get(9));
		Assert.assertEquals("[LocationD],[LocationP]", fileLines.get(10));
		Assert.assertEquals("Trip #3", fileLines.get(11));
		Assert.assertEquals("[LocationI],[LocationG],[LocationC],[LocationN],[LocationK],[LocationL]", fileLines.get(12));
		Assert.assertEquals("", fileLines.get(13));
		Assert.assertEquals("[DroneC]", fileLines.get(14));
		Assert.assertEquals("Trip #1", fileLines.get(15));
		Assert.assertEquals("[LocationE]", fileLines.get(16));
		Assert.assertEquals("Trip #2", fileLines.get(17));
		Assert.assertEquals("[LocationH],[LocationO]", fileLines.get(18));
	}

}
