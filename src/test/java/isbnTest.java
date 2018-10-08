import static org.junit.Assert.*;

public class isbnTest {
    @org.junit.Test
    public void ueberpruefen() throws Exception {
        assertTrue (isbn.ueberpruefen ("978-3-86680-192-9"));
        assertTrue (isbn.ueberpruefen ("9783866801929"));
        assertTrue (isbn.ueberpruefen( "9791236957848"));
        assertTrue (isbn.ueberpruefen( "9783127323207"));

        //leere Eingabe
        assertFalse(isbn.ueberpruefen(""));

        //Buchstaben
        assertFalse (isbn.ueberpruefen ("9783866801929AAAA"));
        assertFalse(isbn.ueberpruefen("D952L7526P918"));
        assertFalse(isbn.ueberpruefen("D95-2-L752-6P91-8"));
        assertFalse(isbn.ueberpruefen("D95-2-L752-6P91-"));

        //Sonderzeichen
        assertFalse (isbn.ueberpruefen ("9783866801929????"));

        //falsche Laenge
        assertFalse(isbn.ueberpruefen("978-2-8752-6691-875"));
        assertFalse(isbn.ueberpruefen("978-2-6752-891"));

        //falsche Zahlen am Anfang
        assertFalse (isbn.ueberpruefen( "9891235687459"));
        assertFalse (isbn.ueberpruefen( "1111235687459"));

        //falsche Pruefziffer
        assertFalse (isbn.ueberpruefen( "9783866801923"));
        assertFalse (isbn.ueberpruefen( "9783127323208"));




    }

}