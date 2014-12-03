# Ansj Tokenizer

对ansj_seg的封装，其github地址为<https://github.com/NLPchina/ansj_seg>

## 方法说明

* `public String[] tokenize(String input)`
  返回input的分词结果，只有词无其他属性
*  `public Token[] tokenizeWithPostag(String input)`
  返回input的分词结果，包括词和词性标注

## 使用说明

* lib中为ansj_seg必须的jar，使用源码或者jar都需要引用其中的两个jar
* library中为用户词典，词典的编码**必须**为UTF-8，可通过library.properties修改词典路径
  * ambiguity.dic：消歧词典
  * userLibrary/default.dic：用户自定义词典，格式为<词, 词性, 词频>
* src中的b.test.TestMain为例子，供参考
  * `UserDefineLibrary.insertWord("不错的系统", "userDefine", 1000)`为动态添加自定义词
