
public class BalancedParens {

	public static void main(String[] args) {
		System.out.println(isBalanced(foo));

	}
	
	static boolean isBalanced(String myString) {
		while(myString.length() > 0) {
			int position = myString.indexOf("()");
			if(position == -1 )
				return false;
			String beforeMatch  = myString.substring(0, position);
			String afterMatch = myString.substring(position + 2, myString.length());
			myString = beforeMatch + afterMatch;
		}
		
		
		if(myString.length() == 0)
			return true;
		return false;

	}
	
	
	
	
	static String foo = "(()())";
	

			

}
