#include <stdlib.h>
#include "rect.h"

void main (void) {
    Rect* r1 = rect_novo();
    rect_printa(r1);

    Rect* r2 = rect_novo();
    rect_drag(r2, 10,100);
    rect_printa(r2);

    free(r1);
    free(r2);
}