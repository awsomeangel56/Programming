#include <stdio.h>
#define max_frames 100
#define max_pages 100
void lru(int pages[],int n,int capacity){
    int frames[max_frames],time[max_frames],count=0,faults=0;
    for(int i=0;i<n;i++){
        int found=0;
    for(int j=0;j<count;j++){
        if(frames[j]==pages[i]){
            found=1;
            time[j]=i;
            break;
    }
}
    if(!found){
        if(count<capacity){
            frames[count]=pages[i];
            time[count]=i;
            count++;
        }
        else{
            int lru_index=0;
            for(int j=1;j<capacity;j++){
                if(time[j]<time[lru_index]){
                    lru_index=j;
                }
            }
            frames[lru_index]=pages[i];
            time[lru_index]=i;
        }
        faults++;
        }
    }
    printf("LRU faults: %d",faults);
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
lru(pages,n,capacity);
}