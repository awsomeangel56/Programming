#include <stdio.h>
#include <stdlib.h>
int s[20], nv, am[20][20], visited[20], t=-1;
void push(int item){
    if(t==20){
        printf("Stack is full !!");
        return;
    }
    else{
        t++;
        s[t]=item;
    }
}
int pop(){
    int item=s[t];
    if(t==-1){
        printf("Stack is empty");
        return -1;
    }
    else{
        t--;
        return item;
    }
}
void dfs(int sv){
    visited[sv]=1;
    push(sv);
    printf("DFS Traversal: ");
    while(t!=-1){
        int cv=pop();
        printf("v%d ",cv);
        for(int i=0;i<nv;i++){
            if(am[cv][i]==1 && visited[i]==0){
                visited[i]=1;
                push(i);
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
    dfs(sv);
    return 0;
}

