#include <stdio.h>

int a[20], s, f, r;

void insertFront(int item) {
    if ((r + 1) % s == f) {
        printf("Queue is full\n");
    } else if (f == -1 && r == -1) {
        f = r = 0;
        a[f] = item;
    } else {
        f = (f - 1 + s) % s;
        a[f] = item;
    }
}

void insertRear(int item) {
    if ((r + 1) % s == f) {
        printf("Queue is full\n");
    } else if (f == -1 && r == -1) {
        f = r = 0;
        a[r] = item;
    } else {
        r = (r + 1) % s;
        a[r] = item;
    }
}

void deleteFront() {
    if (f == -1 && r == -1) {
        printf("Queue is empty\n");
    } else if (f == r) {
        printf("Deleted element from front: %d\n", a[f]);
        f = r = -1;
    } else {
        printf("Deleted element from front: %d\n", a[f]);
        f = (f + 1) % s;
    }
}

void deleteRear() {
    if (f == -1 && r == -1) {
        printf("Queue is empty\n");
    } else if (f == r) {
        printf("Deleted element from rear: %d\n", a[r]);
        f = r = -1;
    } else {
        printf("Deleted element from rear: %d\n", a[r]);
        r = (r - 1 + s) % s;
    }
}

void traverse() {
    if (f == -1 && r == -1) {
        printf("Queue is empty\n");
    } else {
        int i = f;
        printf("Queue elements: ");
        while (1) {
            printf("%d\t", a[i]);
            if (i == r)
                break;
            i = (i + 1) % s;
        }
        printf("\n");
    }
}

int main() {
    int ch, item;
    printf("Enter the size of queue: ");
    scanf("%d", &s);
    f = r = -1;
    do {
        printf("\n1. Insert Front\n2. Insert Rear\n3. Delete Front\n4. Delete Rear\n5. Traverse\n6. Exit\n");
        printf("Enter choice: ");
        scanf("%d", &ch);
        switch (ch) {
            case 1:
                printf("Enter the element to insert at front: ");
                scanf("%d", &item);
                insertFront(item);
                break;
            case 2:
                printf("Enter the element to insert at rear: ");
                scanf("%d", &item);
                insertRear(item);
                break;
            case 3:
                deleteFront();
                break;
            case 4:
                deleteRear();
                break;
            case 5:
                traverse();
                break;
            case 6:
                printf("Exiting...\n");
                break;
            default:
                printf("Invalid choice\n");
                break;
        }
    } while (ch != 6);

    return 0;
}
