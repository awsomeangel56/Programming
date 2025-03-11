#include <stdio.h>
struct process {
    int pid, at, bt, tat, wt, ct;
};
void printGanttChart(struct process p[], int n) {
    int i, j;
    printf("\nGantt Chart:\n");
    printf(" ");
    for (i = 0; i < n; i++) {
        for (j = 0; j < p[i].bt; j++) printf("--");
        printf(" ");
    }
    printf("\n|");
    for (i = 0; i < n; i++) {
        for (j = 0; j < p[i].bt - 1; j++) printf(" ");
        printf("P%d", p[i].pid);
        for (j = 0; j < p[i].bt - 1; j++) printf(" ");
        printf("|");
    }
    printf("\n ");
    for (i = 0; i < n; i++) {
        for (j = 0; j < p[i].bt; j++) printf("--");
        printf(" ");
    }
    printf("\n0");
    for (i = 0; i < n; i++) {
        for (j = 0; j < p[i].bt; j++) printf("  ");
        printf("%d", p[i].ct);
    }
    printf("\n");
}
int main() {
    struct process p[100], temp;
    int n, i, j, ct;
    printf("Enter the number of processes: ");
    scanf("%d", &n);
    for (i = 0; i < n; i++) {
        p[i].pid = i + 1;
        printf("Enter the arrival time for process %d: ", i + 1);
        scanf("%d", &p[i].at);
        printf("Enter the burst time for process %d: ", i + 1);
        scanf("%d", &p[i].bt);
    }
    for (i = 0; i < n - 1; i++) {
        for (j = 0; j < n - i - 1; j++) {
            if (p[j].at > p[j + 1].at) {
                temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
    p[0].ct = p[0].at + p[0].bt;
    p[0].tat = p[0].ct - p[0].at;
    p[0].wt = p[0].tat - p[0].bt;
    for (i = 1; i < n; i++) {
        ct = p[i - 1].ct;
        if (p[i].at > ct) {
            p[i].ct = p[i].at + p[i].bt;
        } else {
            p[i].ct = ct + p[i].bt;
        }
        p[i].tat = p[i].ct - p[i].at;
        p[i].wt = p[i].tat - p[i].bt;
    }
    printf("\nProcess ID\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time\n");
    for (i = 0; i < n; i++) {
        printf("%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t%d\n", p[i].pid, p[i].at, p[i].bt, p[i].ct, p[i].tat, p[i].wt);
    }
    printGanttChart(p, n);
    return 0;
}