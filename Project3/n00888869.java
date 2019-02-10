import java.io.*;

import javax.swing.JOptionPane;


/**Project 3
 *Author: Vedran Pehlivanovic
 *Date: 02/14/2015
 */
public class n00888869 {
public static void main(String[] args)
	{
	boolean stop = true;
		while(stop)
		{
		String input = JOptionPane.showInputDialog(null,"Please enter your numbers","Title",
				JOptionPane.INFORMATION_MESSAGE);
		
		
		
		 if(input.equals("STOP"))
			 stop = false;
		 else
		 {
		String[] tokens = input.split(" ");
		int nums[] = new int[tokens.length];
		
			for( int i = 0; i < tokens.length; i++)
			{
				
				nums[i] = Integer.parseInt(tokens[i]);
			}//end for
			
			LinkList theList = new LinkList();
			ListIterator iter1 = theList.getIterator();
			
			for(int i = 1; i < nums[0] + 1; i ++)
			{
				iter1.insertAfter(i);
			}//end for
			
			int controller = iter1.getCurrent().data;
			while(controller != nums[1])
			{
				if(iter1.atEnd())
				{
					iter1.reset();
					controller = iter1.getCurrent().data;
				}
				else
				{
				iter1.nextLink();
				controller = iter1.getCurrent().data;
				}
			}//end while
			
		boolean control = true;
		int counter = nums[0];
		while(control)
		{
			for(int i = 0; i < nums[2]; i++)
			
			{
				if(iter1.atEnd())
					iter1.reset();
				else
					iter1.nextLink();
			}
		iter1.deleteCurrent();
		counter--;
		if(counter == 1)
			control = false;
		}
			
		
			
			
		JOptionPane.showMessageDialog(null,iter1.getCurrent().data);
		 }//end else
		}
	}//end main
}//end project3 class

 class Link
{
	public int data;
	public Link next;
	
	public Link(int dd)
	{
		data = dd;
	}//end constructor
	
	public void displayLink()
	{
		System.out.print(data + "");
	}
}//end class link

 class LinkList
{
	private Link first;

	
	public LinkList()
	{ 
		first = null;
	}//end constructor
	
	public Link getFirst()
	{
		return first;
	}// end class getFirst
	
	public void setFirst(Link f)
	{
		first = f;
	}//end class setFirst
	
	public boolean isEmpty()
	{
		return first == null;
	}// end class isEmpty
	
	public ListIterator getIterator()
	{
		return new ListIterator(this);
	}//end getIterator
	
	public void displayList()
	{
		Link current = first;
		while(current != null)
		{
			current.displayLink();
			current = current.next;
		}
		
		System.out.println("");
		
	}//end displayList
	
}//end class LinkList

class ListIterator
{
	private Link current;
	private Link previous;
	private LinkList ourList;
	
		public ListIterator(LinkList list)
		{
			ourList = list;
			reset();
		}//end constructor;
		
		public void reset()
		{
			current = ourList.getFirst();
			previous = null;
		}//end reset
		
		public boolean atEnd()
		{
			return current.next == null;
		}//end atEnd
		
		public void nextLink()
		{
			previous = current;
			current = current.next;
		}//end nextLink
		
		public Link getCurrent()
		{
			return current;
		}//end class getCurrent
		
		public void insertAfter(int data)
		{
			Link newLink = new Link(data);
			
			if( ourList.isEmpty())
			{
				ourList.setFirst(newLink);
				current = newLink;
			}//end if
				else
				{
					newLink.next = current.next;
					current.next = newLink;
					nextLink();
				}//end else
		}//end class insertAfter
		
		public void insertBefore(int data)
		{
			Link newLink = new Link(data);
			
			if(previous == null)
			{
				newLink.next = ourList.getFirst();
				ourList.setFirst(newLink);
				reset();
			}//end if
			
			else
			{
				newLink.next = previous.next;
				previous.next = newLink;
				current = newLink;
			}// else
		}//end insertBefore
		
		public int deleteCurrent()
		{
			int value = current.data;
			if(previous == null)
			{
				ourList.setFirst(current.next);
				reset();
			}//end if
			else
			{
				previous.next = current.next;
					if(atEnd())
						reset();
					else
						current = current.next;
			}//end else
			
			return value;
		}//end deleteCurrent
		
		
	}//end class ListIterator
//}//end class project3