import java.util.Scanner;

public class isbn {
    public static void main(String[] args) {
        System.out.println("Geben Sie eine ISBN-Nummer ein");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
    }

    public static String entferneBindestriche(String arg) {
        return arg.replace("-", "");

    }

    public static boolean ueberpruefen(String args) {
        String s = entferneBindestriche(args);
        boolean y = laengeueberpruefen(s);
        boolean x = buchstabenueberpruefen(s);
        boolean z = praefixueberpruefen(s);
        boolean a = falschePruefziffer(s);
        return (x && y && z && a);

    }

    public static boolean laengeueberpruefen(String args) {
        if (args.length() == 13) {
            return true;
        } else {
            return false;
        }
    }


    public static boolean buchstabenueberpruefen(String args) {
        int laenge = args.length();
        for (int i = 0; i < laenge; i++) {
            char position = args.charAt(i);
            if (position > '9' || position < '0') {
                return false;
            }
        }
        return true;
    }

    public static boolean praefixueberpruefen(String args) {
        for (int i = 0; i < 3; i++) {
            if (args.length() > 0) {
                char positioneins = args.charAt(0);
                char positionzwei = args.charAt(1);
                char positiondrei = args.charAt(2);
                if (positioneins == '9' && positionzwei == '7' && (positiondrei == '8' || positiondrei == '9')) {
                    return true;

                } else {
                    return false;
                }
            }
        }
        return false;
    }

    public static boolean falschePruefziffer(String args) {
        int laenge = args.length();
        int summe = 0;
        if (laenge > 0) {
            for (int i = 0; i < laenge - 1; i++) {
                char aktuellesZeichen = args.charAt(i);
                int zahl = Character.getNumericValue(aktuellesZeichen);
                int positionDerZahl = i + 1;
                if (positionDerZahl % 2 == 0) {
                    summe = summe + zahl * 3;
                } else {
                    summe = summe + zahl;
                }
            }

            int richtigePruefziffer = (10 - ((summe) % 10)) % 10;
            char elementPosition12 = args.charAt(args.length() - 1);
            int vorhandenePruefziffer = Character.getNumericValue(elementPosition12);
            if (richtigePruefziffer == vorhandenePruefziffer) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
}

