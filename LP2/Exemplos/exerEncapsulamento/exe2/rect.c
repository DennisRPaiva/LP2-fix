#include "rect.h"
#include <stdlib.h>
#include <stdio.h>

struct Figure;
typedef void (* Figure_Print) (struct Figure*);

typedef struct Figure {
    int x, y;
    void (* print) (struct Figure*);
} Figure;

typedef struct Rect{
	int x, y;
    int w, h;

}Rect;
///////////////////////////////////////////////////////

Rect* rect_novo (void){
	Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->print = (Figure_Print) rect_printa;
    sup->x = 0;
    sup->y = 0;
    this->w = 30;
    this->h = 30;
}

void rect_drag (Rect* this, int dx, int dy){
	Figure* sup = (Figure*) this;
	this->x +=dx;
	this->y +=dy;
}

void rect_printa (Rect* this){
	Figure* sup = (Figure*) this;
    printf("RECT (%d,%d) (%d,%d).\n", sup->x, sup->y,this->w, this->h);
}