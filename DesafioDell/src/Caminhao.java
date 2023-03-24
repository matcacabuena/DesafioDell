public class Caminhao {

    private char porte;

    //private double carga, custo;
    //              kg    R$/km

    public Caminhao(char porte) {
        this.porte = porte;
    }

    public char getPorte() {
        return this.porte;
    }

    public void setPorte(char porte) {
        this.porte = porte;
    }
}
//while peso > 8 usa caminhao grande porte
//while peso > 2 usa caminhao porte medio 
//while peso > 0 usa caminhao porte pequeno 