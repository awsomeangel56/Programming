#include <stdio.h>
int main(){
    int arr[100],e,i,j,n,t=0,c,p,f=0;
    printf("Enter the number of elements: ");
    scanf("%d", &n);
    printf("Enter the elements:\n");
    for (i=0;i<n;i++) {
            scanf("%d",&arr[i]);}
    while(t==0){
        printf("MENU \n1.Insert element at the beginning\n2.Insert element at the end\n3.Insert element at a given position\n4.Delete an element from the beginning\n5.Delete an element from the end\n6.Delete an element at a given position\n7.Delete a given element\n8.Display array\n9.Exit\nPlease enter choice:");
        scanf("%d",&c);
        switch(c){
            case 1:printf("Enter the element to insert: ");
                    scanf("%d", &e);
                    for (i=n;i>=0;i--) {
                        arr[i+1]=arr[i];}
                    arr[0] = e; 
                    n++; 
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 2:printf("Enter the element to insert: ");
                    scanf("%d", &e);
                    arr[n] = e;
                    n++;
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 3:printf("Enter the position: ");
                    scanf("%d", &p);
                    printf("Enter the element to insert: ");
                    scanf("%d", &e);
                    for (i=n-1;i>=p-1;i--) {
                        arr[i+1]=arr[i];}
                    arr[p-1]=e;
                    n++;
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 4:for(i=1;i<n;i++) {
                        arr[i-1]=arr[i];}
                    n--;
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 5:n--;
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 6:printf("Enter the position: ");
                    scanf("%d", &p);
                    for (i=p-1;i<n-1;i++){ 
                        arr[i]=arr[i+1];}
                    n--;
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 7:printf("Enter the element to delete: ");
                    scanf("%d", &e);
                    for(i=0;i<n;i++){
                        if (arr[i]==e){
                            f=1;
                            break;}}
                    if(f){
                    for(j=i;j<n-1;j++) {
                            arr[j]=arr[j+1];
                        }
                    n--;} 
                    else{
                        printf("Element not found.\n");}
                    printf("Updated array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 8:printf("array:\n");
                    for (i=0;i<n;i++) {
                        printf("%d ",arr[i]);}
                    break;
            case 9:printf("\nexiting program");
                    t=1;
                    break;
            default: printf("wrong choice");
        }
    }
}