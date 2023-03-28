import java.util.ArrayList;

public class Transporte {

    private String origem, destino;

    private int distancia;

    private double carga;

    private ArrayList<Caminhao> frota;

    private ArrayList<Item> itens;

    public Transporte(String origem, String destino) {
        this.origem = origem;
        this.destino = destino;
        frota = new ArrayList<>();
        itens = new ArrayList<>();
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public ArrayList<Caminhao> getFrota() {
        return frota;
    }

    public ArrayList<Item> getItens() {
        return this.itens;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public void setFrota(ArrayList<Caminhao> frota) {
        this.frota = frota;
    }

    public void setItens(ArrayList<Item> itens) {
        this.itens = itens;
    }
    
    public boolean adicionaCaminhao(Caminhao caminhao) {
        return frota.add(caminhao);
    }

    public double calculaCusto(int distancia) {
        double custoP = 0, custoM = 0, custoG = 0;
        for (Caminhao caminhao : frota) {
            if(caminhao == Caminhao.PEQUENO) {
                custoP = custoP + (4.87 * distancia);
            }
            if(caminhao == Caminhao.MEDIO) {
                custoM = custoM + (11.92 * distancia);
            }
            if(caminhao == Caminhao.GRANDE) {
                custoG = custoG + (27.44 * distancia);
            }
        }
        return custoP + custoM + custoG;
    }

    public ArrayList<Caminhao> calculaFrota(double peso) {
        double carga = peso;
        while(carga > 8000) {
            frota.add(Caminhao.GRANDE);
            carga -= 10000;
        }
        while(carga > 2000) {
            frota.add(Caminhao.MEDIO);
            carga -= 4000;
        }
        while(carga > 0) {
            frota.add(Caminhao.PEQUENO);
            carga -= 1000;
        }
        return (ArrayList<Caminhao>)frota.clone();
    }

    @Override
    public String toString() {
        return "{" +
            " origem='" + getOrigem() + "'" +
            ", destino='" + getDestino() + "'" +
            ", distancia='" + getDistancia() +
            "}";
    }
}