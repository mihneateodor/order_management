package dao;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

/**
 * Clasa care realizeaza metodele de afisare in tabele folosind tehnica de Reflection.
 *
 * @author Circiu Mihnea Teodor {@literal <circiumihnea @ gmail.com>}
 * @since April 18th 2021
 */
public class ReflectionClass {

    /**
     * Metoda care afiseaza intr-un JTable toate inregistrarile ale unui tabel reprezentat printr-o lista. Metoda este folosita in contextul
     * operatiei de "VIEW ALL".
     * @param lista Lista de tip obiect care contine inregistrarile tabelului.
     * @param tabel JTabel care va contine informatiile cerute.
     */
    public static void reflectionMethod(List<Object> lista, JTable tabel) {
        if (!(lista.isEmpty())) {
            DefaultTableModel tableModel = new DefaultTableModel();
            for (Field camp : lista.get(0).getClass().getDeclaredFields()) {
                camp.setAccessible(true);
                Vector vec = new Vector();
                for (Object obiect : lista) {
                    Object valoare;
                    try {
                        valoare = camp.get(obiect);
                        vec.add(valoare);
                    } catch (IllegalArgumentException e) {
                    } catch (IllegalAccessException e) {
                    }
                }
                tableModel.addColumn(camp.getName(), vec);
            }
            tabel.setModel(tableModel);
        }
    }

    /**
     * Metoda care afiseaza intr-un JTable obiectul cerut in parametru. Metoda este folosita in contextul opeatiei de "FIND" pe un singur
     * obiect/inregistrare.
     * @param obiect Obiect de orice tip, ex "Persoana","Produs","Comanda".
     * @param tabel Tabelul in care se va afisa rezultatul.
     */
    public static void reflectionMethodOneObject(Object obiect, JTable tabel) {
        DefaultTableModel tableModel = new DefaultTableModel();
        Object valoare=null;
        for (Field camp : obiect.getClass().getDeclaredFields()) {
            camp.setAccessible(true);
            try {
                valoare = camp.get(obiect);
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            }
            tableModel.addColumn(camp.getName(), new Object[] {valoare});
        }
        tabel.setModel(tableModel);
    }
}
