/**
 * 扫雷游戏配置类
 * 定义不同难度级别的游戏参数
 */
public class GameConfig {
    public enum Difficulty {
        BEGINNER,
        INTERMEDIATE,
        EXPERT
    }

    private int rows;           // 行数
    private int columns;        // 列数
    private int totalMines;     // 地雷总数
    private Difficulty level;   // 难度级别

    // 默认配置（初级难度）
    public GameConfig() {
        setDifficulty(Difficulty.BEGINNER);
    }

    /**
     * 设置游戏难度
     * @param difficulty 难度级别
     */
    public void setDifficulty(Difficulty difficulty) {
        this.level = difficulty;
        switch (difficulty) {
            case BEGINNER:
                // 初级：9x9网格，10个地雷
                this.rows = 9;
                this.columns = 9;
                this.totalMines = 10;
                break;
            case INTERMEDIATE:
                // 中级：16x16网格，40个地雷
                this.rows = 16;
                this.columns = 16;
                this.totalMines = 40;
                break;
            case EXPERT:
                // 高级：16x30网格，99个地雷
                this.rows = 16;
                this.columns = 30;
                this.totalMines = 99;
                break;
        }
    }

    // Getters
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getTotalMines() {
        return totalMines;
    }

    public Difficulty getLevel() {
        return level;
    }

    /**
     * 获取单元格总数
     * @return 网格中的总单元格数
     */
    public int getTotalCells() {
        return rows * columns;
    }

    /**
     * 检查给定的坐标是否在棋盘范围内
     * @param row 行号
     * @param col 列号
     * @return 如果在范围内返回true，否则返回false
     */
    public boolean isValidPosition(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < columns;
    }
}
