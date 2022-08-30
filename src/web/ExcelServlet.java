package web;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;


@WebServlet("/Excel")
public class ExcelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
            HSSFSheet sheet = hssfWorkbook.createSheet("订单报表");//创建工作表
            HSSFRow row = sheet.createRow(0);//创建首行
            String[] title = {"商品名称","商品价格","购买数量","下单时间","所属订单号"};
            for (int i = 0; i <title.length ; i++) {
                row.createCell(i).setCellValue(title[i]);//赋值给表头
            }
            HttpSession session = request.getSession();
            List<Map<String, String>> list = (List<Map<String, String>>) session.getAttribute("orderItem");
            for (int i = 0; i <list.size() ; i++) {
                HSSFRow row1=sheet.createRow(i+1);//创建行
                String[] content = {list.get(i).get("title"),list.get(i).get("price"),list.get(i).get("num"),
                        list.get(i).get("order_time"),list.get(i).get("oid")};
                for (int j = 0; j < content.length; j++) {
                    row1.createCell(j).setCellValue(content[j]);//赋值给单元格
                }
            }
            String fname = "订单报表"+System.currentTimeMillis()+".xls";//文件名
            String restName = new String(fname.getBytes(),"ISO-8859-1");//设置fname的编码
            response.setContentType("application/vnd.ms-excel");//设置为Excel表格格式
            response.setHeader("Content-Disposition", "attachment;filename="+restName);
            ServletOutputStream out = response.getOutputStream();
            hssfWorkbook.write(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
