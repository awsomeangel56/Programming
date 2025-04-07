#include<stdio.h>
int bt[50],wt[50],tat[50],total,pid[50];
void sort(){
    int temp;
    for(int i=0;i<total-1;i++){
        for(int j=0;j<total-i-1;j++){
            if(bt[j]>bt[j+1]){
                temp=bt[j];
                bt[j]=bt[j+1];
                bt[j+1]=temp;
            }
        }
    }
}
void findwt(){
    wt[0]=0;
    for(int i=1;i<total;i++)
        wt[i]=bt[i-1]+wt[i-1];
}
void findtat(){
    for(int i=0;i<total;i++)
        tat[i]=bt[i]+wt[i];
}
void findat(){
    int totalwt=0,totaltat=0;
        printf("Process\tBurst Time\tWaiting Time\tTurnaround Time\n");
        for(int i=0;i<total;i++){
            printf("\nP%d\t\t%d\t\t%d\t\t%d\t\t",i,bt[i],wt[i],tat[i]);
            totalwt+=wt[i];
            totaltat+=tat[i];
        }
        float w=(float)totalwt/total;
        float t=(float)totaltat/total;
        printf("\ntotal waiting time = %d \n",totalwt);
        printf("total turn around time =%d \n",totaltat);
        printf("average wt=%f \n average tat=%f \n",w,t);
}
void main(){
    printf("enter number of process\n");
    scanf("%d",&total);
    printf("enter burst time\n");
    for(int i=0;i<total;i++){
        pid[i]=i+1;
        scanf("%d",&bt[i]);
    }
    sort();
    findwt();
    findtat();
    findat();
}