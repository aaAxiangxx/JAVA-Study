import java.util.Random;

/**
 * 扫雷游戏的核心逻辑类
 */
public class MineSweeperGame {
    private Cell[][] board;           // 游戏棋盘
    private GameConfig config;        // 游戏配置
    private boolean gameOver;         // 游戏是否结束
    private boolean gameWon;          // 游戏是否胜利
    private int movesCount;           // 玩家操作次数
    private int flagsPlaced;          // 已放置的旗帜数量
    private int revealedCells;        // 已揭开的单元格数量

    /**
     * 构造函数，初始化游戏
     */
    public MineSweeperGame() {
        this.config = new GameConfig();
        initializeGame();
    }

    /**
     * 构造函数，使用指定难度初始化游戏
     * @param difficulty 游戏难度
     */
    public MineSweeperGame(GameConfig.Difficulty difficulty) {
        this.config = new GameConfig();
        this.config.setDifficulty(difficulty);
        initializeGame();
    }

    /**
     * 初始化游戏
     */
    private void initializeGame() {
        int rows = config.getRows();
        int cols = config.getColumns();

        // 创建棋盘
        board = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = new Cell();
            }
        }

        // 重置游戏状态
        gameOver = false;
        gameWon = false;
        movesCount = 0;
        flagsPlaced = 0;
        revealedCells = 0;
    }

    /**
     * 开始新游戏
     */
    public void newGame() {
        initializeGame();
    }

    /**
     * 开始新游戏，使用指定难度
     * @param difficulty 游戏难度
     */
    public void newGame(GameConfig.Difficulty difficulty) {
        config.setDifficulty(difficulty);
        initializeGame();
    }

    /**
     * 放置地雷，确保第一次点击的位置不是地雷
     * @param firstRow 第一次点击的行
     * @param firstCol 第一次点击的列
     */
    public void placeMines(int firstRow, int firstCol) {
        int totalMines = config.getTotalMines();
        int rows = config.getRows();
        int cols = config.getColumns();
        Random random = new Random();

        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int row = random.nextInt(rows);
            int col = random.nextInt(cols);

            // 确保不在第一次点击的位置及其周围放置地雷
            if ((Math.abs(row - firstRow) > 1 || Math.abs(col - firstCol) > 1) && !board[row][col].isMine()) {
                board[row][col].setMine(true);
                minesPlaced++;
            }
        }

        // 计算每个单元格周围的地雷数量
        calculateNeighborMines();
    }

    /**
     * 计算每个单元格周围的地雷数量
     */
    private void calculateNeighborMines() {
        int rows = config.getRows();
        int cols = config.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!board[i][j].isMine()) {
                    int count = countAdjacentMines(i, j);
                    board[i][j].setNeighborMines(count);
                }
            }
        }
    }

    /**
     * 计算指定位置周围的地雷数量
     * @param row 行号
     * @param col 列号
     * @return 周围地雷数量
     */
    private int countAdjacentMines(int row, int col) {
        int count = 0;

        // 检查周围8个方向
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // 跳过自身

                int newRow = row + i;
                int newCol = col + j;

                // 检查位置是否有效
                if (config.isValidPosition(newRow, newCol) && board[newRow][newCol].isMine()) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * 揭开指定位置的单元格
     * @param row 行号
     * @param col 列号
     * @return 如果点到地雷返回true，否则返回false
     */
    public boolean revealCell(int row, int col) {
        // 如果游戏已结束或位置无效，则不执行操作
        if (gameOver || !config.isValidPosition(row, col)) {
            return false;
        }

        Cell cell = board[row][col];

        // 如果单元格已被揭开或被标记为旗帜，则不执行操作
        if (cell.isRevealed() || cell.isFlagged()) {
            return false;
        }

        // 如果是第一次点击，放置地雷
        if (movesCount == 0) {
            placeMines(row, col);
        }

        // 增加操作次数（只在有效点击时增加）
        movesCount++;

        // 揭开单元格
        boolean hitMine = cell.reveal();
        if (hitMine) {
            // 点到地雷，游戏结束
            setGameOver(true);
            setGameWon(false);
            revealAllMines();
            return true;
        } else {
            // 增加已揭开的单元格数量
            revealedCells++;

            // 如果周围没有地雷，自动揭开周围的单元格
            if (cell.getNeighborMines() == 0) {
                revealAdjacentCells(row, col);
            }

            // 检查是否获胜
            checkWinCondition();

            return false;
        }
    }

    /**
     * 自动揭开周围的单元格（当点击的单元格周围没有地雷时）
     * @param row 行号
     * @param col 列号
     */
    private void revealAdjacentCells(int row, int col) {
        // 检查周围8个方向
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue; // 跳过自身

                int newRow = row + i;
                int newCol = col + j;

                // 检查位置是否有效
                if (config.isValidPosition(newRow, newCol)) {
                    Cell adjacentCell = board[newRow][newCol];

                    // 如果相邻单元格未被揭开且未被标记为旗帜
                    if (!adjacentCell.isRevealed() && !adjacentCell.isFlagged()) {
                        // 揭开相邻单元格
                        adjacentCell.reveal();
                        revealedCells++;

                        // 如果相邻单元格周围也没有地雷，递归揭开
                        if (adjacentCell.getNeighborMines() == 0) {
                            revealAdjacentCells(newRow, newCol);
                        }
                    }
                }
            }
        }
    }

    /**
     * 在指定位置切换旗帜标记
     * @param row 行号
     * @param col 列号
     * @return 如果成功切换返回true，否则返回false
     */
    public boolean toggleFlag(int row, int col) {
        // 如果游戏已结束或位置无效，则不执行操作
        if (gameOver || !config.isValidPosition(row, col)) {
            return false;
        }

        Cell cell = board[row][col];
        boolean result = cell.toggleFlag();

        // 只在成功切换旗帜时更新计数
        if (result) {
            // 增加操作次数
            movesCount++;
            
            // 更新旗帜计数
            if (cell.isFlagged()) {
                flagsPlaced++;
            } else {
                flagsPlaced--;
            }
        }

        return result;
    }

    /**
     * 检查是否获胜
     */
    private void checkWinCondition() {
        // 如果已揭开的单元格数量等于非地雷单元格的总数，则获胜
        if (revealedCells == config.getTotalCells() - config.getTotalMines()) {
            setGameWon(true);
            setGameOver(true);
            // 自动标记所有未揭开的格子为地雷
            for (int i = 0; i < config.getRows(); i++) {
                for (int j = 0; j < config.getColumns(); j++) {
                    Cell cell = board[i][j];
                    if (!cell.isRevealed() && !cell.isFlagged()) {
                        cell.toggleFlag();
                        flagsPlaced++;
                    }
                }
            }
        }
    }

    /**
     * 揭开所有地雷（游戏结束时）
     */
    private void revealAllMines() {
        int rows = config.getRows();
        int cols = config.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Cell cell = board[i][j];
                if (cell.isMine()) {
                    cell.setRevealed(true);
                }
            }
        }
    }

    // Getters and Setters
    public Cell[][] getBoard() {
        return board;
    }

    public GameConfig getConfig() {
        return config;
    }

    public boolean isGameOver() {
        return gameOver;
    }
    
    /**
     * 设置游戏结束状态
     * @param gameOver 游戏是否结束
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public boolean isGameWon() {
        return gameWon;
    }
    
    /**
     * 设置游戏胜利状态
     * @param gameWon 游戏是否胜利
     */
    public void setGameWon(boolean gameWon) {
        this.gameWon = gameWon;
    }

    public int getMovesCount() {
        return movesCount;
    }

    public int getFlagsPlaced() {
        return flagsPlaced;
    }

    public int getRemainingMines() {
        return config.getTotalMines() - flagsPlaced;
    }

    public Cell getCell(int row, int col) {
        if (config.isValidPosition(row, col)) {
            return board[row][col];
        }
        return null;
    }
}
