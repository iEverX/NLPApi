package b.test;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.jieba.JiebaTokenizer;
import buaanlp.api.tokenizer.jieba.Stemmer;

public class TestMain {

	public static void main(String[] args) {
		String string = "我觉得Ansj中文分词是一个不错的系统!";
		String usrPath = "userDic.dic";
		new Stemmer().loadDict(usrPath);
		//用户添加自定词典
		
		Tokenizer tokenizer = new JiebaTokenizer();
		String [] result = tokenizer.tokenize(string);
		for (String w : result)
			System.out.println(w);
		//输出分词结果
		System.out.println("----------------");
		Token[] resultWithPostag = tokenizer.tokenizeWithPostag(string);
		for (Token w: resultWithPostag)
			System.out.println(w.getWord()+"	"+w.getPostag());
		//输出分词结果与词性
	}
}
