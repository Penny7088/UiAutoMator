package penny.com.ui_auto.util;

import android.os.Environment;
import android.util.Log;

import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created on 2017/7/8 0008.
 * by penny
 */

public class FileUtil {


    public void getSystemPhotoPath() {
        File sd = Environment.getExternalStorageDirectory();
        String path = sd.getPath() + File.separator + "peny" + File.separator;
        Log.e("===", path);
    }

    public static boolean writeFile(String pS) {
        File sd = Environment.getExternalStorageDirectory();
        String path = sd.getPath() + File.separator + "peny" + File.separator;
        try {
            Log.d("==writeFile===",path);
            File file = new File(Environment.getExternalStorageDirectory(),
                    "abc.txt");
            // 打开一个写文件器，构造函数中的第二个参数true表示以追加形式写文件
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true)));
            out.write(pS);
            out.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}