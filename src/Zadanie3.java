import java.util.Arrays;
import java.util.Random;

public class Zadanie3 {

    static int wielkosc = 1000000;
    public static Porownaj[] tablica;
    static Random r=new Random();
    public static void main(String[] args) {
        Polaczenie.inst().createConnection("jdbc:sqlite:test.db");
        Polaczenie.inst().executeUpdate("create table dane(ID BIGINT,DATA BIGINT)");
        tablica = new Porownaj[wielkosc];
        System.out.println("Tworzenie tablicy");
        for (int i = 0; i < wielkosc; i++) {
            long data = (long) r.nextInt(1000000);
            tablica[i] = new Porownaj(i, data);
            Polaczenie.inst().executeUpdate("insert into dane values(" + i + "," + data + ")");
        }
        System.out.println("Utworzono tablice");
        System.out.println("Sortowanie z uzyciem Javy");
        long s = System.currentTimeMillis();
        Arrays.sort(tablica);
        
        System.out.println("Czas sortowania z uzyciem Javy: " + (System.currentTimeMillis() - s) + " milisekund");
        System.out.println("Sortowanie z uzyciem SQL");
        s = System.currentTimeMillis();
        
        Polaczenie.inst().executeQuery("select * from dane order by DATA");
        System.out.println("Czas sortowania z uzyciem SQL: " + (System.currentTimeMillis() - s) + " milisekund");
        Polaczenie.inst().executeUpdate("delete from dane");
        Polaczenie.inst().executeUpdate("drop table dane");
        Polaczenie.inst().closeConnection();
    }

}
