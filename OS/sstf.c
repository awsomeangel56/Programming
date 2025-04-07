#include <stdio.h>
#include <stdlib.h>
void sstf(int req[],int n,int head){
    int seek=0,count=0,done[n];
    for(int i=0;i<n;i++){
        done[i]=0;
    }
    while(count<n){
        int min=1e9,index=-1;
        for(int i=0;i<n;i++){
            if(!done[i] && abs(req[i]-head)<min){
                min=abs(req[i]-head);
                index=i;
            }
        }
        seek+=min;
    head=req[index];
    done[index]=1;
    count++;
    }
    printf("SSTF seek: %d",seek);
}
int main(){
    int n,req[100],head;
    printf("Enter the no. of requests: ");
    scanf("%d",&n);
    printf("Enter the requests queue: ");
    for(int i=0;i<n;i++){
        scanf("%d",&req[i]);
    }
    printf("Enter initial head position: ");
    scanf("%d",&head);
sstf(req,n,head);
}