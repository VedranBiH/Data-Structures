#include "header.h"

VERTEX* Stack_Top(Stack *S)
{
    if (S->size == -1) {
        printf("Error: stack empty\n");
        return NULL;
    }

    return &S->data[S->size];
}

