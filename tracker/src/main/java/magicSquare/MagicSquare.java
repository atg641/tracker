package magicSquare;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {
	List<String> rowsAsText;
	
	
	public MagicSquare(String filename) {
		rowsAsText = new ArrayList<String>();
		try {
			readFileIntoList(filename);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isValidMagicSquare() {
		return false; //stub
	}


	private void readFileIntoList(String filename) throws FileNotFoundException {

		Scanner scan = null;

		File myFile = new File("data/magicSquare/luna.txt");
		scan = new Scanner(myFile);

		while (scan.hasNextLine()) {
			rowsAsText.add(scan.nextLine());

		}
		scan.close();
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {

		MagicSquare magicSquare = new MagicSquare("data/magicSquare/luna.txt");
		boolean b = magicSquare.isValidMagicSquare();
		
		
		
	}
}


