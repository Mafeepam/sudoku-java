package sudoku;

public class Sudokud {
	public class SudokuBoardGenerator {
	    private int[][] board;
	    private static final int SIZE = 9;
	    private static final int EMPTY = 0;

	    public SudokuBoardGenerator() {
	        board = new int[SIZE][SIZE];
	    }

	    public void generate() {
	        // Limpar o tabuleiro
	        clearBoard();

	        // Preencher a primeira linha do tabuleiro com números aleatórios
	        fillFirstRow();

	        // Resolver o tabuleiro gerado
	        solve();

	        // Remover alguns números aleatoriamente para criar o tabuleiro Sudoku incompleto
	        removeNumbers();
	    }

	    private void clearBoard() {
	        for (int i = 0; i < SIZE; i++) {
	            Arrays.fill(board[i], EMPTY);
	        }
	    }

	    private void fillFirstRow() {
	        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
	        Collections.shuffle(numbers);

	        for (int i = 0; i < SIZE; i++) {
	            board[0][i] = numbers.get(i);
	        }
	    }

	    private boolean solve() {
	        for (int row = 0; row < SIZE; row++) {
	            for (int col = 0; col < SIZE; col++) {
	                if (board[row][col] == EMPTY) {
	                    for (int num = 1; num <= SIZE; num++) {
	                        if (isValid(row, col, num)) {
	                            board[row][col] = num;
	                            if (solve()) {
	                                return true;
	                            } else {
	                                board[row][col] = EMPTY;
	                            }
	                        }
	                    }
	                    return false;
	                }
	            }
	        }
	        return true;
	    }

	    private boolean isValid(int row, int col, int num) {
	        // Verificar se o número já existe na mesma linha
	        for (int i = 0; i < SIZE; i++) {
	            if (board[row][i] == num) {
	                return false;
	            }
	        }

	        // Verificar se o número já existe na mesma coluna
	        for (int i = 0; i < SIZE; i++) {
	            if (board[i][col] == num) {
	                return false;
	            }
	        }

	        // Verificar se o número já existe na mesma caixa 3x3
	        int boxRow = row - row % 3;
	        int boxCol = col - col % 3;
	        for (int i = boxRow; i < boxRow + 3; i++) {
	            for (int j = boxCol; j < boxCol + 3; j++) {
	                if (board[i][j] == num) {
	                    return false;
	                }
	            }
	        }

	        return true;
	    }

	    private void removeNumbers() {
	        // Determinar quantos números devem ser removidos para obter um tabuleiro incompleto
	        double removalPercentage = 0.5; // Porcentagem de remoção (50% neste exemplo)
	        int totalCells = SIZE * SIZE;
	        int cellsToRemove = (int) Math.round(totalCells * removalPercentage);

	        // Remover números aleatoriamente até atingir a quantidade desejada
	        for (int i = 0; i < cellsToRemove; i++) {
	            int row = (int) (Math.random() * SIZE

}
