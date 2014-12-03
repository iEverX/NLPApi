package buaanlp.api.tokenizer.jieba;

import java.io.File;
import com.huaban.analysis.jieba.WordDictionary;

public class Stemmer {

	public void loadDict(String filePath){
	/**
	 *@parameter filePath String 用户自定义字典的路径
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
