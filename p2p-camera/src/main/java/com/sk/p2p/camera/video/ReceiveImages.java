package com.sk.p2p.camera.video;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipInputStream;

/**
 * Created by wsj on 2018/8/15.
 */
public class ReceiveImages extends Thread {
        public BorderInit frame ;
        public Socket socket;
        public String IP;

    public static void main(String[] args){
        new ReceiveImages(new BorderInit(),"172.30.3.209").start();
    }
    //接收图片
    public ReceiveImages(BorderInit frame,String IP){
        this.frame = frame;
        this.IP=IP;
    }
    //实现run方法
    public void run() {
        while(frame.getFlag()){
            try {
                socket = new Socket(IP,12122);
                DataInputStream ImgInput = new DataInputStream(socket.getInputStream());
                ZipInputStream imgZip = new ZipInputStream(ImgInput);

                imgZip.getNextEntry(); //到Zip文件流的开始处
                Image img = ImageIO.read(imgZip);  //按照字节读取Zip图片流里面的图片
                frame.jlbImg.setIcon(new ImageIcon(img));
                System.out.println("连接第"+(System.currentTimeMillis()/1000)%24%60+"秒");
                frame.validate();
                TimeUnit.MILLISECONDS.sleep(1);// 接收图片间隔时间
                imgZip.close();


            } catch (IOException | InterruptedException e) {
                System.out.println("连接断开");
            }finally{
                try {
                    socket.close();
                } catch (IOException e) {}
            }
        }
    }
}
