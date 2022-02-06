import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * InfijoAPostfijoManager
 */
public class InfijoAPostfijoManager {

    FileManager fm;
    String[] infixInputs;
    InfijoAPostfijo ip;
    ArrayList<LinkedList<Character>> postfixExpressions;
    EvaluadorPostfijo ep;

    public InfijoAPostfijoManager() {
        this.fm = new FileManager();
        this.ip = new InfijoAPostfijo();
        this.postfixExpressions = new  ArrayList<LinkedList<Character>>();
        this.ep = new EvaluadorPostfijo();
    }

    public void loadInputs(String path) throws FileNotFoundException {
        ArrayList<String> infixInputs = new ArrayList<String>();
        for (String infixInput : fm.readFileToStringArray(path)) {
            infixInputs.add(infixInput);
        }
        this.infixInputs = infixInputs.toArray(new String[infixInputs.size()]);
    }

    private void convertirExpresiones() {
        for (String string : infixInputs) {
            postfixExpressions.add(ip.convertir(string));
        }
    }

    public void writeOutputs() throws IOException{
        this.convertirExpresiones();
        ArrayList<String> outputs = new ArrayList<String>();
        for (LinkedList<Character> iterable_element : postfixExpressions) {
            String expr = "Expr:";
            for (Character chara : iterable_element) {
                expr += " " + chara.toString();
            }
            //System.out.println(expr);
            //System.out.println(ep.evaluarExpresionPostfija(iterable_element));
            String outString = expr + "; Eval: " + ep.evaluarExpresionPostfija(iterable_element);
            
            outputs.add(outString);

            fm.writeFileFromStringArray(outputs.toArray(new String[outputs.size()]));
        }
    }
}