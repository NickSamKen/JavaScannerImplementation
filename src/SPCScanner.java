public class SPCScanner {
    //inputs string
    keyWords[] tokenKeyWord = keyWords.values();
    public keyWords strInput(String firstToken)
    {
        //basic regex filter to discern whether the token is numerical
        if (firstToken.matches("^-?\\d+(\\.\\d+)?$"))
        {
            keyWords.DOUBLE_LIT.setLexemes(firstToken);
            return keyWords.DOUBLE_LIT;
        }
        //basic regex filter to discern whether the token has acceptation lexica rules for a variable or keyword
        if (firstToken.matches("^[a-zA-Z_$][a-zA-Z_$0-9]*$")) {
            if(firstToken.matches("^[a-z]*$"))
            {
                for (keyWords keyword : tokenKeyWord )
                {
                    if(keyword.getLexemes() == firstToken)
                    {
                        return keyword;
                    }
                }
                keyWords.IDENTIFIERS.setLexemes(firstToken);
                return keyWords.IDENTIFIERS;
            }
        }
        if(firstToken == "*")
        {
            return keyWords.MULTIPLICATION_OP;
        }
        if(firstToken == "=")
        {
            return keyWords.ASSIGNMENT_OP;
        }
        else
        {
            keyWords.UNKNOWN_KEYWORD.setLexemes(firstToken);
            System.out.println("Encountered an unknown KEYWORD");
            return keyWords.UNKNOWN_KEYWORD;
        }
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
