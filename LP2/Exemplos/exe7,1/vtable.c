#include <stdio.h>
#include <stdlib.h>
#include <string.h>

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    int r,g,b;
}Color;

Color color_new(int r, int g, int b){
	Color color;
	color.r = r;
	color.g = g;
	color.b = b;
	return color;
}

void color_print(Color color){
	int r = color.r;
	int g = color.g;
	int b = color.b;
	char colors[8]="";
	if(r==255 && g==0 && b==0){
		strcpy(colors, "red");
	}else if(r==0 && g==255 && b==0){
		strcpy(colors, "green");
	}else if(r==0 && g==0 && b==255){
		strcpy(colors, "blue");
	}else if(r==163 && g==104 && b==232){
		strcpy(colors, "purple");
	}else if(r==255 && g==255 && b==0){
		strcpy(colors, "yellow");
	}else if(r==0 && g==0 && b==0){
		strcpy(colors, "black");
	}else if(r==255 && g==255 && b==255){
		strcpy(colors, "white");
	}


	printf("%s", colors);
}


///////////////////////////////////////////////////////////////////////////////

struct Figure;
typedef void (* Figure_Print) (struct Figure*);
typedef int  (* Figure_Area)  (struct Figure*);

typedef struct {
    void (* print) (struct Figure*);
    int  (* area)  (struct Figure*);
} Figure_vtable;

typedef struct Figure {
    int x, y;
    Color cor_fundo, cor_borda;
    Figure_vtable* vtable;
} Figure;

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int width, height;
} Rect;

void rect_print (Rect* this) {
    Figure* sup = (Figure*) this;
    printf("O retangulo tem tamanho (%d,%d) esta na posicao (%d,%d), e tem area (%d)",
     this->width, this->height, sup->x, sup->y, sup->vtable->area(sup));

	printf("Tem cor de fundo ");
    color_print(sup->cor_fundo);

	printf(" e cor de borda ");
    color_print(sup->cor_borda);

	printf("\n");
}

int area_rect (Rect* this) {
    Figure* sup = (Figure*) this;
    return this->width * this->height;
}

Figure_vtable rect_vtable = {
    (Figure_Print) rect_print,
    (Figure_Area)  area_rect
};

Rect* rect_novo (int x, int y, int w, int h,
    int fundo_red, int fundo_green, int fundo_blue, int borda_red, int borda_green, int borda_blue) {

    Rect*   this  = malloc(sizeof(Rect));
    Figure* sup = (Figure*) this;
    sup->vtable = &rect_vtable;

    sup->x = x;
    sup->y = y;
    this->width = w;
    this->height = h;

    sup->cor_fundo = color_new(fundo_red,fundo_green,fundo_blue);
    sup->cor_borda = color_new(borda_red,borda_green,borda_blue);
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int width, height;
} Ellipse;

void ellipse_print (Ellipse* this) {
    Figure* sup = (Figure*) this;
    printf("A ellipse tem tamanho (%d,%d) esta na posicao (%d,%d), e tem area (%d)",
     this->width, this->height, sup->x, sup->y, sup->vtable->area(sup));

	printf("Tem cor de fundo ");
    color_print(sup->cor_fundo);

	printf(" e cor de borda ");
    color_print(sup->cor_borda);

	printf("\n");
}

int area_Ellipse (Ellipse* this) {
    Figure* sup = (Figure*) this;
    return this->width * this->height;
}

Figure_vtable ellipse_vtable = {
    (Figure_Print) ellipse_print,
    (Figure_Area)  area_Ellipse
};

Ellipse* ellipse_novo (int x, int y, int w, int h,
    int fundo_red, int fundo_green, int fundo_blue, int borda_red, int borda_green, int borda_blue) {

    Ellipse* this  = malloc(sizeof(Ellipse));
    Figure* sup = (Figure*) this;
    sup->vtable = &ellipse_vtable;

    sup->x = x;
    sup->y = y;
    this->width = w;
    this->height = h;

    sup->cor_fundo = color_new(fundo_red,fundo_green,fundo_blue);
    sup->cor_borda = color_new(borda_red,borda_green,borda_blue);
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int width, height;
} Triangulo;

