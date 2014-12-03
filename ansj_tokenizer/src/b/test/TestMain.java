package b.test;

import org.ansj.library.UserDefineLibrary;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.ansj.AnsjTokenizer;

public class TestMain {

	public static void main(String[] args) {
		String string = "�Ҿ����������ķִ���һ�������ϵͳ!";
//		UserDefineLibrary.insertWord("�����ϵͳ", "userDefine", 1000);
		
		Tokenizer tokenizer = new AnsjTokenizer();
		String [] result = tokenizer.tokenize(string);
		for (String w : result)
			System.out.println(w);
		//����ִʽ��
		System.out.println("----------------");
		Token[] resultWithPostag = tokenizer.tokenizeWithPostag(string);
		for (Token w: resultWithPostag)
			System.out.println(w.getWord()+"	"+w.getPostag());
		//����ִʽ�������
	}
}
