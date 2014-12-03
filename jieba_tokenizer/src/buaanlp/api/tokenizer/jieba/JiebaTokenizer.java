package buaanlp.api.tokenizer.jieba;

import java.util.List;

import buaanlp.api.tokenizer.Token;
import buaanlp.api.tokenizer.Tokenizer;

import com.huaban.analysis.jieba.JiebaSegmenter;
import com.huaban.analysis.jieba.SegToken;

/**
 *@author 王耀华
 *@version 0.1
 *封装 jieba 为分词api
 * */
public class JiebaTokenizer extends Tokenizer {
	
	/**
	 *@parameter input String 待切分的句子
	 *@return result String [] 分词后的结果
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
	 *@parameter input String 待切分的句子
	 *@return result String [] 分词后的结果
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
//容错的考虑：对输入字符串预处理，除去空格制表符等，判断是否为空
