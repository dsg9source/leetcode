package Extra;

public class RemoveDuplicateFromSortedArray {
	public static void main(String args[]) {
		int arr[] = { 1, 2, 2, 3, 4, 4, 4, 5, 5};
		removeDuplicateUsingNoExtraSpace(arr);

		// Print updated array
		for (int i = 0; i < arr.length; i++)
			System.out.print(arr[i] + " ");
	}

	public static int[] removeDuplicate(int[] arr) {
		int[] auxArray = new int[arr.length];
		int j = 0, k = 0;
		for (int i = 0; i < arr.length;) {
			auxArray[j] = arr[i];
			j++;
			k = i + 1;
			while (k < arr.length && arr[i] == arr[k]) {
				k++;
			}
			i = k;
		}
		for (int i = 0; i < arr.length; i++) {

			arr[i] = auxArray[i];

		}

		return arr;
	}
	
	public static int[] removeDuplicateUsingNoExtraSpace(int[] arr) {
		int lastUniqueIndex=0;
		
		for(int i=lastUniqueIndex+1;i<arr.length;i++) {
			if(arr[lastUniqueIndex]!=arr[i]) {
				lastUniqueIndex++;
				arr[lastUniqueIndex]=arr[i];
			}
		}
		for(int i=lastUniqueIndex+1;i<arr.length;i++) {
			arr[i]=0;
		}
		return arr;
	}
}
