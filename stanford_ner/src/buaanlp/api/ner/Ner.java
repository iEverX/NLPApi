package buaanlp.api.ner;

import edu.stanford.nlp.ie.AbstractSequenceClassifier;
import edu.stanford.nlp.ie.crf.CRFClassifier;
import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Ner {
    private AbstractSequenceClassifier<CoreLabel> classifier;

    public Ner(String serializedClassifier) throws IOException, ClassNotFoundException {
        classifier = CRFClassifier.getClassifier(serializedClassifier);
    }

    public Ner() throws IOException, ClassNotFoundException {
    	this(NerClassifier.CnDistsim);
    }

    public List<String[]> recognize(String sentence) {
        List<String[]> result = new ArrayList<>();
        List<List<CoreLabel>> out = classifier.classify(sentence);

        for (List<CoreLabel> s : out) {
            for (CoreLabel w : s) {
                String label = w.get(CoreAnnotations.AnswerAnnotation.class);
                if (!label.equals("O")) {
                    result.add(new String[]{w.word(), label});
                }
            }
        }
        return result;
    }
    
    public List<String[]> recognize(List<String> input) {
    	return recognize(makeStr(input.toArray(new String[0])));
    }
    
    public List<String[]> recognize(String[] input) {
    	return recognize(makeStr(input));
    }
    
    private static String makeStr(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (String t : input) {
            builder.append(t);
            builder.append(" ");
        }
        return builder.substring(0, builder.length() - 1);
    }
}
