
public class VariableLenghtArgList {

	public static void main(String[] args) {
		int[] params = {1,2,3,4,5,6};
		
		System.out.println(product(params));

	}
	
	public static int product(int[] args) {
		int count = 0;
		for (int i = 0; i < args.length; i++) {
			count++;
		}
		return count;
	}

}
