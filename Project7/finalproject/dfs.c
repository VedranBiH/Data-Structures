#include "header.h"
void dfs(VERTEX* graph, int size)
{
    int i;
    for (i = 0; i < size; i++)
    graph[i].isVisited = 0;

    printf("Depth First Search: ");

    Stack *s = Stack_Init(s);
    printf("%c ", graph[0].c);
    Stack_Push(s, &graph[0]);
    graph[0].isVisited = 1;


    while(s-> size > -1)
    {
        VERTEX* v = NULL;
        EDGE* p = Stack_Top(s)->p;
        while(p != NULL)
        {
            if(!p -> v -> isVisited)
            {
                v = p->v;
                printf("%c ", v->c);
                v-> isVisited = 1;
                Stack_Push(s, v);
                break;
            }
            else{
                p = p->q;
            }

        }
        if(v == NULL)
        {
            Stack_Pop(s);
        }

    }
}
