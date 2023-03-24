import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    
    private Scanner in;

    private Frota frota;

    public App() {
        in = new Scanner(System.in);
        frota = new Frota();
    }

    public void inicializa() {
        frota.leArquivoDistancia();
    }

    public void executa() {
        int opcao = -1;
        do {
            menu();
            boolean ok;
            do {
                ok = true;
                try {
                opcao = in.nextInt();
                } catch (InputMismatchException e1) {
                    in.nextLine();
                    ok = false;
                    System.out.println("Tipo incorreto. Redigite.\n");
                } catch (Exception e2) {
                    in.nextLine();
                    ok = false;
                    e2.printStackTrace();
                    System.out.println("Redigite.\n");
                }
            } while (!ok);
            in.nextLine();

            switch (opcao) {
                case 0:
                    break;
                case 1:
                    consultaTrechosModalidade();
                    break;
                case 2:
                    cadastraTransporte();
                    break;
                case 3:
                    dadosEstatisticos();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        } while (opcao != 0);
    }

    public void menu() {
        System.out.println("\n==========================================");
        System.out.println("Bem-vindo ao sistema de transporte interestadual de cargas");
        System.out.println("[1] Consultar trechos disponíveis e modalidades de transporte");
        System.out.println("[2] Cadastrar novo transporte");
        System.out.println("[3] Exibir dados estatísticos");
        System.out.println("[4] Terminar o programa");
        System.out.println("==========================================");
        System.out.println("\nOpção desejada: ");
    }

    public void consultaTrechosModalidade() {
        System.out.println("Estes são os trechos disponíveis e a distância entre eles: ");
        frota.consultaTrechos().stream().forEach(T -> System.out.println(T.toString()));
        System.out.println("Digite o nome da cidade origem que deseja realizar seu transporte: ");
        String cidadeOrigem = in.nextLine();
        System.out.println("Agora, digite o nome da cidade destino: ");
        String cidadeDestino = in.nextLine();

        cidadeOrigem = cidadeOrigem.toUpperCase();
        cidadeDestino = cidadeDestino.toUpperCase();
        if(frota.consultaDistancia(cidadeOrigem, cidadeDestino) == -1) {
            System.out.println("Não foi encontrada distância entre estas cidades, verifique se ambas foram escritas corretamente, sem acentos.");
            return;
        }
        System.out.println("Por fim, digite a sigla que corresponde o tamanho do caminhão em que deseja consultar o preço de transporte: ");
        System.out.printf("\nCaminhao de pequeno porte [P]" + "\nCaminhao de medio porte [M]" +"\nCaminhao de pequeno porte [P]");
    }

    public void cadastraTransporte() {

    }

    public void dadosEstatisticos() {

    }
}
