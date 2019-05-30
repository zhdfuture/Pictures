package split;

import java.io.*;

public class joining {
    public static void main(String[] args) {
        try(FileInputStream fa=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\images\\car.jpg");
            FileInputStream fb=new FileInputStream("C:\\Users\\Lenovo\\Desktop\\images\\house.jpg");
            FileOutputStream fout=new FileOutputStream("D:\\test5.25\\B\\total.txt");
            ByteArrayOutputStream memorystream=new ByteArrayOutputStream())
        {
            byte[] buff=new byte[1024];
            int len=-1;
            while((len=fa.read(buff))!=-1){
                memorystream.write(buff,0,len);
            }
            while (((len=fb.read(buff))!=-1)){
                memorystream.write(buff,0,len);
            }

            byte[] newdata =memorystream .toByteArray();
            fout.write(newdata);
            fout.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}

