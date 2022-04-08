
import java.io.*;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

/**
 * 读取word文档
 * @author Pei
 *
 */
public class ReadWord {
    public static void main(String[] args) throws IOException{
        String  docx = "D:\\weather.docx" ;
        XWPFDocument document = read_file(docx);
        readPar(document, "D:\\", "", "");
        readTableContent(document);
    }

    /** * 遍历段落内容
     * docxReadPath 文档地址
     * uploadPic 图片上传地址
     * picFile 图片保存后地址
     * @param document
     * @return XWPFDocument
     * @throws IOException
     */
    public static String readPar(XWPFDocument document,String docxReadPath,String uploadPic,String picFile){
        String fail="sucess";
        Iterator<XWPFParagraph> itPara = document.getParagraphsIterator();
        try {
            PrintStream ps=new PrintStream("D:\\weather.docx");
            System.setOut(ps);
            //读取word中所有内容
            while (itPara.hasNext()) {
                XWPFParagraph paragraph = (XWPFParagraph) itPara.next();
                //run表示相同区域属性相同的字符，结果以‘，’分隔；
                List<XWPFRun> runs =paragraph.getRuns();// paragraph.getRuns();
                String fileName="";
                for (int i = 0; i < runs.size(); i++){

                    String oneparaString = runs.get(i).getText(runs.get(i).getTextPosition());

                    System.out.println(oneparaString);

                }

            }
            List<XWPFPictureData> picList = document.getAllPictures();for (XWPFPictureData pic : picList) {
                byte[] bytev = pic.getData();
                String imgName=pic.getFileName();
                System.out.println("=====图片生成中========"+imgName);
                if(!"image1.jpeg".equals(imgName)){
                    FileOutputStream fos = new FileOutputStream(uploadPic+"/"+imgName);
                    fos.write(bytev);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("=====错误信息===="+e.getMessage());
            fail="false";
        }

        return fail;
    }
    /**
     * 遍历所有表格的内容
     * @param document
     * @throws FileNotFoundException
     */
    public static void readTableContent(XWPFDocument document) {
        Iterator<XWPFTable> itTable = document.getTablesIterator();
        int ind = 0;
        while (itTable.hasNext()){
            ind++;
            XWPFTable table = (XWPFTable) itTable.next();
            //行
            int rcount = table.getNumberOfRows();
            for (int i = 0; i < rcount; i++){
                XWPFTableRow row = table.getRow(i);
                //列
                List<XWPFTableCell> cells = row.getTableCells();
                int len = cells.size();
                for(int j = 0;j < len;j++){
                    XWPFTableCell xc = cells.get(j);
                    String sc = xc.getText();
                    System.out.println("第"+ ind +"个表格，第"+ (i+1) +"行，第"+ (j+1) +"列：" +sc);
                }
            }
        }
    }
    /**
     * 读取文件
     * @param srcPath
     * @return XWPFDocument
     */
    public static XWPFDocument read_file(String srcPath)
    {
        String[] sp = srcPath.split("\\.");
        if ((sp.length > 0) && sp[sp.length - 1].equalsIgnoreCase("docx"))
        {
            try {
                FileInputStream fis = new FileInputStream(srcPath);
                XWPFDocument xdoc = new XWPFDocument(fis);
                XWPFWordExtractor extractor = new XWPFWordExtractor(xdoc);

                // OPCPackage pack = POIXMLDocument.openPackage(srcPath);
                // XWPFDocument doc = new XWPFDocument(pack);
                return xdoc;
            } catch (IOException e) {
                System.out.println("读取文件出错！");
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }



}