#include <stdio.h>
#include <stdlib.h>
void fcfs(int requests[], int n, int head) {
    int seek_count = 0;
    int distance, cur_track;
    for (int i = 0; i < n; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    printf("FCFS Total Seek Count: %d\n", seek_count);
}
void sstf(int requests[], int n, int head) {
    int seek_count = 0;
    int distance, cur_track;
    int completed[n];
    for (int i = 0; i < n; i++)
        completed[i] = 0;
    for (int i = 0; i < n; i++) {
        int min = 10000, index = -1;
        for (int j = 0; j < n; j++) {
            if (!completed[j]) {
                distance = abs(requests[j] - head);
                if (distance < min) {
                    min = distance;
                    index = j;
                }
            }
        }
        seek_count += min;
        head = requests[index];
        completed[index] = 1;
    }
    printf("SSTF Total Seek Count: %d\n", seek_count);
}
void scan(int requests[], int n, int head, int disk_size) {
    int seek_count = 0;
    int distance, cur_track;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (requests[i] > requests[j]) {
                int temp = requests[i];
                requests[i] = requests[j];
                requests[j] = temp;
            }
        }
    }
    int index;
    for (index = 0; index < n; index++) {
        if (requests[index] > head) break;
    }
    for (int i = index; i < n; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    seek_count += abs(disk_size - 1 - head);
    head = disk_size - 1;
    for (int i = index - 1; i >= 0; i--) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    printf("SCAN Total Seek Count: %d\n", seek_count);
}
void cscan(int requests[], int n, int head, int disk_size) {
    int seek_count = 0;
    int distance, cur_track;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (requests[i] > requests[j]) {
                int temp = requests[i];
                requests[i] = requests[j];
                requests[j] = temp;
            }
        }
    }
    int index;
    for (index = 0; index < n; index++) {
        if (requests[index] > head) break;
    }
    for (int i = index; i < n; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    seek_count += abs(disk_size - 1 - head);
    head = 0;
    seek_count += abs(disk_size - 1);
    for (int i = 0; i < index; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    printf("CSCAN Total Seek Count: %d\n", seek_count);
}
void look(int requests[], int n, int head) {
    int seek_count = 0;
    int distance, cur_track;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (requests[i] > requests[j]) {
                int temp = requests[i];
                requests[i] = requests[j];
                requests[j] = temp;
            }
        }
    }
    int index;
    for (index = 0; index < n; index++) {
        if (requests[index] > head) break;
    }
    for (int i = index; i < n; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    for (int i = index - 1; i >= 0; i--) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    printf("LOOK Total Seek Count: %d\n", seek_count);
}
void clook(int requests[], int n, int head) {
    int seek_count = 0;
    int distance, cur_track;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            if (requests[i] > requests[j]) {
                int temp = requests[i];
                requests[i] = requests[j];
                requests[j] = temp;
            }
        }
    }
    int index;
    for (index = 0; index < n; index++) {
        if (requests[index] > head) break;
    }
    for (int i = index; i < n; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    for (int i = 0; i < index; i++) {
        cur_track = requests[i];
        distance = abs(cur_track - head);
        seek_count += distance;
        head = cur_track;
    }
    printf("CLOOK Total Seek Count: %d\n", seek_count);
}
int main() {
    int n, head, disk_size;
    int requests[100];
    printf("Enter the number of requests: ");
    scanf("%d", &n);
    printf("Enter the request queue: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &requests[i]);
    }
    printf("Enter the initial head position: ");
    scanf("%d", &head);
    printf("Enter the disk size: ");
    scanf("%d", &disk_size);
    fcfs(requests, n, head);
    sstf(requests, n, head);
    scan(requests, n, head, disk_size);
    cscan(requests, n, head, disk_size);
    look(requests, n, head);
    clook(requests, n, head);
    return 0;
}
