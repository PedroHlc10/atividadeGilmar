import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        ArrayList<String> listaCompras = new ArrayList<>();
        Scanner entrada = new Scanner(System.in);

        int opcaoLista = 0;
        int opcao = 0;
        String novoItem = "";

        do {
            try {
                System.out.println("""
                        
                                LISTA DE COMPRAS
                        

                        1 - Criar uma Lista
                        2 - Sair
                        """);

                opcaoLista = entrada.nextInt();
                entrada.nextLine();

                switch (opcaoLista) {
                    case 1 -> {
                        System.out.println("Lista criada com sucesso!");

                        do {
                            System.out.println("""
                                    
                                    
                                              MENU DA LISTA
                                    

                                    1 - Adicionar item
                                    2 - Ver lista
                                    3 - Remover último item
                                    4 - Remover item pelo nome
                                    5 - Editar item
                                    6 - Limpar lista
                                    7 - Mostrar quantidade de itens
                                    8 - Voltar ao menu principal
                                    """);

                            opcao = entrada.nextInt();
                            entrada.nextLine();

                            switch (opcao) {
                                case 1 -> {
                                    System.out.print("Digite o nome do produto: ");
                                    novoItem = entrada.nextLine();

                                    if (novoItem.isBlank()) {
                                        System.out.println("O nome não pode ser vazio.");
                                    } else if (listaCompras.contains(novoItem)) {
                                        System.out.println("Esse item já existe.");
                                    } else {
                                        listaCompras.add(novoItem);
                                        System.out.println("Item adicionado!");
                                    }
                                }
                                case 2 -> {
                                    if (listaCompras.isEmpty()) {
                                        System.out.println("A lista está vazia.");
                                    } else {
                                        System.out.println("\nSua lista:");
                                        for (int i = 0; i < listaCompras.size(); i++) {
                                            System.out.println((i + 1) + " - " + listaCompras.get(i));
                                        }
                                    }
                                }
                                case 3 -> {
                                    if (listaCompras.isEmpty()) {
                                        System.out.println("A lista está vazia.");
                                    } else {
                                        listaCompras.remove(listaCompras.size() - 1);
                                        System.out.println("Último item removido.");
                                    }
                                }
                                case 4 -> {
                                    System.out.print("Digite o nome do produto que deseja remover: ");
                                    String remover = entrada.nextLine();

                                    if (listaCompras.remove(remover)) {
                                        System.out.println("Produto removido!");
                                    } else {
                                        System.out.println("Produto não encontrado.");
                                    }
                                }
                                case 5 -> {
                                    if (listaCompras.isEmpty()) {
                                        System.out.println("A lista está vazia.");
                                    } else {
                                        for (int i = 0; i < listaCompras.size(); i++) {
                                            System.out.println((i + 1) + " - " + listaCompras.get(i));
                                        }

                                        System.out.print("Digite o número do item: ");
                                        int editar = entrada.nextInt();
                                        entrada.nextLine();

                                        if (editar >= 1 && editar <= listaCompras.size()) {
                                            System.out.print("Novo nome: ");
                                            String novoNome = entrada.nextLine();

                                            listaCompras.set(editar - 1, novoNome);
                                            System.out.println("Item editado!");
                                        } else {
                                            System.out.println("Número inválido.");
                                        }
                                    }
                                }
                                case 6 -> {
                                    listaCompras.clear();
                                    System.out.println("Lista limpa!");
                                }
                                case 7 -> {
                                    System.out.println("Quantidade de itens: " + listaCompras.size());
                                }
                                case 8 -> {
                                    System.out.println("Voltando ao menu principal...");
                                }
                                default -> {
                                    System.out.println("Opção inválida!");
                                }
                            }
                        } while (opcao != 8);
                    }
                    case 2 -> {
                        System.out.println("Sistema encerrado!");
                    }
                    default -> {
                        System.out.println("Opção inválida!");
                    }
                }

            } catch (Exception erro) {
                System.out.println("Digite apenas números.");
                entrada.nextLine();
            }

        } while (opcaoLista != 2);

        entrada.close();
    }
}