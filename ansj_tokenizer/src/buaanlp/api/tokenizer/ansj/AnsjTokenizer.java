package buaanlp.api.tokenizer.ansj;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.Token;

/**
 *@author 王耀华
 *@version 0.1
 *封装 ansj 为分词api
 * */
public class AnsjTokenizer extends Tokenizer {
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
		List<Term> parse = null;
		try{
			parse = ToAnalysis.parse(input);
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		String [] result = new String[parse.size()];
		try{
			int resultIndex=0;
			for(int i=0;i<parse.size();i++){
				String tmp = parse.get(i).getName();
				if (tmp.equals(" ")==false && tmp.equals("")==false && tmp.equals(null)==false)
					result[resultIndex++]=tmp;
			}
		}catch(Exception ex){
			ex.printStackTrace();			
		}
		return  result;
		/*说明: t.getNatrue().natureStr 是 获取词性 ; t.getName().trim()是获取词语内容
		 *List<Term> parse2 = NlpAnalysis.parse(input);
		 *List<Term> parse3 = IndexAnalysis.parse(input);
		 *List<Term> parse4 = BaseAnalysis.parse(input);
		 * */
	}
	
	
	/**
	 *@parameter input String 待切分的句子
	 *@return token Token [] 分词后的结果
	 *@exception no write
	 * */
	public Token[] tokenizeWithPostag(String input){
		if(input == null) 
			return null;
		input = input.replaceAll(" ", "");
		input = input.replaceAll("\t", "");
		if(input.length() == 0)
			return null;
		List<Term> parse = null;
		try{
			parse = ToAnalysis.parse(input);			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		//对于 空 的或者 是空格的 分词 直接过滤掉，生成 token的个数 为实际的个数
		Token [] token = new Token[parse.size()];
		try{
			int index=0;
			for (Term w : parse){
				if(w.getName().equals(" ")==false && w.getName().equals("")==false && w.getName().equals(null)==false)
					token[index++] = new Token (w.getName(),w.getNatrue().natureStr);
			}
		}catch(Exception ex){
				ex.printStackTrace();
		}
		return token;		
	}
}
//容错的考虑：对输入字符串预处理，除去空格制表符等，判断是否为空