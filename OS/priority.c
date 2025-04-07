#include <stdio.h>
int total;
struct process{
    int pid,bt,wt,tat,priority;
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
void main(){
    printf("Enter the no. of processes: ");
    scanf("%d",&total);
    for(int i=0;i<total;i++){
        p[i].pid=i+1;
        printf("Enter priority of P%d: ",i+1);
        scanf("%d",&p[i].priority);
        printf("Enter burst time of P%d: ",i+1);
        scanf("%d",&p[i].bt);
    }
sort();
findtime();
float avgtat=0,avgwt=0;
printf("\nProcess\tBurst time\tPriority\tTurn around time\tWaiting time\t\n");
for(int i=0;i<total;i++){
    avgtat+=p[i].tat;
    avgwt+=p[i].wt;
    printf("P%d\t\t%d\t\t%d\t\t%d\t\t%d\t\t\n",p[i].pid,p[i].bt,p[i].priority,p[i].tat,p[i].wt);
}
avgtat/=total;
avgwt/=total;
printf("\nAverage turn around time: %f",avgtat);
printf("\nAvergae waiting time: %f",avgwt);
}
