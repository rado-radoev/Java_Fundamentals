// 7.16
public class EnhancedStatement {

	public static void main(String[] args) {
		String[] params = {"1.2", "3.5", "6.7", "1.2"};
		blah(params);

	}
	
	public static void blah(String[] args) {
		double sum = 0;
		for (String s : args) {
			sum += Double.parseDouble(s);
		}
		
		System.out.println(sum);
	}

}
