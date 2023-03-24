public class Distancia {
    String cidadeNome, cidadeDestino;

    int distancia;

    public Distancia(String cidadeNome, String cidadeDestino, int distancia) {
        this.cidadeNome = cidadeNome;
        this.cidadeDestino = cidadeDestino;
        this.distancia = distancia;
    }

    public String getCidadeNome() {
        return cidadeNome;
    }

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setCidadeNome(String cidadeNome) {
        this.cidadeNome = cidadeNome;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public String toString() {
        return "\n-----------------------------" +
                "\nCidade: " + getCidadeNome() +
                "\nDestino: " + getCidadeDestino() + 
                "\nDistância: " + getDistancia() + 
                "\n-----------------------------";
    }
}
