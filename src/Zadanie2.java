
import java.sql.ResultSet;
import java.sql.SQLException;


public class Zadanie2 {

    public static void main(String[] args) throws SQLException {

        Polaczenie.inst().createConnection("jdbc:sqlite:test.db");
        Polaczenie.inst().executeUpdate("create table adres(Wojewodztwo VARCHAR(20),Miasto VARCHAR(20),Ulica VARCHAR(20), Nr VARCHAR(20))");
        Polaczenie.inst().executeUpdate("insert into adres values('Slask', 'Myslowice', 'Katowicka', '3')");
        Polaczenie.inst().executeUpdate("insert into adres values('Slask', 'Katowice', 'Korfantego', '15')");
        Polaczenie.inst().executeUpdate("insert into adres values('Slask', 'Sosnowiec', 'Bedzinska', '7')");
        Polaczenie.inst().executeUpdate("insert into adres values('Mazowieckie', 'Warszawa', 'Mokotow', '22')");

        ResultSet result = Polaczenie.inst().executeQuery("select * from adres order by Wojewodztwo,Miasto,Ulica");
        while (result.next()) {
            System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
        }

        Polaczenie.inst().executeUpdate("delete from adres");
        Polaczenie.inst().executeUpdate("drop table adres");
        Polaczenie.inst().closeConnection();


    }

}
