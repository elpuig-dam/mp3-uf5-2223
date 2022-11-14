package regexp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    Exercici usant els grups de les expressions regulars
 */
public class PareNoelRegexp2 {
    private static final String PATH_FITXER = "src/regexp/santako.txt";

    public static void main(String[] args) {
        Pattern pareNoel = Pattern.compile("(\\*<]:-DOo)|(>:o\\))|([^\\*]<]:-D)");

        BufferedReader br = null;
        FileReader fr = null;
        int numPN = 0;
        int numRen = 0;
        int numF = 0;

        try {
            fr = new FileReader(PareNoelRegexp2.PATH_FITXER);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null) {
                Matcher mpn = pareNoel.matcher(line);
                while (mpn.find()) {
                    if(mpn.group(1) != null) numPN++;
                    if(mpn.group(2) != null) numRen++;
                    if(mpn.group(3) != null) numF++;
                }
                if(numPN>0) System.out.printf(" Pare Noel (%d)",numPN);
                if(numRen>0) System.out.printf(" Ren (%d)",numRen);
                if(numF>0) System.out.printf(" Follet(%d)",numF);

                line = br.readLine();
                numPN = numF = numRen = 0;
                System.out.println();
            }

        }catch (IOException e) {
            e.getStackTrace();
        }

    }


}
