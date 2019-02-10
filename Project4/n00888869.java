import java.util.ArrayList;

import javax.swing.JOptionPane;
public class n00888869 {
/*Author:Vedran Pehlivanovic
Date: 02 - 25- 2015
Descripition: Solves the knapsack problem using recurison.

*/
private static String solution = "";

public static void main(String[] args){
	int maxWeight;
	ArrayList<Integer> path = new ArrayList<Integer>();
	String input = JOptionPane.showInputDialog(null,"Please enter your input","n00888869",JOptionPane.INFORMATION_MESSAGE);
	
	String[] tokens = input.split(" ");
	
	ArrayList<Integer> nums = new ArrayList<Integer>();
	
	for(int i  = 0; i < tokens.length; i++){
		
		nums.add(Integer.parseInt(tokens[i]));
	}//end for
	
	maxWeight = nums.get(0);
	
	nums.remove(0);
	
	solve(maxWeight, nums, path,0);
	System.out.println(solution);
	
}//end main

public static void solve(int weight, ArrayList<Integer> weights, ArrayList<Integer> path, int x)
{
	ArrayList<Integer> p = new ArrayList<Integer>(path.size());
	p.addAll(0, path);
	if(weight == 0)
	{
		for(int i = 0; i < path.size(); i++)
		{
			solution += weights.get(path.get(i)) + " ";
		}
		solution += "\n";
		return;
	}
	
	if(weight < 0 || x == weights.size())
	{
		return;
	}
	
	solve(weight,weights,p,x + 1);
	p.add(x);
	solve(weight - weights.get(x), weights, p, x+1);
	return;
	
}//end class solve


}//end class Test

