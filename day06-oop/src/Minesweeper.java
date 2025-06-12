import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Minesweeper extends JFrame {
    private final int EASY_ROWS = 9;
    private final int EASY_COLS = 9;
    private final int EASY_MINES = 10;

    private final int MEDIUM_ROWS = 16;
    private final int MEDIUM_COLS = 16;
    private final int MEDIUM_MINES = 40;

    private final int HARD_ROWS = 16;
    private final int HARD_COLS = 30;
    private final int HARD_MINES = 99;

    private int rows = EASY_ROWS;
    private int cols = EASY_COLS;
    private int totalMines = EASY_MINES;
    private int flagsPlaced = 0;
    private int moves = 0;

    private char[][] board;
    private char[][] display;
    private boolean gameOver;
    private boolean gameWon;
    private int revealedCells;

    private JPanel boardPanel;
    private JLabel statusLabel;
    private JLabel movesLabel;
    private JLabel flagsLabel;
    private JButton[][] buttons;

    private ImageIcon flagIcon;
    private ImageIcon mineIcon;

    public Minesweeper() {
        // 加载图标
        loadIcons();

        // 创建游戏数据
        initializeBoard();

        // 设置主窗口
        setTitle("Java扫雷游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setResizable(false);

        // 创建菜单栏
        createMenuBar();

        // 创建控制面板
        createControlPanel();

        // 创建游戏面板
        createBoardPanel();

        // 添加组件
        add(boardPanel, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void loadIcons() {
        // 创建旗帜图标（红色旗帜）
        flagIcon = new ImageIcon(createFlagIcon(24, 24));

        // 创建地雷图标（黑色地雷）
        mineIcon = new ImageIcon(createMineIcon(24, 24));
    }

    private Image createFlagIcon(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        // 设置抗锯齿
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制旗杆
        g2.setColor(new Color(100, 100, 100));
        g2.fillRect(width/2-1, height/4, 3, height*3/4);

        // 绘制旗帜
        g2.setColor(Color.RED);
        Polygon flag = new Polygon();
        flag.addPoint(width/2-1, height/4+5);
        flag.addPoint(width*3/4, height/4+15);
        flag.addPoint(width/2-1, height/4+25);
        g2.fill(flag);

        g2.dispose();
        return image;
    }

    private Image createMineIcon(int width, int height) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();

        // 设置抗锯齿
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // 绘制地雷主体
        g2.setColor(Color.BLACK);
        g2.fillOval(width/4, height/4, width/2, height/2);

        // 绘制高光
        g2.setColor(Color.WHITE);
        g2.fillOval(width/3, height/3, width/8, height/8);

        // 绘制顶部
        g2.setColor(Color.DARK_GRAY);
        g2.fillOval(width/3, height/5, width/3, height/6);

        g2.dispose();
        return image;
    }

    private void initializeBoard() {
        board = new char[rows][cols];
        display = new char[rows][cols];
        buttons = new JButton[rows][cols];
        gameOver = false;
        gameWon = false;
        revealedCells = 0;
        flagsPlaced = 0;
        moves = 0;

        // 初始化显示板（全部覆盖）
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                display[i][j] = '-';
            }
        }

        // 初始化游戏板（全部置空）
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = '0';
            }
        }

        // 随机布置地雷
        Random rand = new Random();
        int minesPlaced = 0;
        while (minesPlaced < totalMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (board[r][c] != 'M') {
                board[r][c] = 'M';
                minesPlaced++;

                // 更新周围格子的数字
                for (int dr = -1; dr <= 1; dr++) {
                    for (int dc = -1; dc <= 1; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        int nr = r + dr, nc = c + dc;
                        if (nr >= 0 && nr < rows && nc >= 0 && nc < cols && board[nr][nc] != 'M') {
                            board[nr][nc]++;
                        }
                    }
                }
            }
        }
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu gameMenu = new JMenu("游戏");

        JMenuItem newGameItem = new JMenuItem("新游戏");
        newGameItem.addActionListener(e -> restartGame());

        JMenuItem easyItem = new JMenuItem("初级 (9x9, 10雷)");
        easyItem.addActionListener(e -> setDifficulty(EASY_ROWS, EASY_COLS, EASY_MINES));

        JMenuItem mediumItem = new JMenuItem("中级 (16x16, 40雷)");
        mediumItem.addActionListener(e -> setDifficulty(MEDIUM_ROWS, MEDIUM_COLS, MEDIUM_MINES));

        JMenuItem hardItem = new JMenuItem("高级 (16x30, 99雷)");
        hardItem.addActionListener(e -> setDifficulty(HARD_ROWS, HARD_COLS, HARD_MINES));

        JMenuItem exitItem = new JMenuItem("退出");
        exitItem.addActionListener(e -> System.exit(0));

        gameMenu.add(newGameItem);
        gameMenu.addSeparator();
        gameMenu.add(easyItem);
        gameMenu.add(mediumItem);
        gameMenu.add(hardItem);
        gameMenu.addSeparator();
        gameMenu.add(exitItem);

        menuBar.add(gameMenu);
        setJMenuBar(menuBar);
    }

    private void createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        movesLabel = new JLabel("步数: 0"); // 确保文字为系统支持的编码
        movesLabel.setFont(new Font("Arial", Font.BOLD, 16));
        movesLabel.setForeground(new Color(0, 100, 0));

        flagsLabel = new JLabel("旗帜: " + flagsPlaced + " / " + totalMines); // 同理
        flagsLabel.setFont(new Font("Arial", Font.BOLD, 16));
        flagsLabel.setForeground(Color.BLUE);

        statusLabel = new JLabel("游戏中..."); // 同理
        statusLabel.setFont(new Font("Arial", Font.BOLD, 16));
        statusLabel.setForeground(Color.BLACK);

        JButton restartButton = new JButton("重新开始");
        restartButton.setFont(new Font("Arial", Font.BOLD, 14));
        restartButton.setBackground(new Color(70, 130, 180));
        restartButton.setForeground(Color.WHITE);
        restartButton.addActionListener(e -> restartGame());

        controlPanel.add(movesLabel);
        controlPanel.add(statusLabel);
        controlPanel.add(flagsLabel);
        controlPanel.add(restartButton);

        add(controlPanel, BorderLayout.NORTH);
    }

    private void createBoardPanel() {
        boardPanel = new JPanel(new GridLayout(rows, cols));
        boardPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                JButton button = new JButton();
                button.setPreferredSize(new Dimension(30, 30));
                button.setFont(new Font("Arial", Font.BOLD, 14));
                button.setFocusPainted(false);
                button.setOpaque(true); // 关键：强制按钮显示背景色
                button.setBackground(new Color(200, 200, 200)); // 初始未点击的格子背景色

                final int r = i;
                final int c = j;

                // 左键点击事件（揭示格子）
                button.addActionListener(e -> {
                    if (!gameOver && !gameWon && display[r][c] == '-') {
                        reveal(r, c);
                        moves++;
                        movesLabel.setText("步数: " + moves);
                        updateBoard();
                        checkGameStatus();
                    }
                });

                // 右键点击事件（放置/移除旗帜）
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (!gameOver && !gameWon) {
                            if (SwingUtilities.isRightMouseButton(e) && display[r][c] != 'F') {
                                // 放置旗帜
                                display[r][c] = 'F';
                                flagsPlaced++;
                                flagsLabel.setText("旗帜: " + flagsPlaced + " / " + totalMines);
                                buttons[r][c].setIcon(flagIcon);
                            } else if (SwingUtilities.isRightMouseButton(e) && display[r][c] == 'F') {
                                // 移除旗帜
                                display[r][c] = '-';
                                flagsPlaced--;
                                flagsLabel.setText("旗帜: " + flagsPlaced + " / " + totalMines);
                                buttons[r][c].setIcon(null);
                            }
                        }
                    }
                });

                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }
    }

    private void reveal(int row, int col) {
        // 检查是否越界或已揭示
        if (row < 0 || row >= rows || col < 0 || col >= cols || display[row][col] != '-' && display[row][col] != 'F') {
            return;
        }

        // 如果格子被标记为旗帜，则不揭示
        if (display[row][col] == 'F') {
            return;
        }

        // 踩到地雷
        if (board[row][col] == 'M') {
            gameOver = true;
            revealAllMines();
            statusLabel.setText("游戏结束！踩到地雷！");
            statusLabel.setForeground(Color.RED);
            return;
        }

        // 显示当前格子
        display[row][col] = board[row][col];
        revealedCells++;

        // 如果是空白格，递归揭示周围
        if (board[row][col] == '0') {
            for (int dr = -1; dr <= 1; dr++) {
                for (int dc = -1; dc <= 1; dc++) {
                    if (dr == 0 && dc == 0) continue;
                    reveal(row + dr, col + dc);
                }
            }
        }
    }

    private void revealAllMines() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'M') {
                    display[i][j] = 'M';
                }
            }
        }
    }

    private void checkGameStatus() {
        if (revealedCells == rows * cols - totalMines) {
            gameWon = true;
            statusLabel.setText("恭喜！你赢了！");
            statusLabel.setForeground(new Color(0, 150, 0));
        }
    }

    private void updateBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char cell = display[i][j];
                JButton button = buttons[i][j];

                button.setOpaque(true); // 确保背景可见
                button.setIcon(null);   // 重置图标
                button.setText("");     // 重置文字
                button.setForeground(Color.BLACK); // 重置前景色（数字颜色后续单独设置）

                // 根据单元格状态设置背景和样式
                if (cell == '-') {
                    // 未点击的格子：浅灰色背景
                    button.setBackground(new Color(200, 200, 200));
                } else if (cell == 'F') {
                    // 旗帜标记：显示旗帜图标 + 浅灰色背景
                    button.setIcon(flagIcon);
                    button.setBackground(new Color(200, 200, 200));
                } else if (cell == 'M') {
                    // 地雷：显示地雷图标 + 红色背景
                    button.setIcon(mineIcon);
                    button.setBackground(Color.RED);
                } else if (cell >= '1' && cell <= '8') {
                    // 数字提示：显示数字 + 浅灰色背景 + 对应颜色数字
                    button.setText(String.valueOf(cell));
                    // 数字颜色映射
                    switch (cell) {
                        case '1': button.setForeground(Color.BLUE); break;
                        case '2': button.setForeground(new Color(0, 128, 0)); break;
                        case '3': button.setForeground(Color.RED); break;
                        case '4': button.setForeground(new Color(0, 0, 128)); break;
                        case '5': button.setForeground(new Color(128, 0, 0)); break;
                        case '6': button.setForeground(new Color(0, 128, 128)); break;
                        case '7': button.setForeground(Color.BLACK); break;
                        case '8': button.setForeground(Color.GRAY); break;
                    }
                    button.setBackground(Color.LIGHT_GRAY);
                } else if (cell == '0') {
                    // 空白格：浅灰色背景（自动展开区域）
                    button.setBackground(Color.LIGHT_GRAY);
                }
            }
        }
    }

    private void setDifficulty(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.totalMines = mines;
        restartGame();
    }

    private void restartGame() {
        boardPanel.removeAll();
        initializeBoard();
        createBoardPanel();
        moves = 0;
        movesLabel.setText("步数: " + moves);
        flagsLabel.setText("旗帜: " + flagsPlaced + " / " + totalMines);
        statusLabel.setText("游戏中...");
        statusLabel.setForeground(Color.BLACK);
        pack();
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                e.printStackTrace();
            }
            new Minesweeper();
        });
    }
}