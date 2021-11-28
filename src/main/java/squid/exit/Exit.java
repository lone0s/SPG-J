package squid.exit;


public class Exit {
    /**
     * Nom de la pièce contenant la sortie
     */
    private String Source;
    /**
     * Nom de la pièce de sortie
     */
    private String Destination;

    public Exit(String mapSrc, String mapDst) {
        this.Source = mapSrc;
        this.Destination = mapDst;
    }

    public String getSrc() {
        return this.Source;
    }

    public String getDest() {
        return this.Destination;
    }

    @Override
    public String toString() {
        //if(!this.Destination.equals(this.Source)) {
            return ("[" + this.Source + "] --> [" + this.Destination + "]");
        //}
    }
}
