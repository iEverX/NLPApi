# Jieba Tokenizer

对jieba-analysis的封装，其github地址为<https://github.com/huaban/jieba-analysis>

## 方法说明

* `public String[] tokenize(String input)`
  返回input的分词结果，只有词无其他属性
*  `public Token[] tokenizeWithPostag(String input)`
  返回input的分词结果，包括词和词性标注

## 使用说明

* lib中为jieba-analysis必须的jar，使用源码或者jar都需要引用其中的jar
* userDic.dic为用户词典，建议使用UTF-8编码
* 通过`new Stemmer().loadDict(dictPath)`来加载用户词典
* src中的b.test.TestMain为例子，供参考
