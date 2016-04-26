package bg.penev.phonebook;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class CallLog {

	List<Entry<String, Integer>> callLog = new ArrayList<Entry<String, Integer>>();

	public void logCall(String phoneNumber, Integer callTimes) {
		callLog.add(new AbstractMap.SimpleEntry<String, Integer>(phoneNumber, callTimes));
		
		Collections.sort(callLog, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
	}

	public String getMostCalled() {

		List<Entry<String, Integer>> mostCalled = callLog.subList(0, 5);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			sb.append(mostCalled.get(i).getKey());
			sb.append(" ");
			sb.append(mostCalled.get(i).getValue());
			sb.append("\n");
		}
		return sb.toString();
	}
}
