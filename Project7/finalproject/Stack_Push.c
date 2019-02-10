#include "header.h"

void Stack_Push(Stack *S, VERTEX* d)
{
    if (S->size < 100)
        S->data[++(S->size)] = *d;
    else
        printf("Error: stack full\n");
}
