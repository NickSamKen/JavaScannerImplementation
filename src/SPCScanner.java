import java.security.Key;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

//The subset of Keywords involved in squareprog.scl
enum keyWords //table of KEYWORDS for the scanner
{
    IMPORT(1,"input"),
    FORWARD(2,"forward"),
    DECLARATION(3,"declaration"),
    VARIABLES(4,"variables"),
    IDENTIFIERS(5,"identifiers"),
    DEFINE(6, "define"),
    CONSTANTS(7,"constants"),
    STRUCTURES(8,"structures"),
    OF(9,"of"),
    TYPE(10,"type"),
    BEGIN(11,"begin"),
    RETURN(12,"return"),
    TYPE(13,"type"),
    PARAMETERS(14,"parameter"),
    DISPLAY(15,"display"),
    INPUT(16,"input"),
    ENDFUN(17,"endfun"),
    EXIT(18,"exit"),
    DOUBLE(19,"double"),
    STRING(20,"string"),
    IS(21,"is"),
    MULTIPLICATION_OP(22,"*"),
    ASSIGNMENT_OP(23,"="),
    DOUBLE_LIT(24,"^-?\\d+(\\.\\d+)?$");

    private String lexemes;
    private int KeywordNum;

    private keyWords(int KeywordNum, String lexemes) {
        this.KeywordNum = KeywordNum ;
        this.lexemes = lexemes ;
    }
}



public class SPCScanner {
    //inputs string
    keyWords tokenKeyWord;
    public tokenObject strInput(String firstToken) {
            //basic regex filter to discern whether the token is numerical
            if (firstToken.matches("^-?\\d+(\\.\\d+)?$")) {

            }
            //basic regex filter to discern whether the token has acceptation lexica rules for a variable or keyword
            if (firstToken.matches("^[a-zA-Z_$][a-zA-Z_$0-9]*$")) {
                wordAnalyzer(firstToken);
            } else { // still working on a way to pass the comments through the lexical analyser but first and foremost I need to prevent the scanner from exploding if encountering a comment.
                if (firstToken == "//") {
                    return firstToken;
                }
                else {
                    otherAnalyzer(firstToken);
                }
            }
            return token;
        }
    }
    /*public void wordAnalyzer(String numberString)
    {
        if (numberString.matches("^[a-z]*$")) {
            return tokenCase(numberString);
        }
        else {

        }
    }

    public void otherAnalyzer(String singleString)
    {
        token.
    }

    public void KeyWordTable(String numberString) {
        switch (numberString.toUpperCase()) {
            case "IMPORT":
                token.setToken(numberString, 0);
                break;
            case "FORWARD":
                token.setToken(numberString, 1);
                break;
            case "DECLARATION":
                token.setToken(numberString, 2);
                break;
            case "VARIABLES":
                token.setToken(numberString, 3);
                break;
            case "DEFINE":
                token.setToken(numberString, 4);
                break;
            case "CONSTANTS":
                token.setToken(numberString, 5);
                break;
            case "STRUCTURES":
                token.setToken(numberString, 6);
                break;
            case "OF":
                token.setToken(numberString, 7);
                break;
            case "TYPE":
                token.setToken(numberString, 8);
                break;
            case "BEGIN":
                token.setToken(numberString, 9);
                break;
            case "RETURN":
                token.setToken(numberString, 10);
                break;
            case "PARAMETERS":
                token.setToken(numberString, 11);
                break;
            case "DISPLAY":
                token.setToken(numberString, 12);
                break;
            case "INPUT":
                token.setToken(numberString, 13);
                break;
            case "ENDFUN":
                token.setToken(numberString, 14);
                break;
            case "EXIT":
                token.setToken(numberString, 15);
                break;
            case "STRING":
                token.setToken(numberString, 16);
                break;
            case "IS":
                token.setToken(numberString, 17);
                break;
            default:
                token.setToken(numberString, 18);

        }
    }
}*/

class tokenObject
{
    String lexemes;
    int KEYWORD;

    public tokenObject()
    {
    }
    public void setToken(String lexeme, int KEYWORD)
    {
        this.lexemes = lexeme;
        this.KEYWORD = KEYWORD;
    }
    public String getLexeme()
    {
        return lexemes;
    }
    public int getToken()
    {
        return KEYWORD;
    }

}
