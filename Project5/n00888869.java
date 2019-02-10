import java.util.Scanner;
import java.util.Stack;


/*
Project 5
Author:Vedran Pehlivanovic
Date: 03-13-2015
This program creates a huffman tree to encode and decode a message from a file

*/

public class n00888869 {
	static String text1= "";
	
	public static void main(String[] args) throws Exception
	{
		java.io.File file = new java.io.File(args[0]);
		
		Scanner input = new Scanner(file);
		
		String text = input.nextLine();
		//method to put restrictions on what letters can be accepted.
		newText(text);
		
      //get the freq of characters
		int[] counts = characterFrequency(text1);
		//create my huffmantree
		Tree tree = huffmanTree(counts);
		//get the code for the characters
		String[] codes = getCode(tree.root);
		//encode the characters
		String encoded = encodeString(text1,codes);
		//deCode the characters
		String msg1 = deCode(encoded,tree);
		
		
		boolean control = true;
		while(control)
		{
		System.out.print("Please enter your choice (a , b , c , d or q (to quit) ");
		
		Scanner input1 = new Scanner(System.in);
		
		String userInput = input1.nextLine();
		
		if(userInput.equalsIgnoreCase("a"))
		{
			tree.displayTree();
		}
		else if(userInput.equalsIgnoreCase("b"))
		{
			for(int i = 0; i < codes.length; i++)
			{
			if(counts[i] !=0)	
			System.out.printf("%-15s%-15s\n",(char)i + "", codes[i]);
			}
		}
		else if(userInput.equalsIgnoreCase("c"))
		{
			printMsg(encoded);
			System.out.println();
		}
		else if(userInput.equalsIgnoreCase("d"))
		{
			System.out.println(msg1);
		}
		
		else if(userInput.equalsIgnoreCase("q"))
		{
			control = false;
		}
	}
						
}//end main
	
   // This deCodes the string by going thru the tree if it sees a 0 it goes to the left 
   //and if it sees a 1 it goes to right. If the left and right nodes are null it takes the char element.
	public static String deCode(String deCoded, Tree tree)
	{
		String msg = "";
		Tree.Node current = tree.root;
		
		for(int i = 0; i < deCoded.length(); i++)
		{
			
			if(deCoded.charAt(i) == '1')
			{
				current = current.right;
			}
			
			else if(deCoded.charAt(i) == '0')
			{
				current = current.left;
			}
			
		
			if(current.right == null && current.left == null)
			{
				
				msg += current.element;
				current = tree.root;
				
			}
			
		}
		return msg;
	}
	//This encodes the string
	public static String encodeString(String text, String[] codes)
	{
		String encoded = "";
		
		for(int i = 0; i < text.length(); i++)
		{
			
			encoded += codes[text.charAt(i)];
		}
		
		return encoded;
	}
	
   //formats the string by adding a space every 8 letters and a new line every 24 letters
	public static void printMsg(String text)
	{
		for(int i = 0; i < text.length(); i++)
		{
			if(i%24 == 0)
				{
					System.out.println();
				}
			else if(i%8 == 0)
			{
				System.out.print(" ");
			}
			
			System.out.print(text.charAt(i));
		}
	}
   //Creates the code table by going thru the tree
		public static String[] getCode(Tree.Node root)
		{
			if(root == null)
				return null;
			String[] codes = new String[256];
			assignCode(root, codes);
			return codes;
		}//end getCode
		
      //assigns the coding to the tree so if it goes left it gets 0 and if it goes right it gets a 1
		private static void assignCode(Tree.Node root, String[] codes)
		{
			if(root.left != null)
			{
				root.left.code = root.code + "0";
				assignCode(root.left, codes);
				
				root.right.code = root.code + "1";
				assignCode(root.right , codes);
			}
			else
			{
				codes[(int)root.element] = root.code;
			}
		}//end assignCode
      
		//creats the tree and sorts it by a heap
		public static Tree huffmanTree(int[] counts)
		{
			Heap<Tree> heap = new Heap<>();
			for(int i = 0; i < counts.length; i++)
			{
				if(counts[i] > 0)
					heap.add(new Tree(counts[i], (char)i));
			}	
				while(heap.getSize() > 1)
				{
					Tree t1 = heap.remove();
					Tree t2 = heap.remove();
					heap.add(new Tree(t1,t2));
					
				}//end while loop
				
				return heap.remove();
			
		}//end huffmanTree
		
      //figures out the frequency of the characters in the input
		public static int[] characterFrequency(String text)
		{
			
			int[] counts = new int[256];
			
			for(int i = 0; i <text.length(); i++)
			{
				counts[(int)text.charAt(i)]++;
			}
			
		
			return counts;
			
		}//end characterFrequency
		
