#include <stdio.h>
#include <stdlib.h>
int q[20], nv, am[20][20], visited[20], f=-1, r=-1;
void enqueue(int item){
    if(r==19){
        printf("Queue is full !!");
        return;
    }
    else if(f==-1){
        f=r=0;
    }
    else{
        r++;
    }
    q[r]=item;
}
int dequeue(){
    int item=q[f];
    if(f==-1){
        printf("Queue is empty");
        return -1;
    }
    else if(f==r){
        f=r=-1;
    }
    else{
        f++;
    }
    return item;
}
void bfs(int sv){
    visited[sv]=1;
    enqueue(sv);
    printf("BFS Traversal: ");
    while(f!=-1){
        int cv=dequeue();
        printf("v%d ",cv);
        for(int i=0;i<nv;i++){
            if(am[cv][i]==1 && visited[i]==0){
                visited[i]=1;
                enqueue(i);
            }
        }

    }
    printf("\n");
}
int main(){
    int e,sv;
    printf("Enter the number of vertices: ");
    scanf("%d",&nv);
    for(int i=0;i<nv;i++){
        visited[i]=0;
        for(int j=0;j<nv;j++){
            am[i][j]=0;
        }
    }
    for(int i=0;i<nv;i++){
        for(int j=0;j<nv;j++){
            if(i!=j){
            printf("Want to create an edge between v%d and v%d? Enter '1' for yes and '0' for no: ",i,j);
            scanf("%d",&e);
            if(e==1){
                am[i][j]=1;
                }
            }
        }
    }
    printf("Adjacency matrix: ");
    printf("\n");
    for(int i=0;i<nv;i++){
        for(int j=0;j<nv;j++){
            printf("%d ",am[i][j]);
        }
        printf("\n");
    }
    printf("Enter the starting vertex from (0 to %d): ",nv-1);
    scanf("%d",&sv);
    bfs(sv);
    return 0;
}

