package regexp;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PareNoelRegexp {
    private static final String PATH_FITXER = "src/regexp/santako.txt";


    public static void main(String[] args) {
        //Pattern pareNoel = Pattern.compile("([\\*{1}])([\\<\\]\\:\\-\\[DOo\\]])");
        Pattern pareNoel = Pattern.compile("\\*<]:-DOo");
        Pattern ren = Pattern.compile(">:o\\)");
        Pattern follet = Pattern.compile("[^\\*]<]:-D");

        BufferedReader br = null;
        FileReader fr = null;
        int numPN = 0;
        int numRen = 0;
        int numF = 0;

        try {
            fr = new FileReader(PareNoelRegexp.PATH_FITXER);
            br = new BufferedReader(fr);
            String line = br.readLine();
            while(line != null) {
                Matcher mpn = pareNoel.matcher(line);
                Matcher mren = ren.matcher(line);
                Matcher mfollet = follet.matcher(line);

                while (mpn.find()) numPN++;
                while (mren.find()) numRen++;
                while (mfollet.find()) numF++;
                if(numPN > 0) System.out.print(" Pare Noel (" + numPN + ")");
                if(numRen > 0) System.out.print(" Ren (" + numRen + ")");
                if(numF > 0) System.out.print(" Follet (" + numF + ")");
                line = br.readLine();
                numPN = numF = numRen = 0;
                System.out.println();
            }

        }catch (IOException e) {
            e.getStackTrace();
        }

    }


}
