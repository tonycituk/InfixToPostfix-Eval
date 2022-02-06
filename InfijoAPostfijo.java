import java.util.Stack;
import java.util.LinkedList;

public class InfijoAPostfijo {
    private Stack<Character> p;
    private LinkedList<Character> postfija;

    public int prioridad(char valor) {
        switch (valor) {
            // case '(':
            // return 4;
            // case ')':
            // return 4;
            case '^':
                return 3;
            case '*':
                return 2;
            case '/':
                return 2;
            case '-':
                return 1;
            case '+':
                return 1;
        }
        return 0;
    }

    public int evaluaCaracter(char E) {
        if (E == ';') {
            return 5;
        } else if (E != '^' && E != '+' && E != '-' && E != '*' && E != '/' && E != ')' && E != '(') { // es un número
            return 1;
        } else if (E == '(') {
            return 2;
        } else if (E == ')') {
            return 3;
        } else { // Es un operador
            return 4;
        }
    }

    // cambiar el void y que retorne la lista
    public LinkedList<Character> convertir(String expresion) {

        p = new Stack<Character>();
        postfija = new LinkedList<Character>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);
            switch (evaluaCaracter(c)) {

                case 1: // número
                    // System.out.println("Caracter evaluado =" + c + " valor de evaluacion:" +
                    // evaluaCaracter(c));
                    postfija.addLast(c);
                    break;
                case 2: // paréntesis izquierdo (
                    // System.out.println("Caracter evaluado =" + c + " valor de evaluacion:" +
                    // evaluaCaracter(c));
                    p.push(c);
                    break;
                case 3: // paréntesis derecho )
                    // System.out.println("Caracter evaluado =" + c + " valor de evaluacion:" +
                    // evaluaCaracter(c));
                    while (p.isEmpty() == false && p.peek() != '(') {
                        postfija.addLast(p.pop());
                    }
                    try {
                        if (p.peek() == '(') {
                            p.pop();
                        }
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    break;
                case 4: // operador
                    // System.out.println("Caracter evaluado =" + c + " valor de evaluacion:" +
                    // evaluaCaracter(c));
                    while (p.isEmpty() == false && prioridad(p.peek()) >= prioridad(c)) {
                        postfija.addLast(p.pop());
                    }
                    p.push(c);
                    break;
                case 5:
                    break;

            }
            // System.out.println("POSTFIA " + postfija.toString());
            // System.out.println("PILA :" + p.toString());

        }
        while (!p.isEmpty()) {
            // System.out.print(p.peek());
            postfija.addLast(p.pop());
        }

        // String w = postfija.toString();
        // System.out.println("POSTFIA " + w);
        return postfija;
    }

}