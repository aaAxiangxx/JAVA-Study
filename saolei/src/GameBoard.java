import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 扫雷游戏的图形界面类
 */
public class GameBoard extends JFrame {
    private MineSweeperGame game;
    private JButton[][] buttons;
    private JLabel mineCountLabel;
    private JLabel moveCountLabel;
    private JPanel boardPanel;
    private Image mineIcon;
    private Image flagIcon;
    // 现代化的颜色主题
    private final Color REVEALED_CELL_COLOR = new Color(220, 220, 220);
    private final Color UNREVEALED_CELL_COLOR = new Color(245, 245, 245);
    private final Color HOVER_CELL_COLOR = new Color(230, 230, 230);
    private final Color MINE_COLOR = new Color(255, 89, 89);
    private final Color FLAG_COLOR = new Color(255, 140, 0);
    private final Color BORDER_COLOR = new Color(180, 180, 180);
    private final int CELL_SIZE = 40;
    private final Font CELL_FONT = new Font("Segoe UI", Font.BOLD, 20);
    private final Font STATUS_FONT = new Font("Segoe UI", Font.PLAIN, 14);
    
    // 更现代的数字颜色
    private final Color[] NUMBER_COLORS = {
        new Color(25, 118, 210),    // 1 (蓝色)
        new Color(56, 142, 60),     // 2 (绿色)
        new Color(211, 47, 47),     // 3 (红色)
        new Color(123, 31, 162),    // 4 (紫色)
        new Color(255, 143, 0),     // 5 (橙色)
        new Color(0, 151, 167),     // 6 (青色)
        new Color(66, 66, 66),      // 7 (深灰色)
        new Color(158, 158, 158)    // 8 (灰色)
    };

    /**
     * 构造函数
     */
    public GameBoard() {
        game = new MineSweeperGame();
        initializeIcons();
        initializeUI();
    }

    /**
     * 初始化图标
     * 由于资源文件可能不存在，我们直接使用Unicode字符作为图标
     */
    private void initializeIcons() {
        // 不再尝试加载图片文件，直接将图标设置为null
        // 将使用Unicode字符 💣 作为地雷图标，🚩 作为旗帜图标
        mineIcon = null;
        flagIcon = null;
    }

    /**
     * 初始化游戏界面
     */
    private void initializeUI() {
        setTitle("扫雷游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);

        // 创建菜单栏
        createMenuBar();

        // 创建状态面板
        JPanel statusPanel = new JPanel(new FlowLayout());
        mineCountLabel = new JLabel("剩余地雷: " + game.getRemainingMines());
        moveCountLabel = new JLabel("步数: " + game.getMovesCount());
        statusPanel.add(mineCountLabel);
        statusPanel.add(Box.createHorizontalStrut(20));
        statusPanel.add(moveCountLabel);

        // 创建游戏棋盘
        createBoard();

        // 添加组件到窗口
        add(statusPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);

        // 调整窗口大小
        pack();
        setLocationRelativeTo(null);
    }

    /**
     * 创建菜单栏
     */
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu gameMenu = new JMenu("游戏");

        // 新游戏菜单项
        JMenuItem newGameItem = new JMenuItem("新游戏");
        newGameItem.addActionListener(e -> startNewGame(game.getConfig().getLevel()));

        // 难度选择菜单项
        JMenu difficultyMenu = new JMenu("难度");
        JMenuItem beginnerItem = new JMenuItem("初级");
        JMenuItem intermediateItem = new JMenuItem("中级");
        JMenuItem expertItem = new JMenuItem("高级");

        beginnerItem.addActionListener(e -> startNewGame(GameConfig.Difficulty.BEGINNER));
        intermediateItem.addActionListener(e -> startNewGame(GameConfig.Difficulty.INTERMEDIATE));
        expertItem.addActionListener(e -> startNewGame(GameConfig.Difficulty.EXPERT));

        difficultyMenu.add(beginnerItem);
        difficultyMenu.add(intermediateItem);
        difficultyMenu.add(expertItem);

        gameMenu.add(newGameItem);
        gameMenu.addSeparator();
        gameMenu.add(difficultyMenu);

        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
    }

