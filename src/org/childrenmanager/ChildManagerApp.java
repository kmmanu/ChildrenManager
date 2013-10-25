package org.childrenmanager;

public class ChildManagerApp {
	public static void main(final String[] args) {
		final ChildrenManager childrenManager = new ChildrenManager(
				"Children.txt");
		System.out
				.println("List of children sorted based on Age in Desc order");
		System.out.println(childrenManager.getChildrenSortedDescBasedOnAge());

		System.out
				.println("\nList of children sorted based on Height in Desc order");
		System.out
				.println(childrenManager.getChildrenSortedDescBasedOnHeight());
	}
}
