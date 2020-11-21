package BinarySearch;

public class PeakIndexInMountainArray {
	public static void main(String[] args) {
		int[] arr=new int[] {
				/*24,69,100,99,79,78,67,36,26,19*/
				/*3,4,5,1*/
				/*0,1,0*/
				/*0,2,1,0*/
				0,10,5,2,1
				};
		System.out.println(peakIndexInMountainArray(arr));
	}
    public static int peakIndexInMountainArray(int[] arr) {
        int lo=0;
        int high=arr.length-1;
        return binarySearch(arr, lo, high);
        
    }
    
    public static int binarySearch(int[] arr,int lo,int high) {
    	if(lo==0 && high==1) {
    		return high;//according to condition this should never be executed
    	}
    	if(lo==arr.length-2 && high==arr.length-1) {
    		return lo;
    	}
    	int mid=(lo+high)/2;
    	if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1]) {
        	return mid;
        }else if(arr[mid]>arr[mid-1] && arr[mid]<arr[mid+1]) {
        	return binarySearch(arr,mid+1,high);
        	
        }else if(arr[mid]<arr[mid-1] && arr[mid]>arr[mid+1]) {
        	return binarySearch(arr, lo, mid-1);
        }
    	return mid;
    }
}
