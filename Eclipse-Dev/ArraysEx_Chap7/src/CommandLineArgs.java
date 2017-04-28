// 7.15
public class CommandLineArgs {

	public static void main(String[] args) {
		int[] arg = new int[1];
		test(arg);

	}
	
	public static void test(int[] args) {
		int ARRAY_SIZE;
		if (args[0] != 0)
			ARRAY_SIZE = args[0];
		else
			ARRAY_SIZE = 10;
		
		int[] newArray = new int[ARRAY_SIZE];
		
		System.out.println(newArray.length);
	}

}
