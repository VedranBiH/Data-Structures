#include "header.h"

void Stack_Push(Stack *S, VERTEX* d)
{
    if (S->size < STACK_MAX)
        S->data[++(S->size)] = *d;
    else
        printf("Error: stack full\n");
}
