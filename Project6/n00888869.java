

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
/*
 * Author:Vedran Pehlivanovic
 * Date: 04/07/2015
 * Assignment 6
 * Description: This program takes different load factors and creates different sizes array and then loads them with the same 10,000 random INTS
 * asks the user for the max value INT and then does 100 random number searchs for all the arrays linear and quad.
 */

public class n00888869 {

	public static void main(String[] args) {
		ArrayList<HashTable> holder = new ArrayList<HashTable>();
		
		int[] randomNumbers = new int[10000];
		int[] searchKeys = new int[100];
		double[] TSLinear = new double[9];
		double loadFactor = 0.1;
		double[] TFLinear = new double[9];
		double[] TSQuad = new double[18];
		double[] TFQuad = new double[18];
		
				for(int i = 0; i < 18; i++)
				{
					
					holder.add(new HashTable(loadFactor));
					loadFactor = loadFactor + 0.1;
							
					loadFactor = (double)Math.round(loadFactor * 100)/100;
					if(i == 8)
						loadFactor = 0.1;
					
				}
				
				double ts = 0;
				double tf = 0;
				
			System.out.println("Please enter the max value for your random numbers: ");
			
			Scanner input = new Scanner(System.in);
			
			int maxValue = input.nextInt();
			double LF = 0.0;
			
		fillRandomNumbers(randomNumbers,holder,maxValue);	
		generateRandom(searchKeys,holder,maxValue);
		generateTSLinear(TSLinear);
		generateTFLinear(TFLinear);
		generateTSQuad(TSQuad);
		generateTFQuad(TFQuad);
		System.out.println("Linear");
		System.out.print("Load   ES   DS   TS    EF    DF   TF\n"
	                     +"----   --   --   --    --    --   --\n");
		for(int i = 0; i < 9; i++)
		{
			System.out.format("%.1f  %3.2f  %3d  %3.2f  %3.2f  %3d %5.2f %n",LF += 0.1, holder.get(i).getES(),
				holder.get(i).getCorrect(),TSLinear[i],
				holder.get(i).getEF(),holder.get(i).getInCorrect(),TFLinear[i]);
		}
		
		LF = 0.0;
      System.out.println("");
		System.out.println("Quadratic Probing");
		System.out.print("Load   ES   DS   TS    EF    DF   TF\n"
                +"----   --   --   --    --    --   --\n");
		for(int i = 9; i < 18; i++)
		{
			System.out.format("%.1f  %3.2f  %3d  %3.2f  %3.2f  %3d %5.2f %n",LF += 0.1, holder.get(i).getES(),
				holder.get(i).getCorrect(),TSQuad[i],
				holder.get(i).getEF(),holder.get(i).getInCorrect(),TFQuad[i]);
		}

	}//end main
	
public static void fillRandomNumbers(int[] randomNumbers,ArrayList<HashTable> holder,int maxValue)
	{
		Random random1 = new Random(1);
		
			for(int i = 0; i < 10000; i++)
			{
				randomNumbers[i] = random1.nextInt(maxValue) + 1;
			}//end for loop
			
			for(int j = 0; j <holder.size(); j++)
			{
				if(j <= 8)
				{
					for(int x = 0; x < randomNumbers.length; x++)
					{
						holder.get(j).insertLinear(randomNumbers[x]);
					}
				}
				else
				{
					for(int x = 0; x < randomNumbers.length; x++)
					{
					holder.get(j).insertQuad(randomNumbers[x]);
					}
				}
			}
		
	}//end fillRandomNumbers
public static void generateRandom(int[] searchKeys, ArrayList<HashTable> holder,int maxValue)
{
	Random random2 = new Random();
		for(int i = 0; i < searchKeys.length; i++)
		{
			searchKeys[i] = random2.nextInt(maxValue) + 1;
		}
		
		for(int j = 0; j < holder.size(); j++)
		{
			if(j <= 8)
			{
				for(int x = 0; x < searchKeys.length; x++)
				{
					holder.get(j).findLinear(searchKeys[x]);
				}
			}
			else
			{
				for( int x = 0; x < searchKeys.length;x++)
				{
					holder.get(j).findQuad(searchKeys[x]);
				}
			}
		}
		
}

public static void generateTSLinear(double[]TS)
{
	double L = 0.1;
	for(int i = 0; i < TS.length; i++)
	{
		TS[i] = (1+(1/(1-L))) /2;
		L += 0.1;
	}
}

public static void generateTFLinear(double[] TF)
{
	double L = 0.1;
	for(int i = 0; i < TF.length; i++)
	{
		TF[i] =  (1 + (1 /(Math.pow(1-L, 2))))/2;
		L += 0.1;
	}
}

public static void generateTSQuad(double[] TS)
{
	TS[9] = 1.52;
	TS[10] = 1.61;
	TS[11] =1.72;
	TS[12] =1.84;
	TS[13] =2.00;
	TS[14] = 2.02;
	TS[15] =2.84;
	TS[16] =2.90;
	TS[17] =3.69;
}

public static void generateTFQuad(double[] TF)
{
	TF[9] = 1.11;
    TF[10] = 1.25;
    TF[11] = 1.43;
	TF[12] =1.67;
	TF[13] =2.00;
	TF[14] = 2.5;
	TF[15] =3.33;
	TF[16] =5.0;
	TF[17] = 10.0;
}


}//end class

