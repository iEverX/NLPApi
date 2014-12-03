package buaanlp.api.tokenizer;

public class Token {
	private String word;
    private String postag;

    public Token(String word, String postag) {
        this.word = word;
        this.postag = postag;
    }

    public String getWord() {
        return word;
    }

    public String getPostag() {
        return postag;
    }
}
