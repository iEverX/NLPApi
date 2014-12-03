package buaanlp.api.tokenizer;

public abstract class Tokenizer {
    public abstract String[] tokenize(String input);
    public abstract Token[] tokenizeWithPostag(String input);
} 
