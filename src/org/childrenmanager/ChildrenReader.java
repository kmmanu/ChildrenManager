package org.childrenmanager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ChildrenReader {
	public static List<Child> loadChildrenFromFile(final String fileName)
			throws IOException {
		final BufferedReader br = new BufferedReader(new FileReader(fileName));

		final List<Child> children = new ArrayList<>();
		String line = null;
		while ((line = br.readLine()) != null) {
			final String[] childRow = line.split(",");
			if (childRow.length != 3) {
				System.out.println("Invalid row");
				continue;
			}
			final Child child = new Child();
			child.setName(childRow[0].trim());
			try {
				final int age = Integer.parseInt(childRow[1].trim());
				child.setAge(age);
				final int height = Integer.parseInt(childRow[2].trim());
				child.setHeight(height);
			} catch (final NumberFormatException nfe) {
				System.out.println(nfe.getLocalizedMessage());
				nfe.printStackTrace();
				continue;
			}
			children.add(child);
		}
		return children;
	}
}
