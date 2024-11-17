#include <stdio.h>
#include <stdlib.h>
struct Node{
    int coeff;
    int pow;
    struct Node* next;
};
struct Node* createnode(int coeff,int pow){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    newNode->coeff=coeff;
    newNode->pow=pow;
    newNode->next=NULL;
    return newNode;
}
void addnode(struct Node** poly,int coeff, int pow){
    struct Node* newNode=createnode(coeff, pow);
    struct Node* temp= *poly;
    if(*poly==NULL){
        *poly=newNode;
        return;
    }
    while(temp->next!=NULL){
        temp=temp->next;
    }
    temp->next=newNode;
}
void displayNode(struct Node* poly){
    while(poly!=NULL){
        printf("%dX^%d ",poly->coeff,poly->pow);
        poly=poly->next;
        if(poly!=NULL){
            printf(" + ");
        }
    }
}
struct Node* addPolynomials(struct Node* poly1, struct Node* poly2){
    struct Node* temp1=poly1;
    struct Node* temp2=poly2;
    struct Node* result=NULL;
    while(temp1!=NULL && temp2!=NULL){
        if(temp1->pow==temp2->pow){
            addnode(&result,temp1->coeff+temp2->coeff,temp1->pow);
            temp1=temp1->next;
            temp2=temp2->next;
        }
        else if(temp1->pow>temp2->pow){
            addnode(&result,temp1->coeff,temp1->pow);
            temp1=temp1->next;
        }
        else{
            addnode(&result,temp2->coeff,temp2->pow);
            temp2=temp2->next;
        }
    }
        while(temp1!=NULL){
            addnode(&result,temp1->coeff,temp1->pow);
            temp1=temp1->next;
        }
        while(temp2!=NULL){
            addnode(&result,temp2->coeff,temp2->pow);
            temp2=temp2->next;
        }
        return result;    
}
struct Node* multiplyPolynomials(struct Node* poly1, struct Node* poly2){
    struct Node* result=NULL;
    for(struct Node* temp1=poly1; temp1!=NULL; temp1=temp1->next){
        for(struct Node* temp2=poly2; temp2!=NULL; temp2=temp2->next){
            int coeff=temp1->coeff*temp2->coeff;
            int pow=temp1->pow+temp2->pow;
            addnode(&result,coeff,pow);
        }
    }
    return result;
}
void inputPolynomials(struct Node** poly){
    int n,coeff,pow;
    printf("Enter the no. of terms: ");
    scanf("%d",&n);
    for(int i=0;i<n;i++){
    printf("Enter the coefficients and power for term%d: ",i+1);
    scanf("%d%d",&coeff,&pow);
    addnode(poly,coeff,pow);
    }
}
int main(){
    struct Node* poly1=NULL;
    struct Node* poly2=NULL;
    printf("Input first polynomial: \n");
    inputPolynomials(&poly1);
    printf("Input second polynomial: \n");
    inputPolynomials(&poly2);
    printf("First polynomial: ");
    displayNode(poly1);
    printf("Second polynomial: ");
    displayNode(poly2);
    struct Node* sum=addPolynomials(poly1,poly2);
    struct Node* product=multiplyPolynomials(poly1,poly2);
    printf("Sum of polynomials: ");
    displayNode(sum);
    printf("Product of polynomials: ");
    displayNode(product);
return 0;
}
