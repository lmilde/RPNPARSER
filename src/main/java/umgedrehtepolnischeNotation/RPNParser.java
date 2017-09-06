package umgedrehtepolnischeNotation;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNParser {

    boolean parser(String args) {
        boolean x = ungueltigeZeichen(args);
        boolean z = rechner(args);
        return (x && z);
    }

    private boolean ungueltigeZeichen(String args) {
        int laenge = args.length();
        for (int i = 0; i < laenge; i++) {
            char position = args.charAt(i);
            if (!Character.isDigit(position) && position != '+' && position != '*' && position != '/' && position != '-' && position != ' ' && position != '!' && position != 'f' && position != '°' && position != '§' && position != '%') {
                return false;
            }
        }
        return true;
    }


    private String[] stringSplitten(String args) {
        String[] aufteilen = args.split(" ");
        return aufteilen;
    }

    private boolean rechner(String args) {
        Stack<Double> stack = new Stack<Double>();
        String[] aufgeteiltesArray = stringSplitten(args);
        double a = 0;
        double b = 0;
        double ergebnis = 0;

        int laengeDesArrays = aufgeteiltesArray.length;
        for (int i = 0; i < laengeDesArrays; i++) {
            if (!aufgeteiltesArray[i].equals("+") && !aufgeteiltesArray[i].equals("*") && !aufgeteiltesArray[i].equals("/") && !aufgeteiltesArray[i].equals("-") && !aufgeteiltesArray[i].equals("!") && !aufgeteiltesArray[i].equals("f") && !aufgeteiltesArray[i].equals("°") && !aufgeteiltesArray[i].equals("§") && !aufgeteiltesArray[i].equals("%")) {
                stack.push((double) i);
            }

            if (aufgeteiltesArray[i].equals("+")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a + b;
                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("*")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a * b;

                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("/")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a / b;

                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("-")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a - b;

                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("!")) {
                try {
                    a = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                double fakultaet = 1;
                while (a > 1) {
                    fakultaet = fakultaet * a;
                    a = a - 1;
                }
                stack.push(fakultaet);
            }

            if (aufgeteiltesArray[i].equals("f")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                double zaehler = a + b;
                double nenner = 2;
                ergebnis = zaehler / nenner;

                stack.push(ergebnis);
            }
            if (aufgeteiltesArray[i].equals("°")) {
                try {
                    a = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a * a;

                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("§")) {
                try {
                    a = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = Math.sqrt(a);

                stack.push(ergebnis);
            }

            if (aufgeteiltesArray[i].equals("%")) {
                try {
                    a = (Double) stack.pop();
                    b = (Double) stack.pop();
                } catch (EmptyStackException e) {
                    return false;
                }
                ergebnis = a % b;

                stack.push(ergebnis);
            }
        }
        ergebnis = stack.pop();
        if (!stack.empty()) {
            return false;
        }
        return true;
    }
}

