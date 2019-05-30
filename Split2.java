package split;

import java.io.*;

public class Split2 {
    public static void Split(String srcfile,int fileSize,String destfile) throws IOException {
        if(srcfile==null||srcfile.isEmpty()||fileSize==0||destfile==null||destfile.isEmpty()){
            throw new IllegalArgumentException("split is filad");
        }
        File srcfiles=new File(srcfile);  //源文件
        long srcSize=srcfiles.length(); //源文件大小
        long destSize=1024*fileSize; //目标文件的大小
        int m= (int) (srcSize/destSize);  //拆分后的数目
        m=srcSize%destSize==0?m:m+1;
        String fileName=srcfile.substring(srcfile.lastIndexOf("\\"));//源文件名
        InputStream in=null;
        BufferedInputStream b=null;
        byte[] buff=new byte[1024*1024];
        int len=-1;
            try {
                in=new FileInputStream(srcfiles);
                b=new BufferedInputStream(in);
                for(int i=0;i<m;i++){
                    String destName=destfile+File.separator+fileName+"-"+i+".jpg";
                    OutputStream out=new FileOutputStream(destName);
                    BufferedOutputStream bo=new BufferedOutputStream(out);
                    int count=0;
                    while((len=b.read(buff))!=-1){
                        bo.write(buff,0,len);//写入
                        count+=len;
                        if(count>=destSize){
                            break;
                        }
                    }
                    bo.flush();;
                    bo.close();;
                    out.close();
            }
        }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }finally{
                try {
                    if (b != null) {
                        b.close();
                    }
                    if (in != null) {
                        in.close();
                    }
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

    }

    public static void main(String[] args) throws IOException {
        String srcfile="D:\\test5.25\\B\\total.txt";
        int FileSize=1;
        String destfile="D:\\test5.25\\";
        Split(srcfile,  FileSize,destfile);
        System.out.println("拆分完成");

    }
}
