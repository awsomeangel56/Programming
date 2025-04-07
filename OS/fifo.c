#include <stdio.h>
#define max_frames 100
#define max_pages 100
void fifo(int pages[],int n,int capacity){
    int frames[max_frames],count=0,faults=0,front=0;
    for(int i=0;i<n;i++){
        int found=0;
        for(int j=0;j<count;j++){
            if(frames[j]==pages[i]){
                found=1;
                break;
            }
        }
        if(!found){
            if(count<capacity){
                frames[count++]=pages[i];
            }
            else{
                frames[front]=pages[i];
                front=(front+1)%capacity;
            }
            faults++;
        }
    }
    printf("FIFO page faults: %d\n",faults);
}
int main(){
    int n,pages[max_pages],capacity;
    printf("Enter the no. of processes: ");
    scanf("%d",&n);
    printf("Enter the reference string: ");
    for(int i=0;i<n;i++){
    scanf("%d",&pages[i]);
    }
    printf("Enter the nunber of frames: ");
    scanf("%d",&capacity);
fifo(pages,n,capacity);
}