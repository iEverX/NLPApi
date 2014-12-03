package b.test;

import org.ansj.library.UserDefineLibrary;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.ansj.AnsjTokenizer;

public class TestMain {

	public static void main(String[] args) {
		String string = "我觉得拉哈中文分词是一个不错的系统!";
//		UserDefineLibrary.insertWord("不错的系统", "userDefine", 1000);
		
		Tokenizer tokenizer = new AnsjTokenizer();
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