      //Only allows A-G as inputs discards everything else
		public static void newText(String text)
		{
			char[] charArr = text.toCharArray();
			
			for(int i = 0; i < charArr.length; i++)
				if(charArr[i] == 'A')
				{
					text1 += 'A';
				}
				else if(charArr[i] == 'B')
				{
					text1 += 'B';
				}
				else if(charArr[i] == 'C')
				{
					text1 += 'C';
				}
				else if(charArr[i] == 'D')
				{
					text1  += 'D';
				}
				else if(charArr[i] == 'E')
				{
					text1 += 'E';
				}
				else if(charArr[i] == 'F')
				{
					text1 += 'F';
				}
				else if(charArr[i] == 'G')
				{
					text1 += 'G';
				}
			
		}
		
      //the class for the Tree
		public static class Tree implements Comparable<Tree>{
			Node root;
			
			public Tree(Tree t1, Tree t2)
			{
				root = new Node();
				root.left = t1.root;
				root.right = t2.root;
				root.weight = t1.root.weight + t2.root.weight;
			}//end constructor
			
			public Tree(int weight, char element)
			{
				root = new Node(weight,element);
				
			}
			
			@Override
			public int compareTo(Tree t)
			{
				if(root.weight < t.root.weight)
					return 1;
				else if(root.weight == t.root.weight)
					return 0;
				else
					return -1;
			}//end compareTo
			
			public class Node
			{
				char element;
				int weight;
				Node left;
				Node right;
				String code = "";
			
			
			public Node()
			{
				
			}//end constructor
			
			public Node(int weight, char element)
			{
				this.weight = weight;
				this.element = element;
			}
		}
			//Displays the tree
			public void displayTree()
			{
				Stack globalStack = new Stack();
				globalStack.push(root);
				int nBlanks = 32;
				boolean isRowEmpty = false;
				System.out.println("......................................................");
				while(isRowEmpty == false)
				{
					Stack localStack = new Stack();
					isRowEmpty = true;
					
					for(int j = 0; j<nBlanks; j++)
					    System.out.print(' ');
						
						while(globalStack.isEmpty() == false)
						{
							Node temp = (Node)globalStack.pop();
							if(temp != null)
							{
								System.out.print(temp.weight);
								localStack.push(temp.left);
								localStack.push(temp.right);
								
								if(temp.left != null || temp.right != null)
									isRowEmpty = false;
							}
							else
							{
								System.out.print("--");
								localStack.push(null);
								localStack.push(null);
							}
							for(int j = 0; j < nBlanks*2 - 2; j++)
								System.out.print(' ');
						}
						System.out.println();
						nBlanks /= 2;
						while(localStack.isEmpty() == false)
							globalStack.push(localStack.pop());
					}
			System.out.println("......................................................");
			}

		}//end class tree

	 
}//end class assignment5

//the heap Class
class Heap<E extends Comparable<E>>
{
	private java.util.ArrayList<E> list = new java.util.ArrayList<>();
	
	public Heap()
	{
	
	}
	
	public Heap(E[] objects){
		for(int i = 0; i < objects.length; i++)
			add(objects[i]);
	}
	
	public void add(E newObject){
		list.add(newObject);
		int currentIndex = list.size() - 1;
		
			while(currentIndex > 0)
			{
				int parentIndex = (currentIndex - 1)/2;
				
				if(list.get(currentIndex).compareTo(list.get(parentIndex)) > 0)
				{
					E temp = list.get(currentIndex);
					list.set(currentIndex, list.get(parentIndex));
					list.set(parentIndex, temp);
				}
				else
					 break;
				
				currentIndex = parentIndex;
			}
	}//end add
	
	public E remove(){
		if(list.size() == 0)
			return null;
		
		E removedObject = list.get(0);
		list.set(0, list.get(list.size() - 1));
		list.remove(list.size() - 1);
		
		int currentIndex = 0;
		while(currentIndex < list.size()){
			int leftChildIndex = 2 * currentIndex + 1;
			int rightChildIndex = 2 * currentIndex + 2;
			
				if(leftChildIndex >= list.size())
					break;
			int maxIndex = leftChildIndex;
				if(rightChildIndex < list.size()){
					if(list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0)
					{
						maxIndex = rightChildIndex;
					}
				}
				
				if(list.get(currentIndex).compareTo(list.get(maxIndex))< 0)
				{
					E temp = list.get(maxIndex);
					list.set(maxIndex, list.get(currentIndex));
					list.set(currentIndex, temp);
					currentIndex = maxIndex;
				}
				else 
					break;
		}
		
		return removedObject;
	}
	public int getSize()
	{
		return list.size();
	}
}//end class Heap