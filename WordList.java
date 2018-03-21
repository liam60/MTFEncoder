/**
*<h1>Holds a list of strings</h1>
*This wordlist holds a Node and a count, the node is the head of the list, which
*points to another node, and so on.  Making up the list.
*The list allows for adding another item, getting the index of an item
*moving a given item to the front of the list, getting the item at a given index
*and finally we are able to check if a given item is in the list.
*
*The list class also has a inner class, Node.
*
*<b>Note:</b> I have not attempted the A+ solution, just the A grade solution.
*
*
*@author Liam Barclay
*ID number: 1268723
*
**/


public class WordList
{
	//Each wordlist holds a node which is the head, and a integer, representing the current count.
	int count;
	Node head;
	
	/**
	*Constructor for the Wordlist, sets the count to 0 and leaves the head as null.
	*/
	public WordList()
	{
		count = 0;
	}
	

	/**
	*This method adds a Node containing a string to the front of the list,
	*
	*@param data which holds a word in string format
	*@return nothing
	**/
	public void add(String data)
	{
		//if adding the first item to the list, set item to head
		if(head == null)
		{
			head = new Node(data);
		}
		//Otherwise create a nod that points to head, then set the new node to the head.
		else
		{
			Node temp = new Node(data, head);
			head = temp;
		}
		//Increment by one the count of the list.
		count++;
	}





	/**
	*This method gets the index of any node given the string
	*data (a word) that the node contains.
	*
	*@param data which holds a word in string format that we want to find the index of.
	*@return i, an int that contains the index of the given string.
	**/
	public int getIndex(String data)
	{
		//Set current to head, and declare i.
		Node curr = head;
		int i;

		//repeat for each item in the list, or until the item is found
		for(i = 1; i < count; i++)
		{
			//If this is the node we want, return the current count (index of node)
			if(curr.getData().equals(data))
			{
				return i;
			}
			//Otherwise move to next node.
			else
			{
				curr = curr.getNext();
			}

		}
		//Return i, in the case it is the last item in the list.
		return i;
	}

	




	/**
	*This method moves the node that contains the word specified
	*to the front of the list
	*
	*@param data which holds a word, the node that contains this word is what
	*will get moved to the front of the list.
	*
	*@return nothing
	**/
	public void MoveToFront(String data)
	{	
		//Set the current node to head.
		Node curr = head;
		

		/**if there is only one item in the list,
		* then it mean the item is already at the front of the list
		* so we can return immediatly without doing anything.
		*/ 
		if(curr.getNext() == null)
			return;

		/**if the head of the list contains the item we want to move
		* to the front, then it means it is already at the front
		* so we can return immediatly without doing anything.
		*/		
		if(head.getData().equals(data))
			return;	

		//For each item in the list
		for(int i = 0; i < count; i++)
		{
			/**if the current node points to the node that
			* contains the word we want. */
			if((curr.getNext()).getData().equals(data))
			{	
				// set a temporary node to the node that contains the,
				// which is the node we want to move to the front.
				Node temp = curr.getNext();

				//set current node to point to the node after the node we want
				//This isolates the node that we want to move to front
				//This node is now removed from the list.
				curr.setNext((curr.getNext()).getNext());

				//Add the temp node back on to the front of the list
				// by setting the temp not to point to the head
				temp.setNext(head);

				//Set the head to the temp node
				head = temp;

				//Return as we have now moved the node to the front.
				return;
			}
			//otherwise move to the next node.
			curr = curr.getNext();
		}	
	}	
	





	/**
	*This method checks to see if the list contains a node with the given word
	*Returns true if the item is in the list, otherwise returns false.
	*
	*@param data which holds a word we want to find in the list
	*@return bool value whether the item is in the list or not.
	**/
	public boolean hasElement(String data)
	{	
		//Declares variables needed.
		Node curr = head;
		int i;

		//Repeat for each item in the list
        	for(i = 0; i < count; i++)
    		{
			//Return true if the current node contains the specified string
			if(curr.getData().equals(data))
			{
			    return true;
			}
			//Otherwise move to next node.
			curr = curr.getNext();
		}
		//If not found, return false.
		return false;
	}
	




	/**
	*This method gets a word from the list that is held at the specified
	*index position in the list
	*
	*@param int index that holds the index of the word we want.
	*@return String word that is the word at the given index position.
	**/
	public String getWord(int index)
	{
		Node curr = head;
		int i;

		//Repeats until we reach the given position index.
		for(i = 1; i < index; i++)
		{
			//If we reach the end of the list, return null.
			if(curr.getNext() == null) return null;
			//Move to the next node in the list.
			curr = curr.getNext();

		}
		//Return the data held at the current node.
		return curr.getData();
	}
	




	/**
	*<h1>A String Node</h1>
	*
	*This class is an inner class of the wordlist,
	*It specifies what objects we want each node to contain
	*as well as what data can be retrieved or set for each node
	*In this case, we can get or set both the node each node points to,
	*as well as the word each node contains.
	*
	*@author Liam Barclay
	*ID number: 1268723
	*
	**/
	private class Node
	{
		//Each node object contains a pointer to another node,
		// as well as a piece of data, in this case, a string.
		private Node next;
		private String data;
		
		
		
		//Constructor for the Node when next is null
		//Useful if we wanted to add a node to the end of the list
		//or to create the first node in the list.
		public Node(String s)
		{
			data = s;
			next = null;
		}
		
		//A second constructor for the node if we want to specify 
		//which node we want it to point to.
		//Useful when creating a new node to point to the head
		public Node(String s, Node n)
		{
			data = s;
			next = n;
		}
		
		

		//Getters and setters
		
		/** @return String data, the data that the node contains.*/
		public String getData()
			{ return data; }
		
		/** 
		*@param _data what we want to set the data of the node to.
		*@return nothing*/
		public void setData(String _data)
			{ data = _data; }
		
		/** @return Node next, the node object that the node points to*/
		public Node getNext()
			{ return next; }
		
		/** 
		*@param _next what we want the node to point to next
		*@return nothing*/
		public void setNext(Node _next)
			{ next = _next; }
		
		
		
		
	}
}
