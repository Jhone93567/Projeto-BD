package br.inatel;

import br.inatel.DAO.*;
import br.inatel.Model.*;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;

        do {
            try {
                System.out.println("\n====== MENU PRINCIPAL ======");
                System.out.println("1. Gerenciar Capitães");
                System.out.println("2. Gerenciar Coordenadores");
                System.out.println("3. Gerenciar Categorias");
                System.out.println("4. Gerenciar Membros");
                System.out.println("5. Gerenciar Robôs");
                System.out.println("6. Gerenciar Competições");
                System.out.println("7. Gerenciar Competições x Categorias");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1 -> gerenciarCapitaes(sc);
                    case 2 -> gerenciarCoordenadores(sc);
                    case 3 -> gerenciarCategorias(sc);
                    case 4 -> gerenciarMembros(sc);
                    case 5 -> gerenciarRobos(sc);
                    case 6 -> gerenciarCompeticoes(sc);
                    case 7 -> gerenciarCompCat(sc);
                    case 0 -> System.out.println("Saindo...");
                    default -> System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Digite um número.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Erro inesperado: " + e.getMessage());
            }
        } while (opcao != 0);

        sc.close();
    }

    private static void gerenciarCapitaes(Scanner sc) {
        CapitaoDAO dao = new CapitaoDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    dao.insert(new Capitao(nome));
                }
                case 2 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo nome: "); String nome = sc.nextLine();
                    dao.update(new Capitao(id, nome));
                }
                case 3 -> {
                    System.out.print("ID a deletar: ");
                    dao.delete(sc.nextInt());
                }
                case 4 -> {
                    List<Capitao> lista = dao.selectAll();
                    lista.forEach(c -> System.out.println(c.getId() + ": " + c.getNome()));
                }
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Capitao capitao = dao.selectById(sc.nextInt());
                    System.out.println(capitao.getId() + ": " + capitao.getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar capitães: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarCoordenadores(Scanner sc) {
        CoordenadorDAO dao = new CoordenadorDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1 -> {
                    System.out.print("Nome: ");
                    dao.insert(new Coordenador(sc.nextLine()));
                }
                case 2 -> {
                    System.out.print("ID: "); int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Novo nome: "); String nome = sc.nextLine();
                    dao.update(new Coordenador(id, nome));
                }
                case 3 -> {
                    System.out.print("ID a deletar: "); dao.delete(sc.nextInt());
                }
                case 4 -> dao.selectAll().forEach(c -> System.out.println(c.getId() + ": " + c.getNome()));
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Coordenador coordenador = dao.selectById(sc.nextInt());
                    System.out.println(coordenador.getId() + ": " + coordenador.getNome());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar coordenadores: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarCategorias(Scanner sc) {
        CategoriaDAO dao = new CategoriaDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1, 2 -> {
                    int id = 0;
                    if (op == 2) {
                        System.out.print("ID: ");
                        id = sc.nextInt(); sc.nextLine();
                    }
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("ID Capitão: "); int idCap = sc.nextInt();
                    System.out.print("ID Coordenador: "); int idCoord = sc.nextInt();
                    Categoria c = new Categoria(id, nome, idCap, idCoord);
                    if (op == 1) dao.insert(c); else dao.update(c);
                }
                case 3 -> { System.out.print("ID: "); dao.delete(sc.nextInt()); }
                case 4 -> dao.selectAll().forEach(c ->
                        System.out.println(c.getId() + ": " + c.getNome() + ", Capitão ID: " + c.getCapitaoId() + ", Coordenador ID: " + c.getCoordenadorId()));
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Categoria categoria = dao.selectById(sc.nextInt());
                    System.out.println(categoria.getId() + ": " + categoria.getNome() + ", Capitão ID: " + categoria.getCapitaoId() + ", Coordenador ID: " + categoria.getCoordenadorId());

                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar categorias: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarMembros(Scanner sc) {
        MembroDAO dao = new MembroDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1, 2 -> {
                    int id = 0;
                    if (op == 2) { System.out.print("ID: "); id = sc.nextInt(); sc.nextLine(); }
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Periodo: "); int periodo = sc.nextInt(); sc.nextLine();
                    System.out.print("Curso: "); String curso = sc.nextLine();
                    System.out.print("Categoria ID: "); int catId = sc.nextInt();
                    Membro m = new Membro(id, nome, periodo, curso, catId);
                    if (op == 1) dao.insert(m); else dao.update(m);
                }
                case 3 -> { System.out.print("ID: "); dao.delete(sc.nextInt()); }
                case 4 -> dao.selectAll().forEach(m ->
                        System.out.println(m.getId() + ": " + m.getNome() + ", Curso: " + m.getCurso()));
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Membro m = dao.selectById(sc.nextInt());
                    System.out.println(m.getId() + ": " + m.getNome() + ", Curso: " + m.getCurso());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar membros: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarRobos(Scanner sc) {
        RoboDAO dao = new RoboDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1, 2 -> {
                    int id = 0;
                    if (op == 2) { System.out.print("ID: "); id = sc.nextInt(); sc.nextLine(); }
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Categoria ID: "); int catId = sc.nextInt();
                    Robo r = new Robo(id, nome, catId);
                    if (op == 1) dao.insert(r); else dao.update(r);
                }
                case 3 -> { System.out.print("ID: "); dao.delete(sc.nextInt()); }
                case 4 -> dao.selectAll().forEach(r ->
                        System.out.println(r.getId() + ": " + r.getNome() + " (Categoria: " + r.getCategoriaId() + ")"));
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Robo r = dao.selectById(sc.nextInt());
                    System.out.println(r.getId() + ": " + r.getNome() + " (Categoria: " + r.getCategoriaId() + ")");
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar robôs: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarCompeticoes(Scanner sc) {
        CompeticaoDAO dao = new CompeticaoDAO();
        try {
            System.out.println("1. Inserir\n2. Atualizar\n3. Deletar\n4. Listar todos\n5. Listar por Id");
            int op = sc.nextInt(); sc.nextLine();
            switch (op) {
                case 1, 2 -> {
                    int id = 0;
                    if (op == 2) { System.out.print("ID: "); id = sc.nextInt(); sc.nextLine(); }
                    System.out.print("Nome: "); String nome = sc.nextLine();
                    System.out.print("Lugar: "); String lugar = sc.nextLine();
                    System.out.print("Data (AAAA-MM-DD): "); String data = sc.nextLine();
                    Competicao c = new Competicao(id, nome, lugar, data);
                    if (op == 1) dao.insert(c); else dao.update(c);
                }
                case 3 -> { System.out.print("ID: "); dao.delete(sc.nextInt()); }
                case 4 -> dao.selectAll().forEach(c ->
                        System.out.println(c.getId() + ": " + c.getNome() + " em " + c.getLugar() + " - " + c.getData()));
                case 5 -> {
                    System.out.println("ID a procurar: ");
                    Competicao c = dao.selectById(sc.nextInt());
                    System.out.println(c.getId() + ": " + c.getNome() + " em " + c.getLugar() + " - " + c.getData());
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar competições: " + e.getMessage());
            sc.nextLine();
        }
    }

    private static void gerenciarCompCat(Scanner sc) {
        CompeticaoCategoriaDAO dao = new CompeticaoCategoriaDAO();
        try {
            System.out.println("1. Inserir relação\n2. Deletar relação\n3. Listar todas");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.print("ID Competição: "); int compId = sc.nextInt();
                    System.out.print("ID Categoria: "); int catId = sc.nextInt();
                    dao.insert(compId, catId);
                }
                case 2 -> {
                    System.out.print("ID Competição: "); int compId = sc.nextInt();
                    System.out.print("ID Categoria: "); int catId = sc.nextInt();
                    dao.delete(compId, catId);
                }
                case 3 -> dao.selectAll().forEach(System.out::println);
            }
        } catch (Exception e) {
            System.out.println("Erro ao gerenciar relações: " + e.getMessage());
            sc.nextLine();
        }
    }
}