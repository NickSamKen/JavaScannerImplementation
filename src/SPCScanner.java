import java.security.Key;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

//The subset of Keywords involved in squareprog.scl
/*enum keyWords
{
    IMPORT, //Keyword: IMPORT : # 0
    FORWARD, //Keyword: KE
    DECLARATION, //Keyword
    VARIABLES, //Keyword always singular, if not return an error
    IDENTIFIERS, //identifier
    DEFINE, //Keyword
    CONSTANTS, //Keyword
    STRUCTURES, //Keyword
    OF, //Keyword
    TYPE, //Keyword
    BEGIN, //Keyword
    RETURN, //Keyword
    TYPE, //Keyword
    PARAMETERS, //Keyword
    DISPLAY, //Keyword
    INPUT, //Keyword
    ENDFUN, // endfun Keyword ENDFUN
    EXIT, //exit Keyword EXIT
    DOUBLE, // double Keyword DOUBLE
    STRING, //Keyword STRING
    IS, //Keyword IS
    MULTIPLICATION_OP, // "*" Operator MULTI_OP
    ASSIGNMENT_OP; // "=" Operator ASSIGN_OP
    STRING_LIT
}
*/


public class SPCScanner {
    //inputs string

    public String strInput(String stringSentance) {
        String token = "";
        StringTokenizer st = new StringTokenizer(stringSentance);
        while (st.hasMoreTokens()) {
            //make sure input is vali
            String firstToken = st.nextToken();
            //basic regex filter to discern whether the token is numerical
            if (firstToken.matches("^-?\\d+(\\.\\d+)?$")) {
                token = "double";
            }
            //basic regex filter to discern whether the token has acceptation lexica rules for a variable or keyword
            if (firstToken.matches("^[a-zA-Z_$][a-zA-Z_$0-9]*$")) {
                token = wordAnalyzer(firstToken);
            } else { // still working on a way to pass the comments through the lexical analyser but first and foremost I need to prevent the scanner from exploding if encountering a comment.
                if (firstToken == "//") {
                    while (st.hasMoreTokens()) {
                        firstToken = firstToken + " " + st.nextToken();
                    }
                    return firstToken;
                }
                if (firstToken == "/*") {
                    while (st.nextToken() != "*/" || st.hasMoreTokens()) {
                        st.nextToken();
                    }
                } else {
                    return otherAnalyzer(firstToken);
                }
            }
            return ""; //end of statement
        }
    }
    public String wordAnalyzer(String numberString)
    {
        if (numberString.matches("^[a-z]*$")) {
            return tokenCase(numberString);
        }
        else {
            return "name";
        }
    }

    public String otherAnalyzer(String singleString)
    {
        return token;
    }

    public String tokenCase(String numberString) {
        tokenObject token = new tokenObject();
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
                    return "identifiers";
                    token.setToken(numberString, 18);

        }
    }
}

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