    /**
     * 创建游戏棋盘
     */
    private void createBoard() {
        if (boardPanel != null) {
            remove(boardPanel);
        }

        GameConfig config = game.getConfig();
        int rows = config.getRows();
        int cols = config.getColumns();

        boardPanel = new JPanel(new GridLayout(rows, cols));
        buttons = new JButton[rows][cols];

        // 创建所有按钮
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = createCell(i, j);
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }
    }

    /**
     * 创建单个格子按钮
     */
    private JButton createCell(int row, int col) {
        JButton button = new JButton() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // 绘制圆角背景
                g2d.setColor(getBackground());
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
                
                // 绘制边框
                g2d.setColor(BORDER_COLOR);
                g2d.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
                
                // 绘制文本
                String text = getText();
                if (text != null && !text.isEmpty() && !text.equals(" ")) {
                    FontMetrics fm = g2d.getFontMetrics();
                    int x = (getWidth() - fm.stringWidth(text)) / 2;
                    int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
                    g2d.setColor(getForeground());
                    g2d.drawString(text, x, y);
                }
                
                g2d.dispose();
            }
        };
        
        button.setPreferredSize(new Dimension(CELL_SIZE, CELL_SIZE));
        button.setFont(CELL_FONT);
        button.setFocusPainted(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setBackground(UNREVEALED_CELL_COLOR);
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        // 添加鼠标事件监听器
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!game.isGameOver()) {
                    // 左键点击
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        boolean hitMine = game.revealCell(row, col);
                        
                        // 更新当前格子及其周围的格子
                        GameConfig config = game.getConfig();
                        Cell cell = game.getCell(row, col);
                        updateCell(row, col);
                        
                        // 如果是空白格子，更新周围的格子
                        if (!hitMine && cell.isRevealed() && cell.getNeighborMines() == 0) {
                            for (int i = Math.max(0, row - 1); i <= Math.min(config.getRows() - 1, row + 1); i++) {
                                for (int j = Math.max(0, col - 1); j <= Math.min(config.getColumns() - 1, col + 1); j++) {
                                    updateCell(i, j);
                                }
                            }
                        }
                        
                        // 更新步数显示
                        moveCountLabel.setText("步数: " + game.getMovesCount());
                        
                        if (hitMine) {
                            // 如果点到地雷，直接结束游戏
                            game.setGameOver(true);
                            showGameOverDialog(false);
                        } else if (game.isGameWon()) {
                            // 如果获胜，显示获胜对话框
                            game.setGameOver(true);
                            showGameOverDialog(true);
                        }
                    }
                    // 右键点击
                    else if (e.getButton() == MouseEvent.BUTTON3) {
                        game.toggleFlag(row, col);
                        updateCell(row, col);
                        mineCountLabel.setText("剩余地雷: " + game.getRemainingMines());
                        // 更新步数显示
                        moveCountLabel.setText("步数: " + game.getMovesCount());
                    }
                }
            }
        });

        return button;
    }

    /**
     * 更新游戏界面
     */
    private void updateBoard() {
        GameConfig config = game.getConfig();

        // 更新状态标签
        mineCountLabel.setText("剩余地雷: " + game.getRemainingMines());
        moveCountLabel.setText("步数: " + game.getMovesCount());

        // 更新所有格子
        for (int i = 0; i < config.getRows(); i++) {
            for (int j = 0; j < config.getColumns(); j++) {
                updateCell(i, j);
            }
        }
    }

    /**
     * 更新单个格子的显示
     */
    private void updateCell(int row, int col) {
        JButton button = buttons[row][col];
        Cell cell = game.getCell(row, col);

        // 重置按钮状态
        button.setIcon(null);
        button.setFont(CELL_FONT);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setHorizontalAlignment(SwingConstants.CENTER);
        button.setVerticalAlignment(SwingConstants.CENTER);

        if (cell.isRevealed()) {
            button.setBackground(REVEALED_CELL_COLOR);
            if (cell.isMine()) {
                // 显示地雷
                button.setText("×");  // 使用乘号代替星号
                button.setForeground(Color.BLACK);
                button.setBackground(Color.RED);
            } else {
                // 显示周围地雷数
                int mines = cell.getNeighborMines();
                if (mines > 0) {
                    button.setText(String.valueOf(mines));
                    button.setForeground(NUMBER_COLORS[mines - 1]);
                } else {
                    button.setText(" ");  // 使用空格而不是空字符串
                }
            }
        } else if (cell.isFlagged()) {
            // 显示旗帜
            button.setText("P");  // 使用P代替F
            button.setForeground(Color.RED);
            button.setBackground(UIManager.getColor("Button.background"));
        } else {
            // 未揭开的格子
            button.setText(" ");  // 使用空格而不是空字符串
            button.setBackground(UIManager.getColor("Button.background"));
            button.setForeground(Color.BLACK);
        }
        
        // 确保重绘
        button.revalidate();
        button.repaint();
    }

    /**
     * 开始新游戏
     */
    private void startNewGame(GameConfig.Difficulty difficulty) {
        game = new MineSweeperGame(difficulty);
        // 移除所有内容并重新添加
        getContentPane().removeAll();
        
        // 重新创建状态面板
        JPanel statusPanel = new JPanel(new FlowLayout());
        mineCountLabel = new JLabel("剩余地雷: " + game.getRemainingMines());
        moveCountLabel = new JLabel("步数: " + game.getMovesCount());
        statusPanel.add(mineCountLabel);
        statusPanel.add(Box.createHorizontalStrut(20));
        statusPanel.add(moveCountLabel);
        
        // 创建新的游戏面板
        createBoard();
        
        // 重新添加所有组件
        add(statusPanel, BorderLayout.NORTH);
        add(boardPanel, BorderLayout.CENTER);
        
        // 更新界面
        updateBoard();
        pack();
        setLocationRelativeTo(null);
        revalidate();
        repaint();
    }

    /**
     * 显示游戏结束对话框
     */
    private void showGameOverDialog(boolean won) {
        // 先显示所有地雷
        GameConfig config = game.getConfig();
        for (int i = 0; i < config.getRows(); i++) {
            for (int j = 0; j < config.getColumns(); j++) {
                Cell cell = game.getCell(i, j);
                if (cell.isMine()) {
                    cell.reveal();
                    updateCell(i, j);
                }
            }
        }

        // 构建消息，使用final确保在lambda中可以使用
        final String gameResult = won ? "恭喜你赢了！" : "游戏结束！";
        final String moveCount = "\n步数: " + game.getMovesCount();
        final String finalMessage = gameResult + moveCount;

        // 使用SwingUtilities.invokeLater确保在EDT线程中显示对话框
        SwingUtilities.invokeLater(() -> {
            int option = JOptionPane.showConfirmDialog(
                this,
                finalMessage + "\n是否开始新游戏？",
                "游戏结束",
                JOptionPane.YES_NO_OPTION
            );

            if (option == JOptionPane.YES_OPTION) {
                startNewGame(game.getConfig().getLevel());
            } else {
                dispose(); // 如果选择不开始新游戏，则关闭窗口
            }
        });
    }

    /**
     * 主方法
     */
    public static void main(String[] args) {
        // 在事件调度线程中运行
        SwingUtilities.invokeLater(() -> {
            GameBoard board = new GameBoard();
            board.setVisible(true);
        });
    }
}