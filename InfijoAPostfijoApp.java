import java.io.FileNotFoundException;
import java.io.IOException;

public class InfijoAPostfijoApp {

    InfijoAPostfijoManager ipm = new InfijoAPostfijoManager();

    public void init(String relativePath) {
        try {
            ipm.loadInputs(relativePath);
            ipm.writeOutputs();
        } catch (FileNotFoundException e) {
            System.err.println("¡ERROR!\nEl archivo no fue encontrado.\nRevisa que la ruta ingresada sea la correcta.");
        } catch (IOException e) {
            System.err.println("¡ERROR!\nHubo error guardando el archivo. Inténtalo de nuevo.");
            
        }
    }

    public static void main(String[] args) {
        new InfijoAPostfijoApp().init(args[0]);
    }

}
