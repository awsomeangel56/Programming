#include <stdio.h>
struct Process {
    int pid;
    int priority;
    int b_t; 
    int w_t; 
    int t_t; 
};
void sort(struct Process p[], int n) {
    struct Process temp;
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (p[j].priority < p[j + 1].priority) { 
                temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
    }
}
void find_time(struct Process p[], int n) {
    p[0].w_t = 0;
    p[0].t_t = p[0].b_t;
    for (int i = 1; i < n; i++) {
        p[i].w_t = p[i - 1].w_t + p[i - 1].b_t;
        p[i].t_t = p[i].w_t + p[i].b_t;
    }
}
void gantt(struct Process p[], int n) {
    printf("\nGantt Chart\n");
    printf("-------------------------\n");
    for (int i = 0; i < n; i++) {
        printf("| P%d ", p[i].pid);
    }
    printf("|\n");
    printf("-------------------------\n");
    printf("0"); 
    for (int i = 0; i < n; i++) {
        printf("    %d", p[i].t_t);
    }
    printf("\n");
}
int main() {
    int n;
    printf("Enter number of processes: ");
    scanf("%d", &n);
    struct Process p[n];
    for (int i = 0; i < n; i++) {
        p[i].pid = i + 1;
        printf("Enter Priority for P%d: ", p[i].pid);
        scanf("%d", &p[i].priority);
        printf("Enter Burst Time for P%d: ", p[i].pid);
        scanf("%d", &p[i].b_t);
    }
    sort(p, n);
    find_time(p, n);
    gantt(p, n);
    float avg_wt = 0, avg_tt = 0;
    for (int i = 0; i < n; i++) {
        avg_wt += p[i].w_t;
        avg_tt += p[i].t_t;
    }
    avg_wt /= n;
    avg_tt /= n;
    printf("\nAvg Waiting Time: %.2f ms\n", avg_wt);
    printf("Avg Turnaround Time: %.2f ms\n", avg_tt);
    return 0;
}
