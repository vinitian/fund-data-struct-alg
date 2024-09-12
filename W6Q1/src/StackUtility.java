
public class StackUtility {
	static String alphabets = "abcdefghijklmnopqrstuvwxyz";
	
	public static String operate(MyStack s1, MyStack s2) throws Exception {
		String decode = "";
		while (!s1.isEmpty()) {
			int a = s1.top();
			s1.pop();
			if (s1.isEmpty()) { //if "a" is dummy frame
				return decode;
			}
			int b = s1.top();
			s1.pop();
			
			if (s2.top() < 0) {
				decode = alphabets.charAt(a-b) + decode;
			} else {
				decode = alphabets.charAt(a+b) + decode;
			}
			s2.pop();
		}

		return decode;
		
	}
}
