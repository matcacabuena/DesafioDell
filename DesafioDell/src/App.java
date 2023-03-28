import java.util.ArrayList;
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
        } while (opcao != 4);
    }

    public void menu() {
        System.out.println("\n============================================================");
        System.out.println("       Sistema de transporte interestadual de cargas");
        System.out.println("[1] Consultar trechos disponíveis e modalidades de transporte");
        System.out.println("[2] Cadastrar novo transporte");
        System.out.println("[3] Exibir dados estatísticos");
        System.out.println("[4] Terminar o programa");
        System.out.println("============================================================");
        System.out.println("\nOpção desejada: ");
    }

    public void consultaTrechosModalidade() {
        System.out.println("Estes são os trechos disponíveis e a distância entre eles: ");
        System.out.println("------------------------------------------------------------------------------");
        frota.consultaTrechos().stream().forEach(T -> System.out.println(T.toString()));
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Digite o nome da cidade origem que deseja realizar seu transporte: ");

        String cidadeOrigem = in.nextLine();
        System.out.println("Agora, digite o nome da cidade destino: ");
        String cidadeDestino = in.nextLine();

        cidadeOrigem = cidadeOrigem.toUpperCase();
        cidadeDestino = cidadeDestino.toUpperCase();
        int distancia = frota.consultaDistancia(cidadeOrigem, cidadeDestino);

        if (distancia == -1) {
            System.out.println(
                    "Não foi encontrada a distância entre estas cidades, verifique se ambas foram escritas corretamente, sem acentos.");
            return;
        }
        System.out.println(
                "Por fim, digite a sigla que corresponde o tamanho do caminhão em que deseja consultar o preço de transporte: ");
        System.out.printf(
                "\nCaminhao de pequeno porte [P]" + "\nCaminhao de medio porte [M]"
                        + "\nCaminhao de grande porte [G]\n");
        char sigla = in.next().charAt(0);
        sigla = Character.toUpperCase(sigla);
        Caminhao c;

        if (sigla == 'P') {
            c = Caminhao.PEQUENO;
        }

        else if (sigla == 'M') {
            c = Caminhao.MEDIO;
        }

        else if (sigla == 'G') {
            c = Caminhao.GRANDE;
        }

        else {
            System.out.println("Erro: certifique-se que escreveu a sigla corretamente.");
            return;
        }

        System.out.printf(
                "de %s para %s, utilizando um caminhao de porte [%c], a distância é de %dkm e o custo será de R$%.2f.",
                cidadeOrigem, cidadeDestino, sigla, distancia, frota.consultaTrechoModalidade(c, distancia));
    }

    //para fazer o cadastramento com mais de 1 cidade, adiciona um ID no transporte para conseguir
    //identificar o transporte TOTAL do PARCIAL. Transformar origem = destino e destino = null ao fim do for
    //achar uma maneira de identificar se ele quer deixar itens ou transportar itens (só pode transportar itens se i = 0)
    //cuidar para nao lotar de switch
    public void cadastraTransporte() {
        String origem;
        String destino;
        int qtdItem = 0;
        int opcao = -1;
        int id = 1;
        double peso = 0;
        Item item;
        ArrayList<Item> itens = new ArrayList();
        Transporte t;

        System.out.println(
                "Digite a quantia de cidades que você deseja transportar seus itens: ");
        int qtdCidade = in.nextInt();
        in.nextLine();

        System.out.println("Qual a cidade de origem?");
        origem = in.nextLine();
        origem = origem.toUpperCase();

        for (int i = 0; i < qtdCidade; i++) {

            System.out.println("\nDigite o destino do transporte que partirá da cidade " + origem + ":");
            destino = in.nextLine();
            destino = destino.toUpperCase();
            do {
                boolean ok;
                do {
                    System.out.println("\nSelecione o tipo de item que deseja transportar: ");
                    System.out.printf(
                            "[1] Celular\n[2] Geladeira\n[3] Freezer\n[4] Cadeira\n[5] Luminaria\n[6] Lavadora de roupa\n[7] Já selecionei todos os itens\n");
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
                    if (opcao != 7) {
                        qtdItem = 0;
                        System.out.println("Quantas unidades deste item você deseja transportar?");
                        try {
                            qtdItem = in.nextInt();
                        } catch (InputMismatchException e1) {
                            in.nextLine();
                            System.out.println("Tipo incorreto. Redigite.\n");
                        } catch (Exception e2) {
                            in.nextLine();
                            e2.printStackTrace();
                            System.out.println("Redigite.\n");
                        }
                    }
                } while (!ok);
                in.nextLine();

                switch (opcao) {
                    case 1:
                        item = Item.CELULAR;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 2:
                        item = Item.GELADEIRA;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 3:
                        item = Item.FREEZER;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 4:
                        item = Item.CADEIRA;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 5:
                        item = Item.LUMINARIA;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 6:
                        item = Item.LAVADORA;
                        itens.add(item);
                        peso += item.getPeso() * qtdItem;
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
            } while (opcao != 7);

            t = new Transporte(origem, destino);
            frota.cadastraTransporte(t, itens, peso);
            System.out.println("");
            System.out.printf("\nde %s para %s, a distância a ser percorrida é de %dkm.\nPara o transporte dos produtos ",
                    origem, destino, frota.consultaDistancia(origem, destino));

            String itAnt = null;
            for (Item it : itens) {
                if (it.getNome() != itAnt) {
                    System.out.printf("%s, ", it.getNome());
                }
                itAnt = it.getNome();
            }

            System.out.printf("será necessário utilizar ");

            int qtdCpeq = 0, qtdCmed = 0, qtdCgran = 0;
            for (Caminhao c : frota.qtdCaminhao(t)) {
                if (c.getNome() == "pequeno porte") {
                    qtdCpeq += 1;
                }
                if (c.getNome() == "medio porte") {
                    qtdCmed += 1;
                }
                if (c.getNome() == "grande porte") {
                    qtdCgran += 1;
                }
            }
            System.out.printf(
                    "\n[%d] caminhões de pequeno porte \n[%d] caminhões de médio porte \n[%d] caminhões de grande porte",
                    qtdCpeq, qtdCmed, qtdCgran);
            System.out.printf("\n de forma a resultar no menor custo de transporte por km rodado. O valor total do transporte dos itens é R$ %.2f", frota.transportePreco(t));
        }

    }

    public void dadosEstatisticos() {

    }
}
