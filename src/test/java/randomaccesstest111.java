import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class randomaccesstest111 {
    public static void main(String[] args) throws IOException {
        String path = "D:\\log1.txt";
        int index = 3;
        String content = "Java";
        appendContent(path,index,content);
    }

    /**
     * 往文件中指定位置写入内容
     * @param path ：指定文件
     * @param index ：指定文件中位置
     * @param content ：追加的内容
     */
    public static void appendContent(String path,Integer index, String content) {
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件不存在");
            return;
        }

        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(file,"rws");//创建读写模式创建RandomAccessFile对象

            //检验插入位置合法性
            if (index > raf.length()) {
                System.out.println("插入位置越界");
                return;
            }

            //创建临时文件
            File tempFile = new File("D:\\log2.txt");

            //程序退出时删除临时文件
            //tempFile.deleteOnExit();

            RandomAccessFile tempRaf = new RandomAccessFile(tempFile,"rw");

            //移动指针偏移量到指定位置
            raf.seek(index);

            //把原文件index后的内容读取出来存储到临时文件中
            byte[] bytes = new byte[100];
            int readLen = 0;
            while((readLen = raf.read(bytes)) != -1) {
                tempRaf.write(bytes,0,readLen);
            }

            //让文件指针再次移动到指定位置
            raf.seek(index);

            //将追加内容写入
            raf.write(content.getBytes());
            //移动临时文件中的指针偏移量到0
            tempRaf.seek(0);
            //将临时文件中的内容写入原文件
            while((readLen = tempRaf.read(bytes)) != -1) {
                raf.write(bytes,0,readLen);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {//关闭流
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}