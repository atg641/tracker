package magicSquare;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MagicSquare {
	List<String> rowsAsText;
	List<List<Integer>> matrix;
	
	public MagicSquare(String filename) {
		rowsAsText = new ArrayList<String>();
		matrix = new ArrayList<List<Integer>>();
		try {
			readFileIntoList(filename);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean isValidMagicSquare() {
		int sum = 0;
		int magicSquareSum = -1;
		for(int i=0 ; i < matrix.size() ; i++) {
			sum = 0;
			for(int j=0 ; j < matrix.size() ; j++) {
				sum = sum + matrix.get(i).get(j);
			}
		if (magicSquareSum == -1)
			magicSquareSum = sum;
		else
			if (sum != magicSquareSum)
				return false;
		}
		for(int j=0 ; j < matrix.size() ; j++) {
			sum = 0;
			for(int i=0 ; i < matrix.size() ; i++) {
				sum = sum + matrix.get(i).get(j);
			}
				if (sum != magicSquareSum)
				return false;	
		}
		sum=0;
		for(int j = 0; j < matrix.size() ; j++) {
			sum = sum + matrix.get(j).get(j);
		}
		if (sum != magicSquareSum)
			return false;	
		
		sum=0;
		for(int j = 0; j < matrix.size() ; j++) {
			int i = matrix.size()-1-j;
			sum = sum + matrix.get(j).get(i);
		}
		if (sum != magicSquareSum)
			return false;	
		
		
	
	
	
//		ArrayList <Integer> listOfSums = new ArrayList<Integer>();
//		for(String row : rowsAsText) {
//			sum = 0;
//			String[]  individualInt = row.split("\t");
//			for(String numS : individualInt) {
//				Integer num = Integer.decode(numS);
//				sum = sum + num;
//			}
//			listOfSums.add(sum);
//		}
//		for(Integer sm : listOfSums) {
//			if(!sm.equals(sum)) {
//			return false;
//			}
//		}
		
		
		return true; //stub
		
				
	}


	private void readFileIntoList(String filename) throws FileNotFoundException {

		Scanner scan = null;

		File myFile = new File(filename);
		scan = new Scanner(myFile);

		while (scan.hasNextLine()) {
			rowsAsText.add(scan.nextLine());

		}
		for(String row : rowsAsText) {
			String[]  individualInt = row.split("\t");
			List<Integer> rowlist = new ArrayList<Integer>(); 
			for(String numS : individualInt) {
				Integer num = Integer.decode(numS);
				rowlist.add(num);
			}
			matrix.add(rowlist);
		}
		scan.close();
		
	}
	
	
	public static void main(String[] args) throws FileNotFoundException {

		MagicSquare magicSquare = new MagicSquare("data/magicSquare/luna.txt");
		boolean b = magicSquare.isValidMagicSquare();
		magicSquare = new MagicSquare("data/magicSquare/mercury.txt");
		b = magicSquare.isValidMagicSquare();
		
		
		
	}
}


