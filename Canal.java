package atv3;

public class Canal implements Comparable<Canal>{
    Integer numero;
    String nome;
    boolean ehHD;

    public Canal(Integer numero, String nome, boolean ehHD) {
        this.numero = numero;
        this.nome = nome;
        this.ehHD = ehHD;
    }
    
    public String imprimir(){
        return "Nome: " +getNome()+ "\nNumero: "+getNumero()+"\nehd: "+getEhHD();
    }
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getEhHD() {
        return ehHD;
    }

    public void setEhHD(boolean ehHD) {
        this.ehHD = ehHD;
    }

    @Override
    public int compareTo(Canal c) {
        return numero.compareTo(c.getNumero());
    }
}
