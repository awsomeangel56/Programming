#include <stdio.h>
#include <stdlib.h>
void sort(int arr[],int n){
    for(int i=0;i<n-1;i++){
        for(int j=0;j<n-i-1;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
        }
    }
}
void scan(int req[],int n, int head, int size){
    int i,seek=0;
    sort(req,n);
    for(i=0;i<n && req[i]<head;i++);
    for(int j=i;j<n;j++){
        seek+=abs(req[j]-head);
        head=req[j];
    }
    seek+=abs((size-1)-head);
    head=size-1;
    for(int j=i-1;j>=0;j--){
        seek+=abs(req[j]-head);
        head=req[j];
    }
    printf("SCAN seek: %d",seek);
}
int main(){
    int n,req[100],head,size;
    printf("Enter the no. of requests: ");
    scanf("%d",&n);
    printf("Enter the requests queue: ");
    for(int i=0;i<n;i++){
        scanf("%d",&req[i]);
    }
    printf("Enter initial head position: ");
    scanf("%d",&head);
    printf("Enter disk size: ");
    scanf("%d",&size);
scan(req,n,head,size);

}