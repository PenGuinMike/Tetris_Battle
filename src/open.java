import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class open extends JFrame {
    private JButton server=new JButton("sever");
    private JButton client  =new JButton("client");
    private int choose;
    public open(){
        this.setBounds(500,500,400,200);
        this.setLayout(null);
        server.setBounds(100,50,100,30);
        client.setBounds(100,100,100,30);
        this.add(server);
        this.add(client);
        server.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choose=0;
//                Tetris_Frame tf = new Tetris_Frame(choose);
                Tetris_Frame tf = new Tetris_Frame();
                tf.setVisible(true);
                try{
                    ServerSocket svs=new ServerSocket(2222);
                    Socket s=svs.accept();
                    OutputStream out=s.getOutputStream();
                    out.close();

                }catch (Exception e1){
                    System.out.println(e1);

                }
            }
        });
        client.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choose=1;
//                Tetris_Frame tf2 = new Tetris_Frame(choose);
                Tetris_Frame tf2 = new Tetris_Frame();
                tf2.setVisible(true);

                try{
                    Socket s=new Socket("127.0.0.1",2222);
                    InputStream in=s.getInputStream();
                    in.close();
                    s.close();

                }catch (Exception e1){
                    System.out.println(e1);

                }

        }
        });
        }
    }
