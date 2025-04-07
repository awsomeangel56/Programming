#include <stdio.h>
#include <stdlib.h>
void fcfs(int req[], int n, int head) {
    int seek = 0;
    for (int i = 0; i < n; i++) {
        seek += abs(req[i] - head);
        head = req[i];
    }
    printf("FCFS Seek: %d\n", seek);
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
fcfs(req,n,head);
}