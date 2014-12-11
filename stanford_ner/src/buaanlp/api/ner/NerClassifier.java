package buaanlp.api.ner;

public interface NerClassifier {
	static String CnDistsim = "classifiers/chinese.misc.distsim.crf.ser.gz";
	static String CnNoDistsim = "classifiers/chinese.misc.nodistsim.crf.ser.gz";
	static String EnAll3 = "classifiers/english.all.3class.distsim.crf.ser.gz";
	static String EnConall4 = "classifiers/english.conll.4class.distsim.crf.ser.gz";
	static String EnMuc7 = "classifiers/english.muc.7class.distsim.crf.ser.gz";
	static String EnNowiki3 = "classifiers/english.nowiki.3class.distsim.crf.ser.gz";
}
