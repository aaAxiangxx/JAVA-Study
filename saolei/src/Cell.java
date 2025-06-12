/**
 * 扫雷游戏的单元格类
 * 表示游戏中的每个方格
 */
public class Cell {
    private boolean isMine;           // 是否是地雷
    private boolean isRevealed;       // 是否已经揭开
    private boolean isFlagged;        // 是否被标记为旗帜
    private int neighborMines;        // 周围地雷数量

    public Cell() {
        this.isMine = false;
        this.isRevealed = false;
        this.isFlagged = false;
        this.neighborMines = 0;
    }

    // Getters and Setters
    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void setRevealed(boolean revealed) {
        isRevealed = revealed;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public void setFlagged(boolean flagged) {
        isFlagged = flagged;
    }

    public int getNeighborMines() {
        return neighborMines;
    }

    public void setNeighborMines(int neighborMines) {
        this.neighborMines = neighborMines;
    }

    /**
     * 切换旗帜状态
     * @return 如果成功切换返回true，如果单元格已经被揭开则返回false
     */
    public boolean toggleFlag() {
        if (!isRevealed) {
            isFlagged = !isFlagged;
            return true;
        }
        return false;
    }

    /**
     * 揭开单元格
     * @return 如果是地雷返回true，否则返回false
     */
    public boolean reveal() {
        if (!isFlagged && !isRevealed) {
            isRevealed = true;
            return isMine;
        }
        return false;
    }
}
