package umgedrehtepolnischeNotation;

import org.junit.Test;

import static org.junit.Assert.*;

public class RPNParserTest {
    RPNParser testObjekt = new RPNParser();

    @Test
    public void parser() throws Exception {
        assertTrue(testObjekt.parser("3 4 +"));
        assertTrue(testObjekt.parser("265 80 -"));
        assertTrue(testObjekt.parser("9 8 *"));
        assertTrue(testObjekt.parser("5 1 /"));
        assertTrue(testObjekt.parser("5 !"));
        assertTrue(testObjekt.parser("8 6 f"));
        assertTrue(testObjekt.parser("8 6 %"));
        assertTrue(testObjekt.parser("2 °"));
        assertTrue(testObjekt.parser("8 §"));


        assertTrue(testObjekt.parser("3 4 + 5 *"));
        assertTrue(testObjekt.parser("15 3 / 6 * 12 +"));
        assertTrue(testObjekt.parser("15 3 - 6 - 12 +"));
        assertTrue(testObjekt.parser("3 6 4 + + "));
        assertTrue(testObjekt.parser("3 6 4 * * "));
        assertTrue(testObjekt.parser("3 6 4 * + "));



        //Operator in der Mitte
        assertFalse(testObjekt.parser("3 + 4"));
        assertFalse(testObjekt.parser("3 - 4"));
        assertFalse(testObjekt.parser("3 * 4"));
        assertFalse(testObjekt.parser("4 / 2"));
        assertFalse(testObjekt.parser("7 f 8"));
        assertFalse(testObjekt.parser("10 % 8"));

        //Operator am Anfang
        assertFalse(testObjekt.parser("+ 2 9"));
        assertFalse(testObjekt.parser("* 2 9"));
        assertFalse(testObjekt.parser("- 2 9"));
        assertFalse(testObjekt.parser("/ 2 9"));
        assertFalse(testObjekt.parser("! 2"));
        assertFalse(testObjekt.parser("f 2 9"));
        assertFalse(testObjekt.parser("% 2 9"));
        assertFalse(testObjekt.parser("° 3"));
        assertFalse(testObjekt.parser("§ 3"));

        //nur Operatoren
        assertFalse(testObjekt.parser("!"));
        assertFalse(testObjekt.parser("+"));
        assertFalse(testObjekt.parser("*"));
        assertFalse(testObjekt.parser("-"));
        assertFalse(testObjekt.parser("/"));
        assertFalse(testObjekt.parser("f"));
        assertFalse(testObjekt.parser("°"));
        assertFalse(testObjekt.parser("§"));
        assertFalse(testObjekt.parser("%"));

        //nur Operanden
        assertFalse(testObjekt.parser("8 9 3 12"));

        //ungültige Zeichen
        assertFalse(testObjekt.parser("B K +"));
        assertFalse(testObjekt.parser("5 7 ^"));
        assertFalse(testObjekt.parser("6 9 &"));
        assertFalse(testObjekt.parser("1 2 ="));
        assertFalse(testObjekt.parser("7 8 ?"));
        assertFalse(testObjekt.parser("9 0 ."));
        assertFalse(testObjekt.parser("95 6,"));

        //zu viele Operatroen
        assertFalse(testObjekt.parser("1 2 + + + + "));
        assertFalse(testObjekt.parser("6 * * *"));
        assertFalse(testObjekt.parser("57 9 0 / / / / "));
        assertFalse(testObjekt.parser("9 4 5 - - - -"));
        assertFalse(testObjekt.parser("8 15 ! ! !"));
        assertFalse(testObjekt.parser("8 3 12 f f f f f"));
        assertFalse(testObjekt.parser("5 6 ° ° ° °"));
        assertFalse(testObjekt.parser("9 3 § § §"));
        assertFalse(testObjekt.parser("9 3 8 % % % %"));

        //zu viele Operanden
        assertFalse(testObjekt.parser("8 3 6 f"));
        assertFalse(testObjekt.parser("12 3 9 8 !"));
        assertFalse(testObjekt.parser("12 9 8 -"));
        assertFalse(testObjekt.parser("9 8 5 3 6 + + + + + +"));
        assertFalse(testObjekt.parser("9 8 5 *"));
        assertFalse(testObjekt.parser("10 96 3 8 / /"));
        assertFalse(testObjekt.parser("10 9 6 3 °"));
        assertFalse(testObjekt.parser("8 6 2 §"));
        assertFalse(testObjekt.parser("8 6 2 9 65 %"));

        //Operatoren an der falschen Stelle
        assertFalse(testObjekt.parser("8 - 9 0 -"));
        assertFalse(testObjekt.parser("9 / 2 5 /"));
        assertFalse(testObjekt.parser("9 * 2 5 *"));
        assertFalse(testObjekt.parser("9 + 2 5 +"));
        assertFalse(testObjekt.parser("9 f 2 5 f"));
        assertFalse(testObjekt.parser("! 2"));
        assertFalse(testObjekt.parser("° 2"));
        assertFalse(testObjekt.parser("§ 2"));
        assertFalse(testObjekt.parser("5 % 8 6 3 % 5"));

    }
}