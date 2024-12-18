package im.eg.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import im.eg.easyexcel.dto.ExcelStudentDto;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ExcelWriteTest {

    // 以 xlsx 為後綴的文檔最多能寫 1048575 行：
    // java.lang.IllegalArgumentException: Invalid row number (1048576) outside allowable range (0..1048575)
    @Test
    public void simpleWriteXlsxTest() {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + "/simpleExcel.xlsx";
        EasyExcel.write(filePath, ExcelStudentDto.class)
                .sheet("模板").doWrite(data());
    }

    // 注意：xls 後綴的文檔最多只能寫 65536 行，超過時會報錯：
    // java.lang.IllegalArgumentException: Invalid row number (65536) outside allowable range (0..65535)
    @Test
    public void simpleWriteXlsTest() {
        String projectRoot = System.getProperty("user.dir");
        String filePath = projectRoot + "/simpleExcel.xls";
        EasyExcel.write(filePath, ExcelStudentDto.class)
                .excelType(ExcelTypeEnum.XLS) // 傳遞類型
                .sheet("模板").doWrite(data());
    }

    private List<ExcelStudentDto> data() {
        List<ExcelStudentDto> list = new ArrayList<ExcelStudentDto>();
        for (int i = 0; i < 10; i++) {
            ExcelStudentDto data = new ExcelStudentDto();
            data.setName("字符串" + i);
            data.setBirthday(new Date());
            data.setSalary(0.56);
            list.add(data);
        }
        return list;
    }

}