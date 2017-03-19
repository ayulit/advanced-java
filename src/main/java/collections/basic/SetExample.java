package collections.basic;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {

	private static NavigableSet<Integer> set; // since Java 6!
	
	public static void main(String[] args) {
		
		set = new TreeSet<>();
		
		for (int i = 1; i <= 10; i++) {
			set.add(i);
		}
		
		System.out.println(set);
		
		Integer testElem = 5;
		
		// without NavigableSet
		System.out.println("Next element is " + getNextElem(testElem));
		System.out.println("Prev elements are " + getPrevElems(testElem));
		
		// with NavigableSet (since Java 6)
		System.out.println("Next element is " + set.higher(testElem));
		System.out.println("Prev elements are " + set.headSet(testElem));
	}
	
	public static Integer getNextElem(Integer elem)  {
		Iterator<Integer> it = set.iterator();
		
		while (it.hasNext()) {
			Integer i = it.next();
			if (i.equals(elem) && it.hasNext()) {
				return it.next();
			}
		}
		return null;
	}
	
	public static Set<Integer> getPrevElems(Integer elem) {
		Iterator<Integer> it = set.iterator();
		Set<Integer> s = new HashSet<>();
		
		while (it.hasNext()) {
			Integer i = it.next();
			if (i.equals(elem)) {
				return s;
			}
			s.add(i);
		}
		return null;
	}

}
