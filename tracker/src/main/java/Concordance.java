
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;


public class Concordance {


	public static void main(String[] args){
		List<String> words;
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
				int prev = concord.get(wd);
				concord.put(wd, prev+1);
			} else {
				concord.put(wd, 1);
			}
			System.out.println(wd + ":"+  concord.get(wd));
		}

	}
}