class HashTable {
	
private String[] hashTable;
private int size;
private int correct;
private int inCorrect;
private int totalDistance;
private int correctComparisons;
private int incorrectComparisons;

public HashTable(double loadFactor)
{
	size = primeNumber((int)(10000/loadFactor));
	hashTable = new String[size];
	correct = 0;
	inCorrect = 0;
	incorrectComparisons = 0;
	correctComparisons = 0;
}
	

private int hashFcn(String key)
{
	
	String[] tokens = key.split("");
	int[] poly = new int[tokens.length];
	int value = 0;
	for(int i = 0; i < tokens.length; i++)
	{
		poly[i] = Integer.parseInt(tokens[i]);
		value = (value * 10 + poly[i]) % size;
		
	}//end for loop

	
	return value;
	
}//end hashFcn


public void insertLinear(int key)
{
	int hashVal = hashFcn(Integer.toString(key));
	
	while(hashTable[hashVal] != null)
	{
		++hashVal;
		hashVal %= size;
	}
	hashTable[hashVal] = Integer.toString(key);
	
}

public void insertQuad(int key)
{
	int times = 1;
	int hashVal = hashFcn(Integer.toString(key));
	while((hashTable[hashVal] != null) && !hashTable[hashVal].equals(Integer.toString(key)))
	{
		
		hashVal += Math.pow(times, 2);
		hashVal %= size;
		times++;
	}
	
	hashTable[hashVal] = Integer.toString(key);
	
}

public void findQuad(int key)
{
	totalDistance = 0;
	int hashVal = hashFcn(Integer.toString(key));
	int times = 1;
	while((hashTable[hashVal]!= null) && !hashTable[hashVal].equals(Integer.toString(key)))
		{
			hashVal += Math.pow(times, 2);
			hashVal %= size;
			times++;
			totalDistance++;
		}
	if(hashTable[hashVal] == null)
	{
		inCorrect++;
		incorrectComparisons += totalDistance;
	}
	else
	{
		totalDistance++;
		correct++;
		correctComparisons += totalDistance;
	}
}



public void findLinear(int key)
{
	totalDistance = 0;
	int hashVal = hashFcn(Integer.toString(key));
	int checker = hashVal;
	while((hashTable[hashVal]!=null) && !hashTable[hashVal].equals(Integer.toString(key)))
	{
		totalDistance++;
		hashVal++;
		hashVal %= size;
		if(checker == hashVal)
			break;
	}
		
	if(hashTable[hashVal] == null)
    {
       inCorrect++;
       incorrectComparisons += totalDistance;
    }
    
    
    else//process the found thing 
    {
    	totalDistance++;
       correct++;
       correctComparisons += totalDistance;
    }
	
}

private int primeNumber(int min)
{
	for(int j = min + 1; true; j++)
		if(isPrime(j) )
			return j;
}

private boolean isPrime(int n)
{
	for(int j = 2; (j*j <= n); j++)
	if(n % j == 0)
		return false;
	return true;
}

public int getCorrect()
{
	return correct;
}

public int getInCorrect(){
	return inCorrect;
}

public int getCorrectComparisons(){
	return correctComparisons;
}

public int getIncorrectComparisons(){
	return incorrectComparisons;
}

public double getES()
{
	
	return ((double)correctComparisons/correct);
}

public double getEF(){
	
	return ((double)incorrectComparisons/inCorrect);
}



}//end class
