import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    List<keyWords> object = new ArrayList<>();
    public static void main(String[] args) {
        SPCScanner scanner = new SPCScanner();
        List<keyWords> object = new ArrayList<>();
        String source = "import \"scl.h\"\n" +
                "\n" +
                "implementations\n" +
                "\n" +
                "function main is\n" +
                "variables\n" +
                "    define x1, of type double  \n" +
                "    define y1 of type double  \n" +
                "    define x2 of type double  \n" +
                "    define y2 of type double  \n" +
                "    define dx of type double  \n" +
                "    define dy of type double  \n" +
                "    define dist of type double   \n" +
                "begin\n" +
                "    input \"Enter value of x-coordinate of P1: \", x1\n" +
                "    input \"Enter value of y-coordinate of P1: \", y1\n" +
                "    display \"Coordinates of P1: \", x1, y1\n" +
                "    input \"Enter value of x-coordinate of P2: \", x2\n" +
                "    input \"Enter value of y-coordinate of P2: \", y2\n" +
                "    display \"Coordinates of P2: \", x2, y2\n" +
                "    set dx = x2 - x1\n" +
                "    set dy = y2 - y1\n" +
                "    display \"Values of horizontal and vertical distances: \", dx, dy\n" +
                "\tset dist = sqrt(dx^2 + dy^2 )\n" +
                "    display \"Distance between P1 and P2: \", dist\n" +
                "    exit      \n" +
                "endfun main";
        StringTokenizer st = new StringTokenizer(source," ,^()\"", true);
        while (st.hasMoreTokens()) {
            String lexemes = st.nextToken("  ,()^\n\t\"");
            if(!lexemes.matches("\\s+"))
            {
                object.add(scanner.strInput(lexemes));
            }
        }
        for (String identifiers : scanner.symbolTable) {
            System.out.print(identifiers + "  ");
        }

        System.out.print(object);

    }
}