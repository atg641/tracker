
public class BalancedParens {

	public static void main(String[] args) {
		System.out.println(isBalanced(foo));
		System.out.println(reverse(test1));
		System.out.println(numberOf('a', test1));
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
	
	static int max(int[] anArray) {
		for(int elem : anArray) {
			
		}
		//an equivalent loop
		for(int i=0; i < anArray.length; i++) {
			int elem = anArray[i];
			
		}
		//max returns the largest number in the array e.g. max(mayArray) = 93
		return 0;
	}
	
	static float average(int[] anArray) {
		return 0;
	}
	
	static int[] myArray = { 2, 45, 87, 93 ,46};

	static String test1 = "abcbad";

	static String foo = "(()())";

}
