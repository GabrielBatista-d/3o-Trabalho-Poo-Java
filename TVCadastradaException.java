package atv3;
public class TVCadastradaException extends Exception{
    protected Televisao tv;

    public TVCadastradaException(Televisao tv) {
        this.tv = tv;
    }

    @Override
    public String toString() {
        return "A TV: "+tv+"já foi cadastrada";
    }
    
}
