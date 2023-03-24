import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Frota {

    private ArrayList<Caminhao> caminhoes;

    private ArrayList<Transporte> dados;

    private ArrayList<Transporte> trechos;

    public Frota() {
        caminhoes = new ArrayList<>();
        dados = new ArrayList<>();
        trechos = new ArrayList<>();
    }

    public ArrayList<Caminhao> getCaminhao() {
        return this.caminhoes;
    }

    public void setCaminhao(ArrayList<Caminhao> caminhao) {
        this.caminhoes = caminhao;
    }

    public ArrayList<Transporte> getDados() {
        return this.dados;
    }

    public void setDados(ArrayList<Transporte> dados) {
        this.dados = dados;
    }

    public ArrayList<Transporte> consultaTrechos() {
        return trechos;
    }

    public boolean cadastraTransporte(Transporte transporte) {
        return dados.add(transporte);
    }

    public ArrayList<Transporte> dadosEstatisticos() {
        if(dados != null) {
        return dados;
        }
        return null;
    }

    public int consultaDistancia(String cidadeOrigem, String cidadeDestino) {
        for (Transporte t : trechos) {
            if(t.getOrigem().equals(cidadeOrigem) && t.getDestino().equals(cidadeDestino)) {
                return t.getDistancia();
            }
        }
        return -1;
    }

    public void leArquivoDistancia() {
        Path path = Paths.get("DNIT-Distancias.csv");
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
                        trechos.add(new Transporte(cidadeOrigem, cidadeDestino, -1, -1));
                    }
                }
                break;
            }
            while ((line = br.readLine()) != null) {
                String[] lines = line.split(";");
                for (int i = 0; i < lines.length; i++, index++) {
                    distancia = Integer.parseInt(lines[i]);
                    trechos.get(index).setDistancia(distancia);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}