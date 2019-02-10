#include "header.h"

VERTEX* graph(const char* filename, int* size)
{
    char ch1, ch2;

	int counter = 0;
    char buffs[10];
    VERTEX* vertex = (VERTEX*)calloc(100, sizeof(VERTEX));

 VERTEX* v1;


    VERTEX* v2;
    EDGE* e;

    int i;

    /* open the file */
    FILE* fp = fopen(filename, "r");
    if (fp == NULL)
    {
        printf("Invalid file\n");
        *size = 0;
        return vertex;
    }



    while (!feof(fp))
    {
        if (fscanf(fp, "%s", buffs) != 1)
            break;
        ch1 = buffs[0];
        if (fscanf(fp, "%s", buffs) != 1)
            break;
        ch2 = buffs[0];

        v1 = v2 = NULL;
        /* search v1 and v2 */
        for (i = 0; i < counter; i++)
        {
            if (vertex[i].c == ch1)
                v1 = &(vertex[i]);
            if (vertex[i].c == ch2)
                v2 = &(vertex[i]);
        }//end for loop

        /* create vertex if it is not in list */
        if (v1 == NULL)
        {
            v1 = &(vertex[counter]);
            counter++;
            v1->c = ch1;
            v1->isVisited = 0;
            v1->p = NULL;
        }
        if (v2 == NULL)
        {
            v2 = &(vertex[counter]);
            counter++;
            v2->c = ch2;
            v2->isVisited = 0;
            v2->p = NULL;
        }
        /* create the edge */
        e = (EDGE*)malloc(sizeof(EDGE));
        e->v = v2;
        e->q = v1->p;
        v1->p = e;

    }



    *size = counter;


    return vertex;
}


