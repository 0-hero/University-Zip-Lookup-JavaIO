import java.io.IOException;
import java.io.FileReader;
import java.util.Scanner;

/* The input file has the format

MESIVTHA TIFERETH JERUSALEM OF AMERICA
10002
COLLEGE OF MOUNT SAINT VINCENT
10471
NEW YORK CHIROPRACTIC COLLEGE
13148
ST LAWRENCE UNIVERSITY
13617
SUNY BUFFALO STATE
14222
. . .
*/

public class UnivZipLookupProgram {
   public static void main(String[] args) throws IOException {
      Scanner in = new Scanner(System.in);

      LookupTable table = new LookupTable();
      FileReader reader = new FileReader("university.txt");
      table.read(new Scanner(reader));

      boolean more = true;
      while (more) {
         System.out.print("Lookup by (Z)ip, (U)niversity, (Q)uit? ");
         String cmd = in.nextLine();

         if (cmd.equalsIgnoreCase("Q"))
            more = false;
         else if (cmd.equalsIgnoreCase("Z")) {
            System.out.print("Enter Zipcode:");
            String z = in.nextLine();
            System.out.println("University in zip " + z + " = " + table.lookup_by_zip(z) + "\n");
         } else if (cmd.equalsIgnoreCase("U")) {
            System.out.print("Enter University:");
            String univ = in.nextLine();

            System.out.println("Zip of " + univ + " = " + table.lookup_by_university(univ.toUpperCase()) + "\n");
         }
      }
      in.close();
   }
}
