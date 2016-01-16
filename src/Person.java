
public class Person implements Comparable<Person> {

    private String wojewodztwo;
    private String miasto;
    private String ulica;
    private String nrDomu;

    public Person(String wojewodztwo, String miasto, String ulica, String nrDomu) {
        this.wojewodztwo = wojewodztwo;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;

    }

    public String getAdres() {
        return wojewodztwo + " " + miasto + " " + ulica + " " + nrDomu;
    }

    @Override
    public int compareTo(Person t) {
        int porownanieWoj = wojewodztwo.compareTo(t.wojewodztwo);
        if (porownanieWoj == 0) {
            int porownanieMia = miasto.compareTo(t.miasto);
            if (porownanieMia == 0) {
                int porwonanieUl = ulica.compareTo(ulica);
                if (porwonanieUl == 0) {
                    return nrDomu.compareTo(nrDomu);
                } else {
                    return porwonanieUl;
                }
            } else {
                return porownanieMia;
            }
        } else {
            return porownanieWoj;
        }
    }

}
