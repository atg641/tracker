
public class BalancedParens {

	public static void main(String[] args) {
		// System.out.println(isBalanced(foo));
		// System.out.println(reverse(test1));
		// System.out.println(numberOf('a', test1));
		// System.out.println(max(myArray));
		// System.out.println(average(myArray));
		// System.out.println(numberOfOcurrences(smallString, bigString));
		// System.out.println(numberOfOcurrences2(smallString, bigString));
		System.out.println(isTheSame(smallString, bigString));
		System.out.println(isTheSame(bigString, smallString));
		System.out.println(countChar(consecutive, '*'));
		System.out.println(countChar(consecutive2, '*'));


	}

	static boolean isBalanced(String myString) {
		// while(myString.length() > 0) {
		// int position = myString.indexOf("()");
		// if(position == -1 )
		// return false;
		// String beforeMatch = myString.substring(0, position);
		// String afterMatch = myString.substring(position + 2, myString.length());
		// myString = beforeMatch + afterMatch;
		// }
		//
		//
		// if(myString.length() == 0)
		// return true;
		// return false;

		int count = 0;
		for (int i = 0; i < myString.length(); i++) {
			char ch = myString.charAt(i);
			if (ch == '(') {
				count++;
				System.out.println(ch);
			} else
				count--;
			if (count == -1)
				return false;
		}
		// if (count == 0)
		// return true;
		// return false;
		return count == 0;

	}

	static int numberOf(char c1, String st) {
		// // Fill in code return int which is the number of times char ch appears in st
		int count = 0;
		for (int i = 0; i < st.length(); i++) {
			char ch = st.charAt(i);
			if (ch == c1) {
				count++;
				return count;
			}
		}
		return count;

	}

	// Create a method which takes one string and returns true (same signature as is
	// balanced) if the string is the same forward and backwards
	// Take string and loop from r to l and then reverse it for i= length of string
	// -1 i-- i < 0

	static String reverse(String myString) {
		String reverseString = "";
		for (int i = myString.length() - 1; i >= 0; i--) {
			reverseString += myString.charAt(i);
		}
		if (myString.equals(reverseString)) {
			System.out.println("match");
		} else {
			System.out.println("no match");
		}

		return reverseString;

	}

	static int numberOfOcurrences(String searchString, String targetString) {
		int placment = 0;
		int count = 0;

		while (placment != -1) {
			placment = targetString.indexOf(searchString, placment);
			if (placment != -1) {
				count++;
				placment += searchString.length();
			}
		}
		System.out.println(count);

		return count;
	}

	// Outside loop will be the matching aspect of the loop
	// break statment

	// search string = "ab" and targetString = "abbabab" return 3
	// hint use the indexOf method of the String class
	// learn about the "while" loop
	// BalancedParens.int j = targetString.indexOf(str, fromIndex)

	static boolean isTheSame(String s1, String s2) {
		boolean match = true;
		if (s1.length() == s2.length()) {
			for (int i = 0; i < s1.length(); i++) {
				char ch1 = s1.charAt(i);
				char ch2 = s2.charAt(i);
				if (ch1 != ch2) {
					match = false;
					break;
				}
			}
			return match;
		}
		else {
			return false;
		}
	}

	static int numberOfOcurrences2(String searchString, String targetString) {
		int count = 0;
		String compare = null;
		for (int i = 0; i < targetString.length()-searchString.length(); i++) {
			compare = targetString.substring(i, i+searchString.length());
			if(isTheSame(compare, searchString)) {
				count++;
			}
			
		}
		return count;
	}

	static int[] myArray = { 2, 45, 87, 93, 46 };

	static int max(int[] anArray) {
		int currentMax = anArray[0];
		for (int elem1 : anArray) {
			if (elem1 > currentMax) {
				currentMax = elem1;
			}
		}
		// an equivalent loop

		for (int i = 0; i < anArray.length; i++) {
			int elem = anArray[i];
			if (elem > currentMax) {
				currentMax = elem;
			}
			// max returns the largest number in the array e.g. max(mayArray) = 93
		}
		return currentMax;

	}

	static float average(int[] anArray) {

		float total = 0;
		for (int i = 0; i < anArray.length; i++) {
			total += anArray[i];
		}

		float average = total / anArray.length;
		return average;
	}
	
	public static int countChar(String search, char c) {
		    int count = 0;
		    boolean found = false;
		    for( int i = 0; i < search.length(); i++)
		    {
		      if( search.charAt(i) == c )
		      {
		        count++;
		        found = true;
		      }
		      else {
		        if(found) break;
		      }
		    }
		    return count;
	 }

	static String test1 = "abcbad";

	static String foo = "(()())";

	static String bigString = "abababab";
	static String smallString = "ab";
	static String consecutive = "a**b*";
	static String consecutive2 = "***m";

}
