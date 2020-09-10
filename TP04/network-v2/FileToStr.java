import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Classe FileToStr reprise des TP/TD précedent.
 *
 * @author Kastriot Sahiti
 * @version 2020-05-16
 */
public class FileToStr {
    //Variables de la classe FileToStr
    private static final int EOF = -1;
    private static final String DELIMITEURS_LIGNES = "\n\r";
    private static final String DELIMITEURS_DONNEES = ";\n\r\t\f";
    private static final String DELIMITEURS_MOTS = " .,;:-+*<>%/='\"()[]{}|!?\n\r\t\f0123456789";

    /**
     * Constructeur public
     */
    private FileToStr() {
    }

    /**
     * Méthode permettant de lire un fichier et d'en retourner son contenu sous forme de String
     * @param fileName  nom du fichier à lire
     * @return          une String
     */
    private static String read(String fileName) {
        try {
            BufferedInputStream in = new BufferedInputStream(new FileInputStream(fileName));
            StringBuilder b = new StringBuilder(in.available());

            for(int c = in.read(); c != -1; c = in.read()) {
                b.append((char)c);
            }

            in.close();
            return b.toString();
        } catch (FileNotFoundException var4) {
            var4.printStackTrace();
            return "";
        } catch (IOException var5) {
            var5.printStackTrace();
            return "";
        }
    }

    /**
     * Méthode permettant de lire un fichier et de retourner un tableau bidimensionnel représentant les données
     * @param fileName  nom du fichier
     * @return          un tableau bidimensionnel
     */
    public static String[] lireCsv(String fileName) {
        String str = read(fileName);
        new ArrayList();
        StringTokenizer sT = new StringTokenizer(str, "\n\r");
        String[] data = new String[sT.countTokens()];

        for(int cpt = 0; sT.hasMoreTokens(); ++cpt) {
            data[cpt] = sT.nextToken();
        }

        return data;
    }
}