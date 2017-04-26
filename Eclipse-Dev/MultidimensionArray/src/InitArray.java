
public class InitArray {

	public static void main(String[] args) {
		int[][] arr1 = {{1,2,3}, {4,5,6}};
		int[][] arr2 = {{1,2}, {3}, {4,5}};

		System.out.println("Values in arr1 by row are");
		outputArray(arr1);
		
		System.out.printf("%nValues in arr2 by row are%n");
		outputArray(arr2);
		
	}
	
	public static void outputArray(int[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				System.out.printf("%d  ", array[row][column]);
			}
			
			System.out.println();
		}
	}

}
