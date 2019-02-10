#include "my.h"

void swap (int x[], int y)
{
	int temp;
    temp = x[y];
	x[y] = x[y+1];
	x[y+1] = temp;
}//end swap
