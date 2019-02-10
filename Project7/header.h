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

#define STACK_MAX 100

struct Stack {
    VERTEX*     data;
    int     size;
};
typedef struct Stack Stack;


/* print graph, vertex is array, size is number of vertices*/
void print(VERTEX* vertex, int size);

/*build graph, return the size and array */
VERTEX* graph(const char* filename, int* size);

void dfs(VERTEX* vertex,int size);

Stack *Stack_Init();

VERTEX* Stack_Top(Stack *S);

void Stack_Push(Stack *S, VERTEX* d);

VERTEX* Stack_Pop(Stack *S);

