package com.fdmgroup.subexercise2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Before;
import org.junit.Test;

public class Subexercise2Test {

	Subexercise2 classUnderTest;
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new Subexercise2();
	}

	@Test
	public void testLetterCount_HELLOTHERE() {
		HashMap<Character, Integer> returnedHmap = classUnderTest.countLetters("HELLO THERE");
		
		assertTrue(returnedHmap.get('H') == 2);
		assertTrue(returnedHmap.get('E') == 3);
		assertTrue(returnedHmap.get('L') == 2);
		assertTrue(returnedHmap.get('O') == 1);
		assertTrue(returnedHmap.get('T') == 1);
		assertTrue(returnedHmap.get('R') == 1);
		
	}
	
	@Test
	public void testLetterCount_UWHYUHELLO() {
		HashMap<Character, Integer> returnedHmap = classUnderTest.countLetters("U WHY U HELLO");
		
		assertTrue(returnedHmap.get('U') == 2);
		assertTrue(returnedHmap.get('H') == 2);
		assertTrue(returnedHmap.get('L') == 2);
		assertTrue(returnedHmap.get('O') == 1);
		assertTrue(returnedHmap.get('W') == 1);
		assertTrue(returnedHmap.get('Y') == 1);
	}
	
	@Test
	public void testWordCount_LadyAteTheWackedFrogLadyDid_OneDupe(){
		int countsOfDupedWords = classUnderTest.countDupedWords("Lady Ate The Wacked Frog Lady Did");
		assertTrue(countsOfDupedWords == 1);
	}
	
	@Test
	public void testWordCount_LadyAteTheWackedFrogLadyAte(){
		int countsOfDupedWords = classUnderTest.countDupedWords("Lady Ate The Wacked Frog Lady Ate");
		assertTrue(countsOfDupedWords == 2);
	}

	@Test
	public void testWordCount_ACatInTheHatLackedACatWithNoHat(){
		int countsOfDupedWords = 
				classUnderTest.countDupedWords("A Cat In The Hat Lacked A Cat With No Hat");
		assertTrue(countsOfDupedWords == 3);
	}
	
	@Test
	public void testLinkedListReverseOrder() {
		LinkedList<String> inOrder = new LinkedList<String>();
        inOrder.add("Item1");
        inOrder.add("Item5");
        inOrder.add("Item3");
        inOrder.add("Item6");
        inOrder.add("Item2");
        LinkedList<String> expected = new LinkedList<String>();
        expected.add("Item2");
        expected.add("Item6");
        expected.add("Item3");
        expected.add("Item5");
        expected.add("Item1");
		LinkedList<String> reversed = classUnderTest.reverseList(inOrder);
		assertTrue(reversed.equals(expected));
	}
	
	@Test
	public void testRemoveDupedNames_InputOneDupe_ReturnSizeTwo() {
		Set<String> noDupes = classUnderTest.removeDupedNames("alex", "alex", "john");
		assertTrue(noDupes.size()==2);
	}
	
	@Test
	public void testRemoveDupedNames_NoDupe_ReturnSizeThree() {
		Set<String> noDupes = classUnderTest.removeDupedNames("hermione", "alex", "john");
		assertTrue(noDupes.size()==3);
	}
	
	@Test
	public void testUserInputLineIntoTreeSet_ReturnSorted() {
		TreeSet<String> addToOrderInput;
		TreeSet<String> expectedTree = new TreeSet<String>();
		expectedTree.add("A");
		expectedTree.add("B");
		expectedTree.add("C");
		expectedTree.add("a");
		expectedTree.add("b");
		expectedTree.add("bye");
		expectedTree.add("c");
		expectedTree.add("hi");
		addToOrderInput = classUnderTest.orderTreeSet("a b c A B C hi bye");
		assertTrue(addToOrderInput.equals(expectedTree)); 
	}
	
	@Test
	public void testThreeInputLineIntoTreeSet_ReturnSorted() {
		TreeSet<String> addToOrderInput;
		TreeSet<String> expectedTree = new TreeSet<String>();
		expectedTree.add("A");
		expectedTree.add("B");
		expectedTree.add("C");
		addToOrderInput = classUnderTest.orderTreeSet("A B C");
		assertTrue(addToOrderInput.equals(expectedTree)); 
	}
	
	@Test
	public void testThreeInputLineIntoTreeSet_OneSame_ReturnSorted() {
		TreeSet<String> addToOrderInput;
		TreeSet<String> expectedTree = new TreeSet<String>();
		expectedTree.add("A");
		expectedTree.add("B");
		addToOrderInput = classUnderTest.orderTreeSet("A B B");
		assertTrue(addToOrderInput.equals(expectedTree)); 
	}
	
	@Test
	public void testFourInputLineIntoTreeSet_OneSame_ReturnSorted() {
		TreeSet<String> addToOrderInput;
		TreeSet<String> expectedTree = new TreeSet<String>();
		expectedTree.add("A");
		expectedTree.add("B");
		addToOrderInput = classUnderTest.orderTreeSet("A B B B");
		assertTrue(addToOrderInput.equals(expectedTree)); 
	}
	
	@Test
	public void testDescendingOrderPriorityQueue() {
		Double[] input = {2.2, 14.8, 3.3, 8.8, 1.1, 6.6};
		PriorityQueue<Double> returnPq = new PriorityQueue<Double>();
		returnPq = classUnderTest.descDoublesPriorityQueue(input);
		System.out.println(returnPq);
		assertTrue(returnPq.poll() == 14.8);
		assertTrue(returnPq.poll() == 8.8);
		assertTrue(returnPq.poll() == 6.6);
		assertTrue(returnPq.poll() == 3.3);
		assertTrue(returnPq.poll() == 2.2);
		assertTrue(returnPq.poll() == 1.1);
	}
		
}
















