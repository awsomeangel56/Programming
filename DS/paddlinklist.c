#include <stdio.h>
#include <stdlib.h>

struct Node {
    int coeff;
    int pow;
    struct Node* next;
};

struct Node* createNode(int coeff, int pow) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->coeff = coeff;
    newNode->pow = pow;
    newNode->next = NULL;
    return newNode;
}

void addNode(struct Node** poly, int coeff, int pow) {
    struct Node* newNode = createNode(coeff, pow);
    if (*poly == NULL) {
        *poly = newNode;
    } else {
        struct Node* temp = *poly;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = newNode;
    }
}

void displayPoly(struct Node* poly) {
    while (poly != NULL) {
        printf("%dx^%d", poly->coeff, poly->pow);
        poly = poly->next;
        if (poly != NULL) {
            printf(" + ");
        }
    }
    printf("\n");
}

struct Node* addPolynomials(struct Node* poly1, struct Node* poly2) {
    struct Node* result = NULL;
    struct Node* temp1 = poly1;
    struct Node* temp2 = poly2;

    while (temp1 != NULL && temp2 != NULL) {
        if (temp1->pow > temp2->pow) {
            addNode(&result, temp1->coeff, temp1->pow);
            temp1 = temp1->next;
        } else if (temp1->pow < temp2->pow) {
            addNode(&result, temp2->coeff, temp2->pow);
            temp2 = temp2->next;
        } else {
            addNode(&result, temp1->coeff + temp2->coeff, temp1->pow);
            temp1 = temp1->next;
            temp2 = temp2->next;
        }
    }

    while (temp1 != NULL) {
        addNode(&result, temp1->coeff, temp1->pow);
        temp1 = temp1->next;
    }

    while (temp2 != NULL) {
        addNode(&result, temp2->coeff, temp2->pow);
        temp2 = temp2->next;
    }

    return result;
}

void inputPolynomial(struct Node** poly) {
    int n, coeff, pow;
    printf("Enter the number of terms in the polynomial: ");
    scanf("%d", &n);
    for (int i = 0; i < n; i++) {
        printf("Enter coefficient and power for term %d: ", i + 1);
        scanf("%d %d", &coeff, &pow);
        addNode(poly, coeff, pow);
    }
}

int main() {
    struct Node* poly1 = NULL;
    struct Node* poly2 = NULL;

    printf("Input first polynomial:\n");
    inputPolynomial(&poly1);

    printf("Input second polynomial:\n");
    inputPolynomial(&poly2);

    printf("First Polynomial: ");
    displayPoly(poly1);

    printf("Second Polynomial: ");
    displayPoly(poly2);

    struct Node* result = addPolynomials(poly1, poly2);

    printf("Resultant Polynomial: ");
    displayPoly(result);

    return 0;
}