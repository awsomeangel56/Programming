#include <stdio.h>

void allocate(char* name, int mem[], int pro[], int m, int p, int mode) {
    int a[100], used[100] = {0}, allocated[100] = {0};

    for (int i = 0; i < m; i++) a[i] = mem[i];
    
    // Sort blocks based on mode
    for (int i = 0; i < m - 1; i++) {
        for (int j = 0; j < m - i - 1; j++) {
            if ((mode == 1 && a[j] > a[j + 1]) || (mode == 2 && a[j] < a[j + 1])) {
                int temp = a[j]; a[j] = a[j + 1]; a[j + 1] = temp;
            }
        }
    }

    printf("\n%s Fit\n", name);
    for (int i = 0; i < p; i++) {
        int allocatedFlag = 0;
        for (int j = 0; j < m; j++) {
            if (!used[j] && a[j] >= pro[i]) {
                printf("Process %d allocated to Block %d (Wastage: %d)\n", pro[i], a[j], a[j] - pro[i]);
                used[j] = 1;
                allocated[i] = 1;
                allocatedFlag = 1;
                break;
            }
        }
        if (!allocatedFlag)
            printf("Process %d could not be allocated\n", pro[i]);
    }
}

int main() {
    int mem[100], pro[100], m, p;

    printf("Enter number of memory blocks: ");
    scanf("%d", &m);
    for (int i = 0; i < m; i++) {
        printf("Enter size of Block %d: ", i + 1);
        scanf("%d", &mem[i]);
    }

    printf("Enter number of processes: ");
    scanf("%d", &p);
    for (int i = 0; i < p; i++) {
        printf("Enter size of Process %d: ", i + 1);
        scanf("%d", &pro[i]);
    }

    allocate("First", mem, pro, m, p, 0);  // 0 = No sorting
    allocate("Best", mem, pro, m, p, 1);   // 1 = Ascending (best fit)
    allocate("Worst", mem, pro, m, p, 2);  // 2 = Descending (worst fit)

    return 0;
}
