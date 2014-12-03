package buaanlp.api.tokenizer.jieba;

import java.io.File;
import com.huaban.analysis.jieba.WordDictionary;

public class Stemmer {

	public void loadDict(String filePath){
	/**
	 *@parameter filePath String �û��Զ����ֵ��·��
	 *@return void
	 *@exception no write
	 **/
		try{
			WordDictionary.getInstance().loadUserDict(new File(filePath));
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
