#include "header.h"

VERTEX* Stack_Pop(Stack *S)
{
    if (S->size == -1)
        printf("Error: stack empty\n");
    else {
        return &(S->data[(S->size)--]);
    }
}
