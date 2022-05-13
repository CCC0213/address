import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileTest01 {
    public static void main(String[] args) {
        String pathFile = "D:\\bonc\\eDiary\\Readme.txt";
        RandomAccessFile randomAccessFile = null;

        try {
            randomAccessFile = new RandomAccessFile(pathFile, "r"); // r 只读模式
            //移动文件记录指针的位置
            randomAccessFile.seek(3);

            byte[] bytes = new byte[4];
            int readLength = 0;

            while ((readLength = randomAccessFile.read(bytes)) != -1) {
                System.out.print(new String(bytes,0,readLength));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {//关闭流
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