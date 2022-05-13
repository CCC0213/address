import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessTest {
    public static void main(String[] args) {

        String pathFile="D:\\log1.txt";
        RandomAccessFile randomAccessFile = null;

        try {
            randomAccessFile=new RandomAccessFile(pathFile,"rw");
            long length1= randomAccessFile.length();
            randomAccessFile.seek(length1);
            //byte[] bytes = new byte[4] ;
            //int readLength=0;
            /*while ((readLength = randomAccessFile.read(bytes)) !=-1){
                System.out.print(new String(bytes,0,readLength));
            }*/
            randomAccessFile.write("jave".getBytes());
            System.out.printf("写入成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {//关闭流
            try {
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
