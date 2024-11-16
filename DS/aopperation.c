#include <stdio.h>
int main(){
    int i,j,e,p,f=0,t=0,c,n;
    int arr[100];
    printf("Enter the size of array: ");
    scanf("%d",&n);
    printf("Enter the elements: ");
    for(i=0;i<n;i++){
    scanf("%d",&arr[i]);
    }
    while(t==0){
        printf("1.insert element at beginning\n2.insert element at end\n3.insert element at given position\n4.delete element from beginning\n5.delete element from end\n6.delete element from given position\n7.delete given element\n8.display elements\n9.exit\nEnter your choice: ");
        scanf("%d",&c);
        switch(c){
            case 1:printf("Enter the element: ");
            scanf("%d",&e);
            for(i=n;i>=0;i--){
                arr[i+1]=arr[i];
            }
            arr[0]=e;
            n++;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
            break;
            case 2: printf("Enter element: ");
            scanf("%d",&e);
            arr[n]=e;
            n++;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
                }
                break;
                
            case 3: printf("Enter position: ");
            scanf("%d",&p);
            printf("Enter element: ");
            scanf("%d",&e);
            for(i=n-1;i>=p-1;i--){
                arr[i+1]=arr[i];
            }
            arr[p-1]=e;
            n++;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
            break;
            case 4:for(i=1;i<n;i++){
                arr[i-1]=arr[i];
            }
            n--;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
            break;
            case 5: n--;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
            break;
            case 6: printf("Enter the position: ");
            scanf("%d",&p);
            for(i=p-1;i<n-1;i++){
                arr[i]=arr[i+1];
            }
            n--;
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
                break;
            case 7: printf("Enter element: ");
            scanf("%d",&e);
            for(i=0;i<n;i++){
                if(arr[i]==e){
                    f=1;
                    break;
                    }
                }
                if(f==1){
                    for(j=i;j<n-1;j++){
                        arr[j]=arr[j+1];
                
                }
            n--;
            }
            else{
                printf("Element not found !!");
            }
            printf("\nupdated array:\n");
            for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
                break;
            case 8: for(i=0;i<n;i++){
                printf("%d ",arr[i]);
            }
            break;
            case 9: t=1;
            break;
            default: printf("Invalid choice !!");
return 0;            
        }
    }
}
