package chapter5;

public class BinarytoString {
	
	public static String convert(double f) {
		
		if (f>=1||f<=0)
			return "ERROR";
		
		StringBuilder builder = new StringBuilder();
		builder.append(".");
		
		while (f>0) {
			f*=2;
			if (f>=1) {
				builder.append("1");
				f=f-1;
			} else {
				builder.append("0");
			}
			
			if(builder.toString().length()>32)
				return "ERROR";			
		}
		
		return builder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(BinarytoString.convert(0.625));
		System.out.println(BinarytoString.convert(0.0625));
		System.out.println(BinarytoString.convert(0.25));
		System.out.println(BinarytoString.convert(0.09375));
		System.out.println(BinarytoString.convert(0.08));
	}
}
