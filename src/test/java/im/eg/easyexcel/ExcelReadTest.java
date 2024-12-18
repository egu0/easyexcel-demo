package im.eg.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import im.eg.easyexcel.dto.ExcelStudentDto;
import im.eg.easyexcel.listener.ExcelStudentDtoListener;
import org.junit.Test;

public class ExcelReadTest {
    @Test
    public void simpleReadXlsxTest() {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + "/simpleExcel.xlsx";
        EasyExcel.read(filePath, ExcelStudentDto.class, new ExcelStudentDtoListener())
                .sheet().doRead();
    }

    @Test
    public void simpleReadXlsTest() {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + "/simpleExcel.xls";
        EasyExcel.read(filePath, ExcelStudentDto.class, new ExcelStudentDtoListener())
                .excelType(ExcelTypeEnum.XLS) // 指定類型
                .sheet().doRead();
    }
}
