package lv.aaa.util;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;
import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;

/**
 * @author lvweichen 🛺 ☁ ☁ ☁ …… ️🏃
 * @date 2022/6/21 下午4:42
 */
public class BinlogConsumer {
    public static void main(String[] args) throws Exception {
        BinaryLogClient logClient = new BinaryLogClient(
                "127.0.0.1", 3306, "test", "root", "1234"
        );
        logClient.registerEventListener(event -> {
            EventData data = event.getData();
            // 如果日志是更新记录
            if(data instanceof UpdateRowsEventData){
                long tableId = ((UpdateRowsEventData) data).getTableId();
                System.out.println("update: " + tableId);
            }else if(data instanceof WriteRowsEventData){
                long tableId = ((WriteRowsEventData) data).getTableId();
                // 如果日志是写操作
                
                System.out.println("write: " + tableId);
            }else if(data instanceof DeleteRowsEventData){
                long tableId = ((DeleteRowsEventData) data).getTableId();
                // 如果日志是删除操作
                System.out.println("delete: " + tableId);
            }
        });

        // 开始监听
        logClient.connect();
    }
}
