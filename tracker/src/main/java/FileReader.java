
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
	public static void main(String[] args) throws FileNotFoundException {

		ArrayList<String> foo = new ArrayList<String>(100);
		foo.add("abc");
		foo.add(0, "def");
		System.out.println(foo.get(0));

		ArrayList<String> arr = new ArrayList<String>();
		Scanner scan = null;

		File myFile = new File(args[0]);
		scan = new Scanner(myFile);

		while (scan.hasNextLine()) {
			arr.add(scan.nextLine());

		}
		scan.close();
		 for(String st : arr){
		 System.out.println(arr.subList(0, 10));
		 System.out.println(arr.size());
		 }

		int largestString = arr.get(0).length();
		int index = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).length() > largestString) {
				largestString = arr.get(i).length();
				index = i;
			}
		}
	}
}

// next steps:
// print the first 10 lines of the file.
// print the number of lines in the file
// print the longesb line of the file:
// use for(String st : arr){...}
// for (int i = 0; i < arr.size() ; i++){ String st = arr.get(i); ....}
