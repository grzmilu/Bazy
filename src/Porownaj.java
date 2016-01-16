
public class Porownaj implements Comparable<Porownaj> {

    public long ID;
    public long DATA;

    public Porownaj(long ID, long DATA) {
        this.ID = ID;
        this.DATA = DATA;
    }

    @Override
    public int compareTo(Porownaj t) {      
        if (this.DATA < t.DATA) {
            return 1;
        } else if (this.DATA == t.DATA) {
            return 0;
        } else {
            return -1;
        }

    }

}
