package com.leonard.nlp;

import java.util.Random;

public class QuestionFactory {

	public QuestionFactory() {
	}

	public String generate(String keyword) {
		String generated =  "Tell me about your %s";
		generated = String.format(generated, keyword);
		return generated;
	}
}
