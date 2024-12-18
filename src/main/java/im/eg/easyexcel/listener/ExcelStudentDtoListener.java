package im.eg.easyexcel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import im.eg.easyexcel.dto.ExcelStudentDto;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExcelStudentDtoListener extends AnalysisEventListener<ExcelStudentDto> {
    @Override
    public void invoke(ExcelStudentDto data, AnalysisContext context) {
        log.info("解析到一條數據: {}", data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("所有數據處理完成！");
    }
}
