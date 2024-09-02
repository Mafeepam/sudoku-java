package sudoku;

import java.util.Scanner;

public class sudoku {

    private int[][] tabela;

    private static final int tamanho = 9;

    private static final int vazio = 0;

    public sudoku(int[][] tabela) {
        this.tabela = new int[tamanho][tamanho];
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                this.tabela[i][j] = tabela[i][j];
            }
        }
    }


    public void jogar() {
        Scanner input = new Scanner(System.in);
        
        printTabela();

        while (!metododeValidação()) {
            System.out.println("Digite uma linha de 1-9: ");
            int linha = input.nextInt() - 1; 
            System.out.println("Digite uma coluna de 1-9: ");
            int coluna = input.nextInt() - 1;
            System.out.println("Digite um valor de 1-9: ");
            int valor = input.nextInt();

            if (MovValidado(linha, coluna, valor)) {
                tabela[linha][coluna] = valor;
                System.out.println("Movimento Aceito!!!!");
            } else {
                System.out.println("Se fudeu");
            }

            printTabela();

        }
        System.out.println("Ganho pakas");
    }

    public boolean MovValidado(int linha, int coluna, int valor) {
        if (valor < 1 || valor > 9) {
            return false;
        }

        //checar o mov da linha e da coluna
        for (int i = 0; i < tamanho; i++) {
            if (tabela[linha][i] == valor ||tabela[i][coluna] == valor) {
                return false;
            }
        }

        // Checar o mov 3 por 3 da caixa
        int CaixaDalinha = linha - linha % 3;
        int CaixaDaColuna = coluna - coluna % 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabela[CaixaDalinha + i][CaixaDaColuna + j] == valor) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean metododeValidacao() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (tabela [i][j] == vazio) {
                    return false;
                }
            }
        }
        return true;
    }

    public void printTabela() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.print(tabela[i][j] + " ");
                if (j % 3 == 2) {
                    System.out.print("| ");
                }
            }
            System.out.println();
            if (i % 3 == 2) {
                System.out.println("--------------------------");
            }
        }
    }
    

    public static void  main(String[] args) {

        // Pampers vai colocar o codigo de gerar tabela aleatoria
        int [][] tabela = {
                {7, 0, 2, 0, 5, 0, 6, 0, 0},
                {0 ,0 ,0 ,0 ,0 ,3 ,0, 0, 0},
                {1, 0, 0, 0, 0, 9, 5, 0, 0},
                {8, 0, 0, 0, 0, 0, 0, 9, 0},
                {0, 4, 3, 0, 0, 0, 7, 5, 0},
                {0, 9, 0, 0, 0, 0, 0, 0, 8},
                {0, 0, 9, 7, 0, 0, 0, 0, 5},
                {0, 0, 0, 2, 0, 0, 0, 0, 0},
                {0, 0, 7, 0, 4, 0, 2, 0, 3}
        };

        sudoku game = new sudoku(tabela);
        game.jogar();


    }


}