
import java.io.*;

import net.sf.json.JSONArray;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.POIXMLTextExtractor;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFPictureData;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblPr;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.SplittableRandom;

public class ge {


    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("D:\\weather.docx");
        XWPFDocument doc = new XWPFDocument(is);
        List<XWPFParagraph> paras = doc.getParagraphs();

            for (XWPFParagraph para : paras) {
                //当前段落的属性
                while(para.getText().startsWith("本场天气")){
                    System.out.println(para.getText());
                    break;
                }
            }

        List<XWPFTable> tables = doc.getTables();
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;

        for (XWPFTable table : tables) {
            //格属性
            CTTblPr pr = table.getCTTbl().getTblPr();
            //获取表格对应的行
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                //获取行对应的单元格
                cells = row.getTableCells();

                for (XWPFTableCell cell : cells) {

                    while(cell.getText().startsWith("布时间")){
                        System.out.println(cell.getText());
                        String[] split1 = cell.getText().split("：");
                        JSONArray json1 = JSONArray.fromObject(split1 );
                        System.out.println(json1);
                        break;
                    }
                }
                for (XWPFTableCell cell : cells) {

                    while(cell.getText().startsWith("本场天气")){
                        System.out.println(cell.getText());
                        int  a= cell.getText().indexOf("本场天气");
                        int  b= cell.getText().indexOf("km");
                        String ab= cell.getText().substring(a+4,b+2);
                        int  c= cell.getText().indexOf("km");
                        int d = cell.getText().indexOf("km",b+1);
                        //d=cell.getText().indexOf("：",d+1);
                        String cd= cell.getText().substring(c+2,d+2);

                        int f =cell.getText().length();
                        String ef= cell.getText().substring(d+2,f);
                        System.out.println(ab);
                        System.out.println(cd);
                        System.out.println(ef);
                        System.out.println(cell.getText());
                        String[] split1 = ab.split("：");
                        String[] split2 = cd.split("：");
                        String[] split3 = ef.split("：");
                        JSONArray json1 = JSONArray.fromObject(split1 );
                        JSONArray json2 = JSONArray.fromObject(split2 );
                        JSONArray json3 = JSONArray.fromObject(split3 );
                        System.out.println(json1);
                        System.out.println(json2);
                        System.out.println(json3);
                        break;
                    }
                }
            }
        }

    }
        //读取文件路径
       /* OPCPackage opcPackage = null;
        String content = null;
        List<String> docxList = new ArrayList<String>();
        try {
            opcPackage = POIXMLDocument.openPackage(request.getSession().getServletContext().getRealPath(fileUrl));
            XWPFDocument xwpf = new XWPFDocument(opcPackage);
            POIXMLTextExtractor poiText = new XWPFWordExtractor(xwpf);
            content = poiText.getText();
            docxList.add(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return docxList;*/






}
