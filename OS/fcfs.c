#include <stdio.h>

struct Process {
    int id, at, bt, ct, tat, wt;
};

void ganttChart(struct Process p[], int n) {
    printf("\nGantt Chart:\n ");
    for (int i = 0; i < n; i++) for (int j = 0; j < p[i].bt; j++) printf("--");
    printf("\n|");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < p[i].bt - 1; j++) printf(" ");
        printf("P%d", p[i].id);
        for (int j = 0; j < p[i].bt - 1; j++) printf(" ");
        printf("|");
    }
    printf("\n ");
    for (int i = 0; i < n; i++) for (int j = 0; j < p[i].bt; j++) printf("--");
    printf("\n0");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < p[i].bt; j++) printf("  ");
        printf("%d", p[i].ct);
    }
    printf("\n");
}

int main() {
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);

    struct Process p[n];
    for (int i = 0; i < n; i++) {
        p[i].id = i + 1;
        printf("Enter arrival and burst time for P%d: ", i + 1);
        scanf("%d%d", &p[i].at, &p[i].bt);
    }

    // Sort by arrival time
    for (int i = 0; i < n - 1; i++)
        for (int j = 0; j < n - i - 1; j++)
            if (p[j].at > p[j + 1].at) {
                struct Process temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }

    int time = 0;
    for (int i = 0; i < n; i++) {
        time = (time < p[i].at) ? p[i].at : time;
        p[i].ct = time + p[i].bt;
        p[i].tat = p[i].ct - p[i].at;
        p[i].wt = p[i].tat - p[i].bt;
        time = p[i].ct;
    }

    printf("\nID\tAT\tBT\tCT\tTAT\tWT\n");
    for (int i = 0; i < n; i++)
        printf("P%d\t%d\t%d\t%d\t%d\t%d\n", p[i].id, p[i].at, p[i].bt, p[i].ct, p[i].tat, p[i].wt);

    ganttChart(p, n);
    return 0;
}
