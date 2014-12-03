package b.test;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.jieba.JiebaTokenizer;
import buaanlp.api.tokenizer.jieba.Stemmer;

public class TestMain {

	public static void main(String[] args) {
		String string = "�Ҿ���Ansj���ķִ���һ�������ϵͳ!";
		String usrPath = "userDic.dic";
		new Stemmer().loadDict(usrPath);
		//�û�����Զ��ʵ�
		
		Tokenizer tokenizer = new JiebaTokenizer();
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
