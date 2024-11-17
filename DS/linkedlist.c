#include <stdio.h>
#include <stdlib.h>
struct Node{
    int data;
    struct Node* next;    
};
void insertatend(struct Node** head, int data){
    struct Node* newNode=(struct Node*)malloc(sizeof(struct Node));
    struct Node* last= *head;
    newNode->data=data;
    newNode->next=NULL;
    if(*head==NULL){
        *head=newNode;
        return;
    }
    while(last->next!=NULL){
        last=last->next;
    }
    last->next=newNode;
}
void displayList(struct Node* node){
    while(node!=NULL){
        printf("%d -> ",node->data);
        node=node->next;
    }
    printf("\n");
}
struct Node* mergeList(struct Node* head1, struct Node* head2){
    if(head1==NULL){
        return head2;
    }
    if(head2==NULL){
        return head1;
    }
    if(head1->data<head2->data){
        head1->next=mergeList(head1->next,head2);
        return head1;
    }
    else{
        head2->next=mergeList(head1,head2->next);
        return head2;
    }
}
int main(){
    int ch,data;
    struct Node* head1=NULL;
    struct Node* head2=NULL;
    struct Node* Mergedhead=NULL;
    do{
        printf("\n1. insert at list 1\n2. insert at list 2\n3. display list 1\n4. display list 2\n5. merge lists\n6. display merged list\n7. exit\nenter your choice: ");
        scanf("%d",&ch);
        switch(ch){
            case 1: printf("Enter element: ");
            scanf("%d",&data);
            insertatend(&head1,data);
            break;
            case 2: printf("Enter element: ");
            scanf("%d",&data);
            insertatend(&head2,data);
            break;
            case 3: printf("List 1: \n");
            displayList(head1);
            break;
            case 4: printf("List 2: \n");
            displayList(head2);
            break;
            case 5: Mergedhead=mergeList(head1,head2);
            printf("Lists merged successfully !!");
            break;
            case 6: printf("Merged Lis: \n");
            displayList(Mergedhead);
            break;
            case 7: printf("Exitting program...");
            break;
            default: printf("Invalid choice !!");       
        }
    }while(ch!=7);
}
