#include "header.h"

int main(int argc, const char *argv[])
{
    int size = 0;
    VERTEX* vertex;


    vertex = graph(argv[1], &size);
    print(vertex, size);
    dfs(vertex,size);


    return 0;
}


