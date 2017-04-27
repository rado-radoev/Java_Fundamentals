
public class ArrayCopy {

	public static void main(String[] args) {
		int[] arr1 = new int[11];
		int[] arr2 = new int[34];
		
		
		System.arraycopy(arr1, 0, arr2, 0, arr1.length);

	}

}
