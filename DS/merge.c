#include <stdio.h>
void merge(int arr[], int low, int mid, int high){
    int n1=mid-low+1;
    int n2=high=mid;
    int left[n1],right[n2];
    for(int i=0;i<n1;i++){
        left[i]=arr[low+i];
    }
    for(int j=0;j<n2;j++){
        right[j]=arr[mid+1+j];
    }
    int i=0,j=0,k=low;
    while(i<n1 && j<n2){
        if(left[i]<=right[j]){
                arr[k]=left[i];
                i++;
            }
            else{
                arr[k]=right[j];
                j++;
            }
            k++;
    }
    while(i<n1){
        arr[k]=right[i];
        i++;
        k++;
    }
    while(j<n2){
        arr[k]=right[n2];
        j++;
        k++;
    }
}
void mergesort(int arr[], int low, int high){
    if(low<high){
        int mid=low+(high-low)/2;
        mergesort(arr,low,mid);
        mergesort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }
}
int main(){
    int n;
    printf("Enter the no. of elements: ");
    scanf("%d",&n);
    int arr[n];
    printf("Enter the numbers to sort: ");
    for(int i=0;i<n;i++){
        scanf("%d",&arr[i]);
    }
    printf("Before sorting: ");
    printf("\n");
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
    mergesort(arr,0,n-1);
    printf("After sorting: ");
    printf("\n");
    for(int i=0;i<n;i++){
        printf("%d ",arr[i]);
    }
return 0;
}

