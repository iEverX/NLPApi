package buaanlp.api.tokenizer.jieba;

import java.util.List;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

/**
 *@author ��ҫ��
 *@version 0.1
 *��װ jieba Ϊ�ִ�api
 * */
public class JiebaTokenizer extends Tokenizer {
	
	/**
	 *@parameter input String ���зֵľ���
	 *@return result String [] �ִʺ�Ľ��
	 *@exception no write
	 * */
	public String[] tokenize(String input){
		if(input == null) 
			return null;
		input = input.replaceAll(" ", "");
		input = input.replaceAll("\t", "");
		if(input.length() == 0)
			return null;
		
		JiebaSegmenter wordCutter = new JiebaSegmenter();
		List<SegToken> wordcutter =null;
		try{
			wordcutter = wordCutter.process(input, JiebaSegmenter.SegMode.SEARCH);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		String[] result= new String[wordcutter.size()];
		try{
			int index=0;
			for (SegToken w: wordcutter){
				result[index++] = w.word.getToken();
			}
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		return result;
	}
	
	
	/**
	 *@parameter input String ���зֵľ���
	 *@return result String [] �ִʺ�Ľ��
	 *@exception no write
	 * */
	public Token[] tokenizeWithPostag(String input){
		
		
		if(input == null) 
			return null;
		input = input.replaceAll(" ", "");
		input = input.replaceAll("\t", "");
		if(input.length() == 0)
			return null;
		
		JiebaSegmenter wordCutter = new JiebaSegmenter();
		List<SegToken> wordcutter =null;
		try{
			wordcutter = wordCutter.process(input, JiebaSegmenter.SegMode.SEARCH);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		Token [] token = new Token[wordcutter.size()];
		try{
			int index=0;
			for (SegToken w: wordcutter){
				token[index++] = new Token(w.word.getToken(),w.word.getTokenType());
			}
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		return token;
	}
}
//�ݴ�Ŀ��ǣ��������ַ���Ԥ������ȥ�ո��Ʊ���ȣ��ж��Ƿ�Ϊ��
