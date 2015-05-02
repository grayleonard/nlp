package com.leonard.nlp;

import java.util.ArrayList;

public class Utils {

	public static ArrayList<String> getPOS(String[] tokens, String[] pos, String dPos) {
		int stringPos = 0;
		ArrayList<String> results = new ArrayList<String>();
		for(; stringPos < pos.length; stringPos++) {
			if(pos[stringPos].equals(dPos)) {
				results.add(tokens[stringPos]);
			}
		}
		return results;
	}

	public static boolean containsKeyword(String[] tokens, String keyword) {
		for(int i = 0; i < tokens.length; i++) {
			if(tokens[i].equals(keyword)) {
				return true;
			}
		}
		return false;
	}

}
