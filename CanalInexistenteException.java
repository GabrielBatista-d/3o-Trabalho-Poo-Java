package atv3;
public class CanalInexistenteException extends Exception{
    @Override
    public String toString() {
        return "Este canal não existe";
    }
}
