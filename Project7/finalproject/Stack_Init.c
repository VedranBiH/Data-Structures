#include "header.h"
Stack *Stack_Init()
{
    Stack *t = malloc(sizeof *t);
    t->data = (VERTEX*)calloc(100, sizeof(VERTEX));
    t->size = -1;
    return t;
}