void triangulo_print (Triangulo* this) {
    Figure* sup = (Figure*) this;
    printf("O triangulo Eq tem tamanho (%d,%d) esta na posicao (%d,%d), e tem area (%d)",
     this->width, this->height, sup->x, sup->y, sup->vtable->area(sup));

	printf("Tem cor de fundo ");
    color_print(sup->cor_fundo);

	printf(" e cor de borda ");
    color_print(sup->cor_borda);

	printf("\n");
}

int area_trianguloEq (Triangulo* this) {
    Figure* sup = (Figure*) this;
    return (this->width * 1,732)/2 ;    // raiz de 3 == 1,732
}

Figure_vtable triangulo_vtable = {
    (Figure_Print) triangulo_print,
    (Figure_Area)  area_trianguloEq
};

Triangulo* triangulo_novo (int x, int y, int w, int h,
    int fundo_red, int fundo_green, int fundo_blue, int borda_red, int borda_green, int borda_blue) {

    Triangulo* this  = malloc(sizeof(Triangulo));
    Figure* sup = (Figure*) this;
    sup->vtable = &triangulo_vtable;

    sup->x = x;
    sup->y = y;
    this->width = w;
    this->height = h;

    sup->cor_fundo = color_new(fundo_red,fundo_green,fundo_blue);
    sup->cor_borda = color_new(borda_red,borda_green,borda_blue);
    return this;
}

///////////////////////////////////////////////////////////////////////////////

typedef struct {
    Figure super;
    int width, height;
} Pentaguno;

void pentaguno_print (Pentaguno* this) {
    Figure* sup = (Figure*) this;
    printf("O pentaguno regular tem tamanho (%d,%d) esta na posicao (%d,%d), e tem area (%d)",
     this->width, this->height, sup->x, sup->y, sup->vtable->area(sup));

	printf("Tem cor de fundo ");
    color_print(sup->cor_fundo);

	printf(" e cor de borda ");
    color_print(sup->cor_borda);

	printf("\n");
}

int pentagunoReg_area (Triangulo* this) {
    Figure* sup = (Figure*) this;
    return (this->width * 5) * (this->height/2) ;    // area é 5 * lado * apotema
}

Figure_vtable pentaguno_vtable = {
    (Figure_Print) pentaguno_print,
    (Figure_Area)  pentagunoReg_area
};

Pentaguno* pentaguno_novo (int x, int y, int w, int h,
    int fundo_red, int fundo_green, int fundo_blue, int borda_red, int borda_green, int borda_blue) {

    Pentaguno* this  = malloc(sizeof(Pentaguno));
    Figure* sup = (Figure*) this;
    sup->vtable = &pentaguno_vtable;

    sup->x = x;
    sup->y = y;
    this->width = w;
    this->height = h;

    sup->cor_fundo = color_new(fundo_red,fundo_green,fundo_blue);
    sup->cor_borda = color_new(borda_red,borda_green,borda_blue);
    return this;
}

///////////////////////////////////////////////////////////////////////////////

void main (void) {
    Figure* figs[4] = {
        (Figure*) rect_novo(30,30,50,50,255,0,0,0,255,0), // fundo vermelho e borda verde
        (Figure*) ellipse_novo(30,50,100,200,0,0,255,255,255,0), // fundo verde e borda amarela
        (Figure*) triangulo_novo(50,50,150,150,0,0,255,163,104,232), // fundo azul e borda lilaz
        (Figure*) pentaguno_novo(30,30,100,100,255,255,255,0,0,0) // fundo branco e borda preta
    };

    ///
	int i;
    for (i=0; i<4; i++) {
        figs[i]->vtable->print(figs[i]);
    }

    ///

    for (i=0; i<4; i++) {
        free(figs[i]);
    }
}