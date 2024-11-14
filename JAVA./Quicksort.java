public class Quicksort{
    private static void swap(String[] arr, int i, int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static int partition(String[] arr, int low, int high){
        String pivot=arr[high];
        int i=(low-1);
        for(int j=low;j<high;j++){
            if(arr[j].compareTo(pivot)<0){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
    private static void quicksort(String[] arr, int low, int high){
        if(low<high){
        int pi=partition(arr, low, high);
        quicksort(arr,low,pi-1);
        quicksort(arr,pi+1,high);
    }
}
public static void main(String[] args) {
    String[] names={"Mohammed","Bilal","Shabnam","Hidayath","Rauf"};
    System.out.println("Before Sorting: ");
    for(String name:names){
        System.out.println(name+" ");
    }
    quicksort(names,0,names.length-1);
    System.out.println("After Sorting: ");
    for(String name:names){
        System.out.println(name+" ");
        }
    }
}