package com.velozient.drone_delivery_app.utils;

import static com.velozient.drone_delivery_app.utils.OutputFileGenerator.generateOutputFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class OutputFileGeneratorTest {
	
	private static final String OUTPUT_TEST_FILE_PATH = "src/test/java/com/velozient/drone_delivery_app/utils/files/OutputFileTest1.txt";
	
	@Test
	public void writeOutputFileTest() throws IOException {
		generateOutputFile(new TestScenarios().getTripByDrone(), OUTPUT_TEST_FILE_PATH);
		
		List<String> fileLines = Files.readAllLines(Paths.get(OUTPUT_TEST_FILE_PATH), Charset.defaultCharset());
		
		Assert.assertEquals(11, fileLines.size());
		Assert.assertEquals("[DroneA]", fileLines.get(0));
		Assert.assertEquals("Trip #1", fileLines.get(1));
		Assert.assertEquals("[LocationA],[LocationD],[LocationB]", fileLines.get(2));
		Assert.assertEquals("Trip #2", fileLines.get(3));
		Assert.assertEquals("[LocationC],[LocationG]", fileLines.get(4));
		Assert.assertEquals("", fileLines.get(5));
		Assert.assertEquals("[DroneB]", fileLines.get(6));
		Assert.assertEquals("Trip #1", fileLines.get(7));
		Assert.assertEquals("[LocationE]", fileLines.get(8));
		Assert.assertEquals("Trip #2", fileLines.get(9));
		Assert.assertEquals("[LocationF]", fileLines.get(10));
		
	}

}
