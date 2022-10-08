//The subset of Keywords involved in squareprog.scl
public enum keyWords //table of KEYWORDS for the scanner
{
    IMPORT(1, "input"),
    FORWARD(2, "forward"),
    DECLARATION(3, "declaration"),
    VARIABLES(4, "variables"),
    IDENTIFIERS(5, ""),
    DEFINE(6, "define"),
    CONSTANTS(7, "constants"),
    STRUCTURES(8, "structures"),
    OF(9, "of"),
    TYPE(10, "type"),
    BEGIN(11, "begin"),
    RETURN(12, "return"),
    PARAMETERS(14, "parameter"),
    DISPLAY(15, "display"),
    INPUT(16, "input"),
    ENDFUN(17, "endfun"),
    EXIT(18, "exit"),
    DOUBLE(19, "double"),
    STRING(20, "string"),
    IS(21, "is"),
    MULTIPLICATION_OP(22, "*"),
    ASSIGNMENT_OP(23, "="),
    DOUBLE_LIT(24, ""),
    UNKNOWN_KEYWORD(25,""); //This is a custom keyword that will return to the parser an that the scanner encountered an unknown token

    private String lexemes;
    private int KeywordNum;

    public int getKeywordNum() {
        return KeywordNum;
    }

    public String getLexemes() {
        return lexemes;
    }
    public void setLexemes(String lexemes)
    {
        this.lexemes = lexemes;
    }

    public void setKeywordNum(int KeywordNum)
    {
        this.KeywordNum = KeywordNum;
    }
    private keyWords(int KeywordNum, String lexemes)// Creates an object for each keyword.
    {
        this.KeywordNum = KeywordNum;
        this.lexemes = lexemes;
    }
}
