// 7.14
public class VariableLenghtArgList {

	public static void main(String[] args) {
		int param1 = 1;
		int param2 = 2;
		int param3 = 3;
		
		System.out.println(product(param1, param2, param3));

	}
	
	public static int product(int ...args) {
		int count = 0;
		for (int i = 0; i < args.length; i++) {
			count++;
		}
		return count;
	}

}
