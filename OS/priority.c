#include<stdio.h>
int total;
struct process{
    int pid,priority,bt,wt,tat;
}p[20];
void sort(){
    struct process temp;
    for(int i=0;i<total-1;i++){
        for(int j=0;j<total-i-1;j++){
            if(p[j].priority>p[j+1].priority){
                temp=p[j];
                p[j]=p[j+1];
                p[j+1]=temp;
            }
        }
    }
}
void findtime(){
    p[0].wt=0;
    p[0].tat=p[0].bt;
    for(int i=1;i<total;i++){
        p[i].wt=p[i-1].wt+p[i-1].bt;
        p[i].tat=p[i].wt+p[i].bt;
    }
}
void printGanttChart() {
    printf("\nGantt Chart:\n| ");
    int t = 0;
    for (int i = 0; i < total; i++) {
        printf("P%d\t|", p[i].pid);
        t += p[i].bt;
    }
    printf("\n0\t"); 
    t = 0;
    for (int i = 0; i < total; i++) {
        t += p[i].bt;
        printf("%d\t", t);
    }
    printf("\n");
}
void main(){
    printf("enter number of process \n");
    scanf("%d",&total);

    for(int i=0;i<total;i++){
        p[i].pid=i+1;
        printf("enter priority of P%d ",p[i].pid);
        scanf("%d",&p[i].priority);
        printf("enter burst time of P%d ",p[i].pid);
        scanf("%d",&p[i].bt);

    }
    sort();
    findtime();
    printGanttChart();
    float avgtat,avgwt;
    for(int i=0;i<total;i++){
        avgwt+=p[i].wt;
        avgtat+=p[i].tat;
    }
    avgwt/=total;
    avgtat/=total;
    printf("Avg Waiting Time:%.2f ms",avgwt);
    printf("Avg Turnaround Time:%.2f ms",avgtat);
}