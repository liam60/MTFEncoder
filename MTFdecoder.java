import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;


/**
*<h1>Encodes A Text File</h1>
*The MTFdecoder takes a text file as an argument
*then decodes it by reading each line, if the line starts
*with a zero, it will print the next token and add it to the list,
*because zero indicate a new word.
*
*If the line start with a non zero integer, this relates to the index, 
*therefore the program will find the word held at this index, print
*it to the screen, then move this word to the front of the list.
*
*<b>Note:</b> This decoder has been written specifically to decode text files the have been
* encoded with the MTFencoder.java
*
*
*@author Liam Barclay
*ID number: 1268723
*
**/
public class MTFdecoder
{


	/**
	*This method reads the text file, and decodes it appropriately while
	*printing the output.
	*
	*@param args This is the text file to encode
	*@return nothing
	**/
	public static void main(String [] args)
	{
		//Declares a new wordlist, two strings, and an int to use.
	    	WordList list = new WordList();
		String str = "";
		String word = "";
		int index;

		//If the encoder has not been given exactly one text file.
	    	if(args.length != 1)
		{
			//Output an error message and return.
	    		System.err.println("Usage:  java TestRead test.txt" + "");
		      	return;
	   	}

	    	try
		{
			//Declares a new buffered reader with the given text file
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			//gets the first line of the file to decode and declares dilems
	      		String s=br.readLine();
	 		String delims = ".,;:!\" \t\n";
		
			//While there is still a line to read
	      		while(s!=null)
			{
				//set the string tokenizer to read the line s and remove any dilems
				StringTokenizer st = new StringTokenizer(s,delims);
				//gets the next word to read and puts it into str
				str = st.nextToken();
				//gets the integer that will be the first item in the line.
				index = Integer.parseInt(str);
				
				//If that integer is 0
				if(index == 0)
				{
					//set the str to the new word
					str = st.nextToken();
					//add this word to the list.
					list.add(str);
					//print the word
					System.out.println(str);
					
				}
				//else, there must be a non-zero int at the start
				else
				{
					//get the word at the specified index
					word = list.getWord(index);
					//prints this word
					System.out.println(word);
					//move this word to the front of the list.
					list.MoveToFront(word);	
				}
				//read the next line.				
				s=br.readLine();
	      		}
	    	}
		//catch to throw an error, this will happen if the text file supplied is not
		//encoded correctly with the appropriate encryption given in MTFencoder.
		catch(Exception e)
		{
			System.out.println("Error, this text file is not encoded correctly for this decoder.");
		}
	}
}
