package bg.penev.phonebook;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneBook {

	private Map<String, String> phoneBook = new TreeMap<String, String>();

	private String pattern = "(^(?:00359|\\+359|0))(87|88|89)?([2-9]{1}?\\d{6})$";
	Pattern regexPattern = Pattern.compile(pattern);

	public void addEntry(String name, String number) {
		phoneBook.put(name, number);
	}

	public void deleteEntry(String name) {
		phoneBook.remove(name);
	}

	public String getPhone(String name) {
		return phoneBook.get(name);
	}

	public void importPhones(String filename) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String line;
			while ((line = reader.readLine()) != null) {
				String[] currentRecord = line.split(",");
				Matcher m = regexPattern.matcher(currentRecord[1]);
				if (m.matches())					
					addEntry(currentRecord[0],  "+359" + m.group(2) + m.group(3));
			}
			reader.close();
		} catch (Exception e) {
			System.err.format("Exception occurred trying to read '%s'.", filename);
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
			sb.append(entry.getKey());
			sb.append(" ");
			sb.append(entry.getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
}
