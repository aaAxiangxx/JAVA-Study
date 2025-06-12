/**
 * 扫雷游戏的主类
 * 负责启动游戏
 */
public class MineSweeper {
    /**
     * 主方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        // 在事件调度线程中运行
        javax.swing.SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}
