package hidden_specs_assignment;

public class Palindrome {		
	boolean isPalindrome (String str) {
		int i = 0, j = str.length()-1;
		boolean flag = true;
		
		while (i <= j) {
			if (str.charAt(i++) != str.charAt(j--)) {
				flag = false;
				break;
			}
		}
		
		return flag;
	}	
}
