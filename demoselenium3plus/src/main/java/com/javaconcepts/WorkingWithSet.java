package com.javaconcepts;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class WorkingWithSet {
	
	public static void main(String[] args) {
		
		Set<Object> s=new HashSet<Object>();
		
		s.add("A");
		s.add("B");
		s.add("C");
		s.add("A");
		s.add("C");
		
		System.out.println(s.size());
		
		Iterator<Object> it=s.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		
		
		
		
	}

}
