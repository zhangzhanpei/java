import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileDemo {
    public static void main(String[] args) {
        // 创建一个 path
        Path path = Paths.get("./src/test.txt");

        // 判断文件是否存在
        System.out.println(Files.exists(path));

        // 创建一个文件
        Path config = Paths.get("./src/config.txt");
        try {
            // 需判断文件不存在，如果文件已存在继续创建则抛出异常
            if (Files.notExists(config)) {
                Files.createFile(config);
            }
        } catch (IOException e) {

        }

        // 创建一个文件夹
        Path dir = Paths.get("./src/config");
        try {
            // createDirectories 方法可以创建多层的文件夹，如果文件夹已存在继续创建则抛出异常
            // createDirectory 方法只可以创建一层文件夹
            Files.createDirectories(dir);
        } catch (FileAlreadyExistsException e) {

        } catch (IOException e) {

        }

        // 删除文件夹
        try {
            Files.deleteIfExists(dir);
        } catch (IOException e) {

        }

        // 读取文件
        try {
            // 读取文件全部内容
            String str = new String(Files.readAllBytes(path));
            System.out.println(str);
            // 按行读取
            Files.lines(path).forEach(l -> System.out.println(l));
        } catch (IOException e) {

        }

        // 写文件
        try {
            // true 即追加写
            FileWriter writer = new FileWriter("./src/test.txt", true);
            writer.write("\n");
            writer.write("888");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
