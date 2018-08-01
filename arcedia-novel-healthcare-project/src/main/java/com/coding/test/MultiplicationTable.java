package com.coding.test;

public class MultiplicationTable {
	static final int NMAX = 10;

	public static void main(String[] args) {
		int row, column;
		for (row = 1; row <= NMAX; row++) {
			System.out.println("Table " + row);
			for (column = 1; column <= NMAX; column++)
				System.out.print(row * column + " ");
			System.out.println();
		}
	}
}