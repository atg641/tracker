package concordance;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;


public class Concordance {


	public static void main(String[] args){

		Map<String,Integer> concord;

		String text = null;
         try {
			text = new String(Files.readAllBytes(Paths.get(args[0])));
			//System.out.println(text);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		String nonWord = "[^a-zA-Z]+";
 		String[] theWords = text.split(nonWord);
// 		for(String s: theWords)
// 			System.out.println(s);
         

        concord = new HashMap<String, Integer>();
     
		for (String wd : theWords) {
				wd = wd.toLowerCase();
				if(wd.length() == 0)
					continue;
			if (concord.containsKey(wd)) {
				int prev =  concord.get(wd);
				concord.put(wd, prev+1);
			} else {
				concord.put(wd, 1);
			}

		}
		
		for(String wd : concord.keySet()) {
			System.out.println(wd + " appears " + concord.get(wd));
		}
		//what is the most popular word?
		//what is the average frequency of words appearing in the text?
		//the above require using a for loop to examine all elements of the map
		//how many distinct words appeared? (this is the size of the keySet)
		

	}
}
