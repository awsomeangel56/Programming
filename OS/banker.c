#include <stdio.h>
#define MAX 10
int main(){
    int alloc[MAX][MAX],need[MAX][MAX],max[MAX][MAX],avail[MAX],work[MAX],safe[MAX],finish[MAX];
    int p,r,i,j,count=0;
    printf("Enter the no. of processes and requests: ");
    scanf("%d%d",&p,&r);
    printf("Enter the allocation matrix:\n");
    for(i=0;i<p;i++){
        for(j=0;j<r;j++){
            scanf("%d",&alloc[i][j]);
        }
    }
    printf("Enter the maximum matrix:\n");
    for(i=0;i<p;i++){
        for(j=0;j<r;j++){
            scanf("%d",&max[i][j]);
        }
    }
    printf("Enter available resources: ");
    for(j=0;j<r;j++){
        scanf("%d",&avail[j]);
    }
    for(i=0;i<p;i++){
        for(j=0;j<r;j++){
            need[i][j]=max[i][j]-alloc[i][j];
        }
    }
    for(j=0;j<r;j++){
        work[j]=avail[j];
    }
    for(i=0;i<p;i++){
        finish[i]=0;
    }
    while(count<p){
        int found=0;
        for(i=0;i<p;i++){
            if(!finish[i]){
                int canRun=1;
            for(j=0;j<r;j++){
                if(need[i][j]>work[j]){
                    canRun=0;
                    break;
                }
            }
            if(canRun){
                for(j=0;j<r;j++){
                work[j]+=alloc[i][j];
                safe[count++]=i;
                finish[i]=1;
                found=1;
            }
        }
        }
        }
    if(!found){
        printf("System is not in a safe state");
        return 0;
    }
}
printf("System is in safe state. Safe sequence:\n");
for(i=0;i<p;i++){
    printf("P%d%s",safe[i],(i==p-1)?"\n":" -> ");
}
return 0;
}