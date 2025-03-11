#include <stdio.h>
#include <stdlib.h>
void findWaitingTime(int processes[], int n, int bt[], int wt[], int quantum) {
    int rem_bt[n]; 
    for (int i = 0; i < n; i++)
        rem_bt[i] = bt[i];
int t = 0;
    while (1) {
        int done = 1;
        for (int i = 0; i < n; i++) {
            if (rem_bt[i] > 0) {
                done = 0; 
                if (rem_bt[i] > quantum) {
                    t += quantum;
                    rem_bt[i] -= quantum;
                } else {
                    t += rem_bt[i];
                    wt[i] = t - bt[i]; 
                    rem_bt[i] = 0;
                }
            }
        }
        if (done == 1)
            break;
    }
}
void findTurnAroundTime(int processes[], int n, int bt[], int wt[], int tat[]) {
    for (int i = 0; i < n; i++)
        tat[i] = bt[i] + wt[i];
}
void findAvgTime(int processes[], int n, int bt[], int quantum) {
    int *wt = (int *)malloc(n * sizeof(int));
    int *tat = (int *)malloc(n * sizeof(int));
    if (!wt || !tat) {
        printf("Memory allocation failed!\n");
        return;
    }
    findWaitingTime(processes, n, bt, wt, quantum);
    findTurnAroundTime(processes, n, bt, wt, tat);
    printf("\nProcesses   Burst Time   Waiting Time   Turnaround Time\n");
    int total_wt = 0, total_tat = 0;
    for (int i = 0; i < n; i++) {
        total_wt += wt[i];
        total_tat += tat[i];
        printf("    %d\t\t%d\t    %d\t\t    %d\n", processes[i], bt[i], wt[i], tat[i]);
    }
    printf("\nAverage Waiting Time = %.2f ms\n", (float)total_wt / n);
    printf("Average Turnaround Time = %.2f ms\n", (float)total_tat / n);
    free(wt);
    free(tat);
}
int main() {
    int n;
    printf("Enter the number of processes: ");
    scanf("%d", &n);
    if (n <= 0) {
        printf("Invalid number of processes.\n");
        return 1;
    }
    int *processes = (int *)malloc(n * sizeof(int));
    int *burst_time = (int *)malloc(n * sizeof(int));
    if (!processes || !burst_time) {
        printf("Memory allocation failed!\n");
        return 1;
    }
    for (int i = 0; i < n; i++) {
        processes[i] = i + 1;
        printf("Enter burst time for process %d: ", i + 1);
        scanf("%d", &burst_time[i]);
        if (burst_time[i] <= 0) {
            printf("Burst time must be greater than zero!\n");
            free(processes);
            free(burst_time);
            return 1;
        }
    }
    int quantum;
    printf("Enter time quantum: ");
    scanf("%d", &quantum);
    if (quantum <= 0) {
        printf("Time quantum must be greater than zero!\n");
        free(processes);
        free(burst_time);
        return 1;
    }
    findAvgTime(processes, n, burst_time, quantum);
    free(processes);
    free(burst_time);
    return 0;
}
