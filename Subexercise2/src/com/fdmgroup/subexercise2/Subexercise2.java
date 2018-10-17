package com.fdmgroup.subexercise2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Subexercise2 {

	int counter = 0;
	public HashMap<Character, Integer> countLetters(String str) {
		HashMap<Character, Integer> hmap = new HashMap<Character, Integer>();
		
		for (int i = 0; i < str.length(); i++) {
			
			if (hmap.containsKey(str.charAt(i))) {
				hmap.put(str.charAt(i), hmap.get(str.charAt(i)) + 1 );
			} else {
				hmap.put(str.charAt(i), 1);
			}
		}
		System.out.println(hmap);
		return hmap;
		
	}
	
	public int countDupedWords(String str) {
		HashMap<String, Integer> hmap = new HashMap<String, Integer>();
		ArrayList<String> words = new ArrayList<String>();
		counter = 0;
		for(String word : str.split(" ")) {
//			System.out.println(word.replaceAll("[^a-zA-Z]", "").toLowerCase());
		    words.add(word.replaceAll("[^a-zA-Z]", "").toLowerCase());
		}
		
		for (int i = 0; i < words.size(); i++) {	
			if (hmap.containsKey(words.get(i))) {
				hmap.put(words.get(i), hmap.get(words.get(i)) + 1 );
			} else {
				hmap.put(words.get(i), 1);
			}
		}
		
		hmap.forEach((k,v) -> {
			if (hmap.get(k) >= 2) {
				counter += 1;
			}
		}
				);
		return counter;
		
	}
	
	public LinkedList<String> reverseList(LinkedList<String> inOrder){
		LinkedList<String> reversed = new LinkedList<String>();
		for (int i = inOrder.size() - 1; i >= 0; i--) {
			reversed.add(inOrder.get(i));
		}
		return reversed;
	}
	
	public Set<String> removeDupedNames(String... names) {
		HashSet<String> noDupeNames = new HashSet<String>();
		for (int i = 0; i<names.length; i++) {
			noDupeNames.add(names[i]);
		}
		return noDupeNames;
	}
	
	public TreeSet<String> orderTreeSet(String str) {
		TreeSet<String> orderTreeInput = new TreeSet<String>();
		String[] words = str.split(" ");
		for (int i = 0; i<words.length; i++){
			orderTreeInput.add(words[i]);
		}
		System.out.println(orderTreeInput);
		return orderTreeInput;
	}
	
	public PriorityQueue<Double> descDoublesPriorityQueue(Double[] input) {
		PriorityQueue<Double> descPq = new PriorityQueue<Double>(new ComparatorPQ()); 
		for (double d : input) {
			descPq.add(d);
		}
		System.out.println(descPq);
		return descPq;
	}
	
	public class ComparatorPQ implements Comparator<Double> {

		@Override
		public int compare(Double o1, Double o2) {
			if (o1 < o2) {
				return 1;
			} else if (o1 > o2) {
				return -1;
			} 
			return 0;

		}
		
	}
}
