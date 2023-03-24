import java.util.ArrayList;

public class Transporte {

    private String origem, destino;

    private int distancia;

    private double carga;

    private ArrayList<Caminhao> frota;

    public Transporte(String origem, String destino, int distancia, double carga) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
        this.carga = carga;
        frota = new ArrayList<>();
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }
    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getDistancia() {
        return this.distancia;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    public double getCarga() {
        return this.carga;
    }

    public void setCarga(double carga) {
        this.carga = carga;
    }
    public void setFrota(ArrayList<Caminhao> frota) {
        this.frota = frota;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public ArrayList<Caminhao> getFrota() {
        return frota;
    }

    public double calculaCusto() {
        double custoP = 0, custoM = 0, custoG = 0;
        for (Caminhao caminhao : frota) {
            if(caminhao.getPorte() == 'P') {
                custoP = 4.87 * distancia;
            }
            if(caminhao.getPorte() == 'M') {
                custoM = 11.92 * distancia;
            }
            if(caminhao.getPorte() == 'G') {
                custoG = 27.44 * distancia;
            }
        }
        return custoP + custoM + custoG;
    }

    @Override
    public String toString() {
        return "{" +
            " origem='" + getOrigem() + "'" +
            ", destino='" + getDestino() + "'" +
            ", distancia='" + getDistancia() + "'" +
            ", carga='" + getCarga() + "'" +
            ", frota='" + getFrota() + "'" +
            "}\n";
    }

    /*funfa
    public void leArquivoDistancia() {
        Path path = Paths.get("DNIT-Distancias.csv");
        distanciaCidades = new ArrayList<>();
        String cidadeOrigem;
        String cidadeDestino;
        int distancia;
        int index = 0;
        try {
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = null;

            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                for (int i = 0; i < lines.length; i++) {
                    for (int j = 0; j < lines.length; j++) {
                        cidadeOrigem = lines[i];
                        cidadeDestino = lines[j];
                        distanciaCidades.add(new Distancia(cidadeOrigem, cidadeDestino, -1));
                    }
                }
                break;
            }
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                for (int i = 0; i < lines.length; i++, index++) {
                    distancia = Integer.parseInt(lines[i]);
                    distanciaCidades.get(index).setDistancia(distancia);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }*/
}