public interface Polylinje extends java.lang.Iterable<Punkt> {
    Punkt[] getHorn();

    String getFarg();

    int getBredd();

    double langd();

    void setFarg(String farg);

    void setBredd(int bredd);

    public void laggTill(Punkt horn);

    void laggTillFramfor(Punkt horn, String hornNamn);

    void taBort(String hornNamn);

    java.util.Iterator<Punkt> iterator();
}
