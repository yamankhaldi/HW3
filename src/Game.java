public class Game {
    private Board board;
    private final int maxGeneration;

    private final  Board firstBoard;

    public Game(int rows, int cols, int seed, int range, int maxGeneration) {
        this.board = new Board(rows, cols, seed, range);
        this.maxGeneration = maxGeneration;
        this.firstBoard = new Board(board);
    }

    public void runGame() {
        this.board = new Board(firstBoard) ;
        System.out.println("Generation 0:");
        System.out.println(board);
        Board previousBoard = null;

        for (int i = 1; i < maxGeneration +1 ; i++) {
            board.nextGeneration();
            System.out.println("Generation " + i + ":");
            System.out.println(board);

            if (board.areAllCellsDead()) {
                System.out.println("All cells are dead.");
                break;
            }


            if (previousBoard != null && previousBoard.equals(board)) {
                System.out.println("Cells have stabilized.");
                break;
            }

            previousBoard = new Board(board);

            if (i == maxGeneration ) {
                System.out.println("The generation limitation was reached.");
            }
        }
    }

}
