package org.goldberg.tracker;

class ArrayDemo {
	public static void main(String[] args) {
		// declares an array of integers
		int[] anArray;

		// allocates memory for 10 integers
		anArray = new int[10];

		for (int i = 0; i < 10; i = i + 1) {
			anArray[i] = (i + 1) * 100;

		}

		// exercise: write a loop that sums all of the elements of the array

		int sum = 0;
		// some loop here for you to fill in
		for (int a : anArray)
			sum += a;
		System.out.println("sum = " + sum); // 5600? - 5500 MR

		// exercise: write a loop finds the largest/smallest value of the elements of
		// the array
		int smallest = anArray[0];
		int largest = anArray[0];

		for (int i = 0; i < anArray.length; i++) {
			if (anArray[i] < smallest) {
				smallest = anArray[i];
			}
		
			if (anArray[i] > largest) {
				largest = anArray[i];
			}

		}
		System.out.println("Smallest = " + smallest);
		System.out.println("Largest = " + largest);

	}
}
