import com.tree.util.Calculate;
import com.tree.util.FileUtil;
import org.junit.jupiter.api.Test;

/**
 * @author lucifer
 */
public class CaculateTest {

    /**
     * 测试句子
     */
    @Test
    public void sentence(){
        String source = "我们去打球";
        String fake = "我们去学习";
        double res = Calculate.caculate(source,fake);
        assert res < 1;
    }

    /**
     *  测试与自身查重
     */
    @Test
    public void orig(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        double res = Calculate.caculate(source,fake);
        assert res == 1;
    }

    /**
     *  测试与增加版查重
     */
    @Test
    public void orig_add(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig_0.8_add.txt");
        double res = Calculate.caculate(source,fake);
        assert res <= 1;
    }

    /**
     *  测试与删减版查重
     */
    @Test
    public void orig_del(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig_0.8_del.txt");
        double res = Calculate.caculate(source,fake);
        assert res <= 1;
    }

    /**
     *  测试orig_0.8_dis_1.txt
     */
    @Test
    public void orig_dis(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig_0.8_dis_1.txt");
        double res = Calculate.caculate(source,fake);
        assert res <= 1;
    }

    /**
     *  测试orig_0.8_dis_10.txt
     */
    @Test
    public void orig_dis2(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig_0.8_dis_10.txt");
        double res = Calculate.caculate(source,fake);
        assert res <= 1;
    }

    /**
     *  测试orig_0.8_dis_15.txt
     */
    @Test
    public void orig_dis3(){
        String source = FileUtil.fileToString("src/main/resources/testFile/orig.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/orig_0.8_dis_15.txt");
        double res = Calculate.caculate(source,fake);
        assert res <= 1;
    }

    /**
     * 测试自己编写的文本
     */
    @Test
    public void testOwnFile(){
        String source = FileUtil.fileToString("src/main/resources/testFile/testFileUtil.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile/testFileUtil.txt");
        double res = Calculate.caculate(source,fake);
        assert res == 1;
    }

    /**
     * 测试自己编写的文本
     */
    @Test
    public void testOwnFileWithCopy(){
        String source = FileUtil.fileToString("src/main/resources/testFile/testFileUtil.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile//testFileUtil_copy.txt");
        double res = Calculate.caculate(source,fake);
        assert res == 1;
    }

    /**
     * 测试自己编写的文本
     */
    @Test
    public void testOwnFileWithAdd(){
        String source = FileUtil.fileToString("src/main/resources/testFile/testFileUtil.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile//testFileUtil_add.txt");
        double res = Calculate.caculate(source,fake);
        assert res < 1;
    }

    /**
     * 测试自己编写的文本
     */
    @Test
    public void testOwnFileWithDel(){
        String source = FileUtil.fileToString("src/main/resources/testFile/testFileUtil.txt");
        String fake = FileUtil.fileToString("src/main/resources/testFile//testFileUtil_del.txt");
        double res = Calculate.caculate(source,fake);
        assert res < 1;
    }

}
