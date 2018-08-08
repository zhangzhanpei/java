/**
 * 分布式 ID 生成器
 * flag + millisecond + dataCenterId + machineId + sequence 共 64 位，转成 long 类型
 */
public class Snowflake {
    // 符号位，占 1 位长度
    final public static String flag = "0";

    // 上一次取 id 时的毫秒时间戳，占 41 位长度（毫秒时间戳转成二进制长度为 41）
    public static long prevMillisecond = 0;

    // 数据中心 id，占 5 位长度
    final public static String dataCenterId = "00001";

    // 机器 id，占 5 位长度
    final public static String machineId = "00001";

    // 循环自增序列号，占 12 位长度即最大值 4095
    public static short sequence = 0;

    // 生成 ID
    public static long nextId() {
        long now = System.currentTimeMillis();
        // 当前毫秒时间戳为新的一毫秒时，循环自增序列号重置为 0
        if (now != prevMillisecond) {
            prevMillisecond = now;
            sequence = 0;
        } else {
            sequence++;
        }
        // 循环自增序列号转成二进制后前面补零，使长度固定为 12 位
        String binarySequence = "00000000000" + Integer.toBinaryString(sequence);
        binarySequence = binarySequence.substring(binarySequence.length() - 12);
        // 拼接
        String id = String.format("%s%s%s%s%s", flag, Long.toBinaryString(now), dataCenterId, machineId, binarySequence);
        // 转成 long 类型返回
        return Long.parseLong(id, 2);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(nextId());
        }
    }
}
