package hidden_specs_assignment;

public class Occurance {		
	int countOccurance (String str, String key) {
		int count = 0, last_index = 0;
		
		while (last_index != -1) {
			last_index = str.indexOf(key, last_index);
			if (last_index != -1) {
				count ++;
				last_index += key.length();
			}
		}
		
		return count;
	}	
}
