#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>

/* Forward declaration */
struct EDGETAG;

typedef struct
{
    char c;
    bool isVisited;
    struct EDGETAG* p;
} VERTEX;

typedef struct EDGETAG
{
    VERTEX* v;
    struct EDGETAG* q;
} EDGE;


struct Stack {
    VERTEX*     data;
    int     size;
};
typedef struct Stack Stack;


/* print graph, vertex is array, size is number of vertices*/
void print(VERTEX* vertex, int size);

/*build graph, return the size and array */
VERTEX* graph(const char* filename, int* size);

//perform depth first search, vertex is an array and size is the number of vertices
void dfs(VERTEX* vertex,int size);

//initalize the stack
Stack *Stack_Init();
//peek at the top of  the stack
VERTEX* Stack_Top(Stack *S);
//push an item on top of the stack
void Stack_Push(Stack *S, VERTEX* d);
//pop off the first item in the stack
VERTEX* Stack_Pop(Stack *S);

