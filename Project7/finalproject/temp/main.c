#include "header.h"
/*
*Author:Vedran Pehlivanovic
*Date:04-20-2015
*Description:This program creates an adj list and performs the depth first search by implementing a stack
*/
int main(int argc, const char *argv[])
{
    int size = 0;
    VERTEX* vertex;


    vertex = graph(argv[1], &size);
    print(vertex, size);
    dfs(vertex,size);


    return 0;
}


