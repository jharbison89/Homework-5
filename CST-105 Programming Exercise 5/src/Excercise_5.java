import java.io.*;

public class Excercise_5 {

	/* Created by James Harbison 
	 * This program reads an input from a .txt file and places that text into a 20 X 45 char
	 * array. it then creates a string from the array by pulling characters in column-major
	 * order and displays the new string 
	 */
	public static void main(String[] args) {
		
		// initializes the file name for the input 
		String fileName = "InputFile.txt";
		
		// initializes a string for the input taken from the file
		String fileInput= null;
		try {
			// initializes the file reader
			FileReader fileReader = new FileReader(fileName);
			
			// wraps the file reader in a buffered reader
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			// reads the text input from the file
			fileInput = bufferedReader.readLine();
		
			// closes the buffered reader
			bufferedReader.close();
			
			// initializes char array with size 20 X 45
			char[][] inputArray = new char[20][45];
			
			// initializes counter variables
			int i = 0;
			int j = 0;
			int charCounter = 0;
			
			
			// loops through the string to fill the array in row major order
			for(i = 0; i < 20; i++) {
				
				for(j = 0; j < 45; j++) {
					
					if(charCounter < fileInput.length()) {
						inputArray[i][j] = fileInput.charAt(charCounter);
						charCounter++;
					}
					else{
						inputArray[i][j] = '@';
					}
				}
			}
			
			// initializes a string for the extracted column major order
			String newString = "";
			
			// loops through the array in column major order to concatenate the new string 
			for(j = 0; j < 45; j++) {
				
				for(i = 0; i < 20; i++) {
					
					newString = newString + inputArray[i][j];
				}
			}
			
			// displays the new string in column major order
			System.out.println(newString);
		}
		catch(FileNotFoundException ex) {
			System.out.println("Unable to open file '" + fileName + "'");
		}
		catch(IOException ex) {
			System.out.println("Error reading file '" + fileName + "'");
		}
	}
}
