#include<stdio.h>

int total, bt[20], wt[20], tat[20], q, pid[20];

void findwt() {
    int rembt[total];
    for (int i = 0; i < total; i++)
        rembt[i] = bt[i];
    int t = 0;
    printf("\nGantt Chart:\n");
    printf("|");
    int time[30],index=0;
    while (1) {
        int done = 1;
        for (int i = 0; i < total; i++) {
            if (rembt[i] > 0) {
                done = 0;
                if (rembt[i] > q) {
                    printf("P%d\t|", pid[i]);
                    time[index++]=t;
                    t += q;
                    rembt[i] -= q;
                } else {
                    printf(" P%d\t|", pid[i]);
                    time[index++]=t;
                    t += rembt[i];
                    wt[i] = t - bt[i];
                    rembt[i] = 0;
                }
            }
        }
        if (done == 1)
            break;
    }
    time[index++] = t;
    printf("\n");
    for(int i=0;i<index;i++)
        printf("%d\t",time[i]);
}

void findtat() {
    for (int i = 0; i < total; i++)
        tat[i] = bt[i] + wt[i];
}

void findavg() {
    printf("\nProcess\tBurst Time\tWaiting Time\tTurnaround Time\n");
    int totalwt = 0, totaltat = 0;
    for (int i = 0; i < total; i++) {
        totalwt += wt[i];
        totaltat += tat[i];
        printf("  %d\t\t%d\t\t  %d\t\t  %d\n", pid[i], bt[i], wt[i], tat[i]);
    }
    printf("Average Waiting Time = %.2f\n", (float)totalwt / (float)total);
    printf("Average Turnaround Time = %.2f\n", (float)totaltat / (float)total);
}

void main() {
    printf("Enter total number of processes: ");
    scanf("%d", &total);
    for (int i = 0; i < total; i++) {
        pid[i] = i + 1;
        printf("Enter burst time of P%d: ", i + 1);
        scanf("%d", &bt[i]);
    }
    printf("Enter quantum: ");
    scanf("%d", &q);
    findwt();
    findtat();
    findavg();
}