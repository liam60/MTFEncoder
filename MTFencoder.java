import java.io.FileReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

/**
*<h1>Encodes A Text File</h1>
*The MTFencoder takes a text file as an argument
*then encodes it by reading each line, then each word,
*if the word is new then it will print "0 + word".
*If the word has been seen before, it will simply 
*print the index of the word as a integer number.
*The words are held in a list of most recently used order.
*
*<b>Note:</b> I have not attempted the A+ solution, just the A solution.
*
*
*@author Liam Barclay
*ID number: 1268723
*
**/
public class MTFencoder
{

	/**
	*This method reads the text file, and encodes it appropriately while
	*printing the output using the given algorithm.
	*
	*@param args This is the text file to encode
	*@return nothing
	**/
	public static void main(String [] args)
		{
		//Declares a new wordlist and string to use.
	    	WordList list = new WordList();
		String str = "";
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
			//gets the first line of the file to encode and declares dilems
	      		String s=br.readLine();
	 		String delims = ".,;:!\" \t\n";
		
			//While there is still a line to read
	      		while(s!=null)
			{
				//set the string tokenizer to read the line s and remove any dilems
				StringTokenizer st = new StringTokenizer(s,delims);
				//While there is still a word to read.
				while(st.hasMoreTokens())
				{	
					//gets the next word to read and puts it into str
					str = st.nextToken();
					//if str is already contained within the list
					if(list.hasElement(str))
					{
						//prints index of word and moves word to
						//front of list.
						int i = list.getIndex(str);
						System.out.println(Integer.toString(i));
						list.MoveToFront(str);
					}
					else
					{
						//if not in the list, add the word to the list
						//and print a 0 with the word in the output.
						list.add(str);
						System.out.println("0 " + str);			
					}

				}
				//read the next line of the file.
				s=br.readLine();
	      		}
	    	}
		//catch to throw an error.
		catch(Exception e)
		{
			System.out.println("Program Error");
		}
	}
}
