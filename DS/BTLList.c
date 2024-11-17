#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node* left;
    struct Node* right;};
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;}
struct Node* insert(struct Node* root, int data) {
    if (root == NULL) {
        return createNode(data);}
    if (data < root->data) {
        root->left = insert(root->left, data);} 
    else if (data > root->data) {
        root->right = insert(root->right, data);}
    return root;}
struct Node* search(struct Node* root, int data) {
    if (root == NULL || root->data == data) {
        return root;}
    if (data < root->data) {
        return search(root->left, data);}
    return search(root->right, data);}
struct Node* minValueNode(struct Node* node) {
    struct Node* current = node;
    while (current && current->left != NULL) {
        current = current->left;}
    return current;}
struct Node* deleteNode(struct Node* root, int data) {
    if (root == NULL) {
        return root;}
    if (data < root->data) {
        root->left = deleteNode(root->left, data);} 
    else if (data > root->data) {
        root->right = deleteNode(root->right, data);} 
    else {
        if (root->left == NULL) {
            struct Node* temp = root->right;
            free(root);
            return temp;}
        else if (root->right == NULL) {
            struct Node* temp = root->left;
            free(root);
            return temp;}
        struct Node* temp = minValueNode(root->right);
        root->data = temp->data;
        root->right = deleteNode(root->right, temp->data);}
    return root;}
void inorder(struct Node* root) {
    if (root != NULL) {
        inorder(root->left);
        printf("%d ", root->data);
        inorder(root->right);}}
int main() {
    struct Node* root = NULL;
    int choice, value;
    while (1) {
        printf("\nMenu:\n1.Insert\n2.Search\n3.Delete\n4.Display\n5. Exit\nEnter your choice: ");
        scanf("%d", &choice);
        switch (choice) {
            case 1:
                printf("Enter value to insert: ");
                scanf("%d", &value);
                if (search(root, value) != NULL) {
                    printf("Value already exists in the tree.\n");} 
                else {
                    root = insert(root, value);}
                break;
            case 2:
                printf("Enter value to search: ");
                scanf("%d", &value);
                if (search(root, value) != NULL) {
                    printf("Value found in the tree.\n");
                } else {
                    printf("Value not found in the tree.\n");
                }
                break;
            case 3:
                printf("Enter value to delete: ");
                scanf("%d", &value);
                root = deleteNode(root, value);
                break;
            case 4:
                printf("Binary Tree: ");
                inorder(root);
                printf("\n");
                break;
            case 5:
                exit(0);
            default:
                printf("Invalid choice\n");}}
    return 0;}