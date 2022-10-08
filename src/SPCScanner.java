import java.util.ArrayList;
import java.util.List;
public class SPCScanner {
    keyWords[] tokenKeyWord = keyWords.values();
    public List<String> symbolTable = new ArrayList<>();//This is the symbol table
    public keyWords strInput(String firstToken)
    {
        //basic regex filter to discern whether the token is
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
                    if(keyword.getLexemes().equals(firstToken))
                    {
                        return keyword;
                    }
                }
                keyWords.IDENTIFIERS.setLexemes(firstToken);
                if(!symbolTable.contains(firstToken))
                {
                    symbolTable.add(firstToken);
                }
                return keyWords.IDENTIFIERS;

            }
            keyWords.IDENTIFIERS.setLexemes(firstToken);
            if(!symbolTable.contains(firstToken))
            {
                symbolTable.add(firstToken);
            }
            return keyWords.IDENTIFIERS;
        }
        for (keyWords keyword : tokenKeyWord )
        {

            if(keyword.getLexemes().equals(firstToken))
            {
                return keyword;
            }
        }
        keyWords.UNKNOWN_KEYWORD.setLexemes(firstToken);
        System.out.println("Encountered an unknown KEYWORD " + keyWords.UNKNOWN_KEYWORD.getLexemes());
        return keyWords.UNKNOWN_KEYWORD;
    }
}
