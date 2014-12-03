package buaanlp.api.tokenizer.ansj;

import java.util.List;

import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.ToAnalysis;

import buaanlp.api.tokenizer.Tokenizer;
import buaanlp.api.tokenizer.Token;

/**
 *@author ��ҫ��
 *@version 0.1
 *��װ ansj Ϊ�ִ�api
 * */
public class AnsjTokenizer extends Tokenizer {
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
		/*˵��: t.getNatrue().natureStr �� ��ȡ���� ; t.getName().trim()�ǻ�ȡ��������
		 *List<Term> parse2 = NlpAnalysis.parse(input);
		 *List<Term> parse3 = IndexAnalysis.parse(input);
		 *List<Term> parse4 = BaseAnalysis.parse(input);
		 * */
	}
	
	
	/**
	 *@parameter input String ���зֵľ���
	 *@return token Token [] �ִʺ�Ľ��
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
		//���� �� �Ļ��� �ǿո�� �ִ� ֱ�ӹ��˵������� token�ĸ��� Ϊʵ�ʵĸ���
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
//�ݴ�Ŀ��ǣ��������ַ���Ԥ������ȥ�ո��Ʊ���ȣ��ж��Ƿ�Ϊ��