import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Tetris_Frame extends JFrame {
    Container cp;
    int FrameW=1800,FrameH=900;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Tetris_Frame (){
        init();
    }

    private void init (){
        this.setTitle("Tetris Battle_v0.001");
//        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        this.setBounds(0,0,FrameW,FrameH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        this.setResizable(false);
        cp=this.getContentPane();
        cp.setLayout(null);
        cp.setBackground(new Color(25, 85, 15));
        /*
            TetrisPane是用來畫遊戲畫面的,包括方塊and動作
         */
        TetrisPane tp = new TetrisPane();
        tp.setBounds(100,80,700,700);
        cp.add(tp);
        tp.setPreferredSize(new Dimension(700,700));
    }
}


class TetrisPane extends JPanel {
    /*  宣告背景陣列  */
    public int map[][] = new int[10][20];
    /*  宣告方塊圖片  */
    private Image backimage1;
    private Image backimage2;

    public TetrisPane() {
        this.setLayout(null);
//        this.setBackground(Color.BLACK);
        this.setBackground(new Color(63, 61, 64));
        /*   指定圖片檔位置   */
        try{
            backimage1 = ImageIO.read(getClass().getResource("Tetris_image/bg1.png"));
            backimage2 = ImageIO.read(getClass().getResource("Tetris_image/bg2.png"));
        }catch (IOException io){
            io.printStackTrace();
        }
        /*  不明原因,toolkit的圖片讀取方式不能用*/
//        backimage1=Toolkit.getDefaultToolkit().getImage("Tetris_image/bg1.png");
//        backimage2=Toolkit.getDefaultToolkit().getImage("Tetris_image/bg2.png");
        /*  初始化背景陣列  */
        initmap();
        /*  宣告Timer  */
        Timer t1 = new Timer(2000, new TimerListener());
        t1.start();
    }
    /*  背景陣列全部設成0*/
    private void initmap() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = 0;
            }
        }
    }

    /*  swing用來畫圖的方法,awt中不用重寫方法,但是swing需要重寫*/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(backimage1,500,500,null);
//        g.drawImage(backimage1,132,132,null);
//        g.drawImage(backimage2,132,164,null);
//        g.drawImage(backimage2,800,500,null);
//        int x = 0, y = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                /*  奇數就用背景圖2,偶數就用背景圖1*/
                if (map[i][j] == 0) {
                    if ((i + j) % 2 == 0) {
                        /*  背景圖1,位置x:,位置y:*/
                        g.drawImage(backimage1, i*30+3*(i+1)+175, j*30+3*(j+1), null);
//                        g.drawImage(backimage1,  j*32+190, i*32, null);
//                        System.out.println(++x);
//                        System.out.println(i*30+3*(i+1)+150);
//                        System.out.println(j*30+3*(j+1));
                    } else {
                        g.drawImage(backimage2, i*30+3*(i+1)+175, j*30+3*(j+1), null);
//                        g.drawImage(backimage2,  j*32+190, i*32, null);
//                        System.out.println(++y);
                    }
                }else{
                }
            }
        }
    }
    class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
}
