#include <stdio.h>
#include <stdlib.h>

void sort(int arr[], int n) {
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (arr[j] > arr[j+1]) {
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
}

void fcfs(int req[], int n, int head) {
    int seek = 0;
    for (int i = 0; i < n; i++) {
        seek += abs(req[i] - head);
        head = req[i];
    }
    printf("FCFS Seek: %d\n", seek);
}

void sstf(int req[], int n, int head) {
    int seek = 0, done[n], count = 0;
    for (int i = 0; i < n; i++) done[i] = 0;
    while (count < n) {
        int min = 1e9, index = -1;
        for (int i = 0; i < n; i++) {
            if (!done[i] && abs(req[i] - head) < min) {
                min = abs(req[i] - head);
                index = i;
            }
        }
        seek += min;
        head = req[index];
        done[index] = 1;
        count++;
    }
    printf("SSTF Seek: %d\n", seek);
}

void scan(int req[], int n, int head, int size) {
    int seek = 0;
    sort(req, n);
    int i;
    for (i = 0; i < n && req[i] < head; i++);
    for (int j = i; j < n; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    seek += abs((size - 1) - head);
    head = size - 1;
    for (int j = i - 1; j >= 0; j--) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    printf("SCAN Seek: %d\n", seek);
}

void cscan(int req[], int n, int head, int size) {
    int seek = 0;
    sort(req, n);
    int i;
    for (i = 0; i < n && req[i] < head; i++);
    for (int j = i; j < n; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    seek += abs((size - 1) - head) + (size - 1);
    head = 0;
    for (int j = 0; j < i; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    printf("CSCAN Seek: %d\n", seek);
}

void look(int req[], int n, int head) {
    int seek = 0;
    sort(req, n);
    int i;
    for (i = 0; i < n && req[i] < head; i++);
    for (int j = i; j < n; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    for (int j = i - 1; j >= 0; j--) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    printf("LOOK Seek: %d\n", seek);
}

void clook(int req[], int n, int head) {
    int seek = 0;
    sort(req, n);
    int i;
    for (i = 0; i < n && req[i] < head; i++);
    for (int j = i; j < n; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    for (int j = 0; j < i; j++) {
        seek += abs(req[j] - head);
        head = req[j];
    }
    printf("CLOOK Seek: %d\n", seek);
}

int main() {
    int n, head, size, req[100];
    printf("Enter number of requests: ");
    scanf("%d", &n);
    printf("Enter request queue: ");
    for (int i = 0; i < n; i++) scanf("%d", &req[i]);
    printf("Enter initial head position: ");
    scanf("%d", &head);
    printf("Enter disk size: ");
    scanf("%d", &size);

    fcfs(req, n, head);
    sstf(req, n, head);
    scan(req, n, head, size);
    cscan(req, n, head, size);
    look(req, n, head);
    clook(req, n, head);
    return 0;
}
