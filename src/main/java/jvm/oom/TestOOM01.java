package jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * -XX:+PrintGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCDateStamps
 * -Xloggc:C:\Users\ligj\Downloads\gc.log
 * <p>
 * -Xmx20m -Xms5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/a.dump
 * <p>
 * 其中：
 * 1)-XX:+HeapDumpOnOutOfMemoryError，使用该参数，可以在内存溢出时导出整个堆信息
 * 2)-XX:HeapDumpPath 配合如上参数可以指定导出堆的存放路径。
 */
//调整堆大小 -Xmx1g
public class TestOOM01 {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        try {
            List<byte[]> list = new ArrayList<>();
            for (int i = 0; i < 25; i++) {
                list.add(new byte[1024 * 1024]);
            }
        } finally {
            long t2 = System.currentTimeMillis();
            System.out.println("oom:" + (t2 - t1));
        }
    }
}
