/*
  Name: Project 2
  Author: Vedran Pehlivanovic
  Date: 28/01/15 14:06
  Description: This program accepts a data file of integers of random size. It outputs the array in a sorted order
  it uses a even-odd sort.
*/


#include "my.h"

int numIn[60000];
int main(int argc, char** argv)
 {
	 FILE *input;
	 
	 bool sort = 0;
	 int size;
     int i,j,output,inputData;
     
	 input = fopen(argv[1], "r+");
	 fscanf(input , "%d", &numIn[0]);

	 size = numIn[0];

	 for(inputData = 0; inputData < size; inputData++)
	 {
		 fscanf(input, "%d" , &numIn[inputData]);

	 }//end for


	 fclose(input);

	 while(!sort)
	 {
		 sort = 1;
		 for( i = 0; i < size; i += 2)
		 {    
             if((i + 1) >= size)
             {
              break;
             }
			 if(numIn[i] > numIn[i + 1])
			 {
				 swap(numIn, i);
				 sort = 0;
			 }//end if
		 }//end for

		 for ( j = 1; j < size; j += 2)
		 {   
             if((j + 1) >= size)
             {
                  break;
             }    
			 if(numIn[j] > numIn[j + 1])
		 {
			 swap(numIn, j);
				 sort = 0;
			 }//end if
		 }//end for
		
	 }//end while
	 
	 while(output != -1)
	 {         
               printf("Please enter the index of the array you would like to see(the range is between 0 to %d: ", (size - 1));
               scanf("%d", &output);
               
               if( output >= size)
               {
                   printf("Invalid input\n");
               }
               else
                   printf("The integer stored in index %d is %d\n", output, numIn[output]); 
                  
     }//end while
	 
 }//end main


