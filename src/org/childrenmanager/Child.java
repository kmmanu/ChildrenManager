package org.childrenmanager;

import java.util.Comparator;

public class Child {
	private String name;
	private int age;
	private int height;

	public Child() {
	}

	public Child(final String name, final int age, final int height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(final int age) {
		this.age = age;
	}

	public int getHeight() {
		return this.height;
	}

	public void setHeight(final int height) {
		this.height = height;
	}

	/**
	 * Comparator which can use for descending order sorting based on age.
	 * 
	 * @author Manu
	 * 
	 */
	public static class AgeComparator implements Comparator<Child> {

		@Override
		public int compare(final Child c1, final Child c2) {
			if (c1.age == c2.age) {
				return 0;
			} else if (c1.age > c2.age) {
				return -1;
			} else {
				return 1;
			}

		}

	}

	/**
	 * Comparator which can use for descending order sorting based on height.
	 * 
	 * @author Manu
	 * 
	 */
	public static class HeightComparator implements Comparator<Child> {

		@Override
		public int compare(final Child c1, final Child c2) {
			if (c1.height == c2.height) {
				return 0;
			} else if (c1.height > c2.height) {
				return -1;
			} else {
				return 1;
			}

		}

	}

	@Override
	public String toString() {
		return this.name;
	}

}
