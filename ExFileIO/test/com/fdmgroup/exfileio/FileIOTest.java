package com.fdmgroup.exfileio;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FileIOTest {

	FileIO classUnderTest;
	
	// IO Exercise # 1
	@Before
	public void setUp() throws Exception {
		classUnderTest = new FileIO();
	}

	@Test
	public void testFileWith33A() {
		assertTrue(classUnderTest.countE("temp.txt", 'A')==33);
	}
	
	@Test
	public void testFileWithMixed33A() {
		assertTrue(classUnderTest.countE("temp.txt", 'A')==33);
	}
	
	// IO Exercise # 2
	@Test
	public void testWriteUserToFile() {
		classUnderTest.writeUserToFile("./out.txt");
	}
	
	// IO Exercise # 3
	@Test
	public void testReadUserToObject() {
		classUnderTest.readUserToObject("./out.txt");
	}
}
