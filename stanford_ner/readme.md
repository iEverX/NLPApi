# Standford NER

对Standford NER的封装，地址<http://nlp.stanford.edu/software/CRF-NER.shtml>

## 方法说明

* `public List<String[]> recognize(String input)`
  `public List<String[]> recognize(List《String> input)`
  `public List<String[]> recognize(String[] input)`
  返回input的识别结果，List的每个元素是<实体，类别>，只包含识别为实体的词
  input为分词的结果，如果为字符串，需要以空格分隔

## 使用说明

* NER的初始化许提供训练模型，模型路径作为参数传给Ner的构造函数。当前共有六个模型，可以通过NerClassfier类的常量进行选择（要求把模型放在工程根目录下的classfiers文件夹）
* src中的b.test.TestMain为例子，供参考


## 下载
jar包、模型下载地址：<http://pan.baidu.com/s/1mgJZ0hy#path=%252Fpublic%252FNLPApi%252Fstandford_ner>
其中：
* lib文件夹为需要的jar包
* ner.jar为本程序的编译版本
* clasifiers文件夹为模型，需要放在工程的根目录下