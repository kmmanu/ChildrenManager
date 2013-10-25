package org.childrenmanager;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ChildrenManagerTest {
	ChildrenManager childrenManager = new ChildrenManager("C:/Children.txt");
	List<Child> children = new ArrayList<>();

	@Before
	public void init() {
		this.children.add(new Child("Ram", 6, 135));
		this.children.add(new Child("Rajesh", 6, 133));
		this.children.add(new Child("Biju", 5, 134));
		this.children.add(new Child("Siju", 5, 136));
		this.children.add(new Child("Tomo", 7, 124));
		this.children.add(new Child("Dick", 7, 144));
		this.children.add(new Child("Jerry", 2, 114));
		this.children.add(new Child("Terry", 2, 104));
		this.children.add(new Child("Harry", 2, 105));
		this.childrenManager.setChildren(this.children);
	}

	@Test
	public void testChildrenSortedDescBasedOnAge() {
		final List<Child> childrenSortedOnAge = this.childrenManager
				.getChildrenSortedDescBasedOnAge();
		// It can be modified, if you want.
		assertEquals(7, childrenSortedOnAge.get(0).getAge());
	}

	@Test
	public void testChildrenSortedDescBasedOnHeight() {
		final List<Child> childrenSortedOnHeight = this.childrenManager
				.getChildrenSortedDescBasedOnHeight();
		// It can be modified, if you want.
		assertEquals(144, childrenSortedOnHeight.get(0).getHeight());
	}

	@Test
	public void testChildWithMaximHeightInAnAgeGroup() {
		final Child childWithMaxHeight = this.childrenManager
				.getChildWithMaximHeightInAnAgeGroup(2);
		assertEquals("Jerry", childWithMaxHeight.getName());
	}
}
