package org.childrenmanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ChildrenManager {

	private final Child.AgeComparator ageComparator = new Child.AgeComparator();
	private final Child.HeightComparator heightComparator = new Child.HeightComparator();

	private List<Child> children = new ArrayList<Child>();
	private String fileName;

	public ChildrenManager(final String fileName) {
		this.fileName = fileName;
		loadChildren();
	}

	public ChildrenManager() {

	}

	public void loadChildren() {
		// Read child objects from file..
		try {
			this.children = ChildrenReader.loadChildrenFromFile(this.fileName);
		} catch (final IOException e) {
			System.out.println("Unable to read the file : " + this.fileName);
			e.printStackTrace();
		}
	}

	/** Just for test cases. */
	void setChildren(final List<Child> children) {
		this.children = children;
	}

	/** Sort children based on the Age in desc order. */
	public List<Child> getChildrenSortedDescBasedOnAge() {
		final List<Child> childrenCopy = new ArrayList<>(this.children);
		Collections.sort(childrenCopy, this.ageComparator);
		return childrenCopy;
	}

	/** Sort children based on the Height in desc order */
	public List<Child> getChildrenSortedDescBasedOnHeight() {
		final List<Child> childrenCopy = new ArrayList<Child>(this.children);
		Collections.sort(childrenCopy, this.heightComparator);
		return childrenCopy;
	}

	/**
	 * get child with max height in a particular age group.
	 * 
	 * @param age
	 */
	public Child getChildWithMaximHeightInAnAgeGroup(final int age) {
		final Map<Integer, List<Child>> ageToChildrenMap = getAgeToChildrenMap();

		// Collections.sort(ageToChildrenMap.get(age), this.ageComparator);
		// return ageToChildrenMap.get(age).get(0);

		// I could have used below line instead of above commented lines.
		return Collections.max(ageToChildrenMap.get(age), this.ageComparator);
	}

	/**
	 * get the list of Children with Maximum height in each age group.
	 * 
	 * @return
	 */
	public Collection<Child> getListOfChildrenWithMaxHeightInEachAgeGroup() {
		final Map<Integer, List<Child>> ageToChildrenMap = getAgeToChildrenMap();

		final Map<Integer, Child> ageToChildWithMaxHeightMap = getAgeToChildWithMaxHeightMap(ageToChildrenMap);

		return ageToChildWithMaxHeightMap.values();

	}

	private Map<Integer, Child> getAgeToChildWithMaxHeightMap(
			final Map<Integer, List<Child>> ageToChildrenMap) {
		final Map<Integer, Child> ageToChildWithMaxHeightMap = new HashMap<Integer, Child>();
		final Set<Integer> ageList = ageToChildrenMap.keySet();
		for (final Integer integer : ageList) {
			ageToChildWithMaxHeightMap.put(integer, Collections.max(
					ageToChildrenMap.get(integer), this.ageComparator));
		}
		return ageToChildWithMaxHeightMap;
	}

	/**
	 * This method will group children based on age and store in a map. Map key
	 * is age and value is list of Child having the particular age.
	 * 
	 * 
	 * @return
	 */
	private Map<Integer, List<Child>> getAgeToChildrenMap() {
		final Map<Integer, List<Child>> ageToChildrenMap = new HashMap<Integer, List<Child>>();
		for (final Child child : this.children) {
			List<Child> childrenWithSameAge = ageToChildrenMap.get(child
					.getAge());
			if (childrenWithSameAge == null) {
				childrenWithSameAge = new ArrayList<Child>();
				childrenWithSameAge.add(child);
				ageToChildrenMap.put(child.getAge(), childrenWithSameAge);
			} else {
				childrenWithSameAge.add(child);
			}
		}
		return ageToChildrenMap;
	}

}
