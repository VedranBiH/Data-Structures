#include <stdio.h>
#include "header.h"

void print(VERTEX* vertex, int size)
{
    int i, n;
    EDGE* e;
    printf("Graph: \n");
    for (i = 0; i < size; i++)
    {
        /* print vertex */
        printf("%c\t", vertex[i].c);

        /* print adjancency list */
        e = vertex[i].p;
        while (e != NULL)
        {
            if (e != vertex[i].p)
                printf(" -> ");
            printf("%c", e->v->c);
            e = e->q;
        }
        printf("\n");
    }//end for loop
    printf("\n");
}

