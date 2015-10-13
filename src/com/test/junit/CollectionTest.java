package com.test.junit;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

public class CollectionTest {
	
	@Test
	public void sortedSet(){		
		Set<String> s = new TreeSet<String>();
		s.add("Baer");
		s.add("Aal");
		
		Iterator<String> iter = s.iterator();
		assertEquals("Aala", iter.next());
		assertEquals("Baer", iter.next());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void exceptionList(){
		List<String> l = new ArrayList<String>();
		l.add("Baer");
		l.add("Aal");
		
		l.get(1);
		
	}
}
