import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyListener;

public class Tetris_Frame extends JFrame {
    Container cp;
    int FrameW=1600,FrameH=900;
    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public Tetris_Frame (){
        init();
    }

    private void init (){
        this.setTitle("Tetris Battle_v0.001");
        this.setBounds(dim.width/2-FrameW/2,dim.height/2-FrameH/2,FrameW,FrameH);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        cp=this.getContentPane();
        TetrisPane tp = new TetrisPane();
        tp.setBounds(50,50,700,700);
        this.add(tp);
        tp.setPreferredSize(new Dimension(700,700));
    }
}


class TetrisPane extends JPanel {
    public int map [][]  = new int[10][20];
    private Image backimage1,backimage2;

    public  TetrisPane(){
        this.setLayout(null);
//        this.setBackground(Color.BLACK);
        backimage1=Toolkit.getDefaultToolkit().getImage("Tetris_image/bg1");
        backimage2=Toolkit.getDefaultToolkit().getImage("Tetris_image/bg2");
        initmap();
    }

    private void initmap(){
        for(int i=0;i<10;i++){
            for(int j=0;j<20;j++){
                map[i][j]=0;
            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backimage1,0,0,null);
        g.drawImage(backimage2,32,0,null);
//        for (int i = 0; i < 20; i++) {
//            for (int j = 0; j < 10; j++) {
//                if (map[i][j] == 0) {
//                    if ((i + j) % 2 == 0)
//                        g.drawImage(backimage1, j * 32 + 190, i * 32, null);
//                    else
//                        g.drawImage(backimage2, j * 32 + 190, i * 32, null);
//                }
//            }
//        }
    }
}