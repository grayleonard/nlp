package com.leonard.nlp;

import java.io.*;
import java.util.Arrays;

import opennlp.tools.tokenize.*;
import opennlp.tools.postag.*;

/**
 * Hello world!
 *
 */
public class App 
{

	public static TokenizerModel tokModel = null;
	public static POSModel posModel = null;
	public static Knowledgebase kbase = null;
	public static QuestionFactory qfact = new QuestionFactory();


	public static void main( String[] args )
	{
		InputStream tokenModelIn = null;
		InputStream posModelIn = null;
		try {
		    tokenModelIn = new FileInputStream("en-token.bin");
		    posModelIn = new FileInputStream("en-pos-maxent.bin");
		} catch(Exception e) {
		e.printStackTrace();
		}
		try {
		tokModel = new TokenizerModel(tokenModelIn);
		posModel = new POSModel(posModelIn);
		} catch(Exception e) {
		e.printStackTrace();
		}
		finally {
		if((tokenModelIn != null) && (posModelIn != null)) {
			try {
				tokenModelIn.close();
				posModelIn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		}

		String[] keywords = {"mother", "father"};
		kbase = new Knowledgebase(keywords);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for(int i = 0; i < keywords.length; i++) {
			System.out.println(qfact.generate(keywords[i]));
			String input = "";
			try {
				input = in.readLine();
			} catch(Exception e){}
			runAnalysis(input, keywords[i]);
		}

		kbase.printResults();
	}

	public static void runAnalysis(String in, String keyword) {
		System.out.println(in + keyword);
		Tokenizer tokenizer = new TokenizerME(tokModel);
		POSTaggerME tagger = new POSTaggerME(posModel);
		String tokens[] = tokenizer.tokenize(in);
		String tags[] = tagger.tag(tokens);
		if(Utils.containsKeyword(tokens, keyword)) {
			kbase.storeResult(keyword, Utils.getPOS(tokens, tags, "JJ"));
		}
	}


}
