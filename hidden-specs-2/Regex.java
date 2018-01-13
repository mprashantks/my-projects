package hidden_specs_assignment;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.List;
import java.util.ArrayList;

public class Regex {
	String[] getSentences(String str) {
		String sentences[] = str.split("\\.");
		String sanitized_sentences[] = new String[sentences.length];
		int i = 0;
		for (String sentence: sentences) {
			sentence = sentence.trim();
			sanitized_sentences[i++] = sentence;
		}
		return sanitized_sentences;
	}
	
	String getName(String str) {
		List<String> match = new ArrayList<String>(1);
		// Here I am considering that person name always occurs after 'The xxxx Prime Minister of India is',
		// where xxxx can be any number followed by abbreviation e.g., 14th
		Pattern pattern = Pattern.compile("(?i)(?<=\\bPrime Minister of India is \\b).*");
		Matcher matcher = pattern.matcher(str);
		if (matcher.find())
			match.add(matcher.group());
		if (!match.isEmpty())
			return match.get(0);
		return "Not found";
	}
	
	String getDate(String str) {
		List<String> match = new ArrayList<String>(1);
		// Here I am considering that date can occur anywhere between sentence
		// If date always occurs at end of sentence then the approach used in getName() can be applied instead
		Pattern pattern = Pattern.compile("(?i)\\b(\\d{1,2})[-/ ](\\d{1,2}|Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sept|Oct|Nov|Dec)[-/ ](\\d{1,4})\\b");
		Matcher matcher = pattern.matcher(str);
		// To get all matches if should be replaced with while and List should be given appropriate size
		if (matcher.find())
			match.add(matcher.group());
		if (!match.isEmpty())
			return match.get(0);
		return "Not found";
	}
}
