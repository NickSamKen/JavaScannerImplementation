import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        List<Object> object = new List<Object>();
        StringTokenizer st = new StringTokenizer(stringSentance);
        while (st.hasMoreTokens()) {
            //make sure input is valid
            String Lexemes = st.nextToken();
            object.add(SPCScanner(Lexemes));
        }
    }
}