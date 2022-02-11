package start;


import controller.Controller;
import view.ComandaView;
import view.PersoanaView;
import view.ProdusView;
import view.StartView;

import java.util.logging.Logger;
/**
 * Aceasta este clasa care porneste propriu-zis aplicatia.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 17th 2021
 */
public class Main {
    /**
     * Logger-ul pentru conexiunea la baza de date.
     */
    protected static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    /**
     * Metoda main care porneste aplicatia.
     * @param args Sir de argumente pentru rularea functiei main.
     */
    public static void main(String[] args) {
        StartView startView= new StartView();
        startView.setVisible(true);
        PersoanaView persoanaView= new PersoanaView();
        ProdusView produsView = new ProdusView();
        ComandaView comandaView = new ComandaView();
        Controller controller=new Controller(startView,persoanaView,produsView,comandaView);
    }
}
