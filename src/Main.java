import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        SPCScanner scanner = new SPCScanner();
        List<keyWords> object = new ArrayList<keyWords>();
        String source = "";
        StringTokenizer st = new StringTokenizer(source);
        while (st.hasMoreTokens()) {

            object.add(scanner.strInput(st.nextToken()));
        }

    }
}