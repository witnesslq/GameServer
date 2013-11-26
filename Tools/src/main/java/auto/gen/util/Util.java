package auto.gen.util;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-5
 * Time: 下午6:24
 */
public class Util {
    /**
     * 将第一个字符转换成大写
     *
     * @param str 源字符串
     * @return 转换后的字符串
     */
    public static String firstToUpperCase(String str) {
        return str.replaceFirst(str.substring(0, 1), str.substring(0, 1).toUpperCase());
    }

    public static String firstToLowCase(String src) {
        return src.replaceFirst(src.substring(0, 1), src.substring(0, 1).toLowerCase());
    }

    public static boolean isExist(String path) {
        return (new File(path).exists());
    }

    public static String readFile(String path) {
        StringBuilder sb = new StringBuilder();
        String data;
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(path));
            while ((data = reader.readLine()) != null) {
                sb.append(data);
                sb.append(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    public static void writeFile(String path, String content) {
//        OutputStream fos = null;
//        OutputStreamWriter osw = null;
//        try {
//            File f = new File(file);
//            if(!f.exists())	{
//                File path = new File(file.substring(0, file.lastIndexOf(File.separator)));
//                path.mkdirs();
//                f.createNewFile();
//            }
//
//            fos = new FileOutputStream(f);
//            osw = new OutputStreamWriter(fos,"UTF-8");
//            osw.write( javaContent );
//            osw.flush();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            Closer.close(fos);
//        }

        System.out.println(path);
        FileOutputStream out = null;
//
//        FileOutputStream outSTr = null;
//
//        BufferedOutputStream Buff=null;
//
//        FileWriter fw = null;
        //String path = D.SRC_DIR + D.OUTPUT_CFG_DIR + packageName + "\\" + className + ".cfg";
        //System.out.println("real is " + path);

        try {
            File f = new File(path);
            if (!f.exists()) {
                File p = new File(path.substring(0, path.lastIndexOf('/')));
                p.mkdirs();
                //f.createNewFile();
            }

            out = new FileOutputStream(new File(path));
            out.write(content.getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert out != null;
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 主要用于getCount函数中get的生成，重点在于要考虑boolean值的生成
     * isMax字段相应的get，set函数分别是
     * isMax()
     * setMax()
     */
    public static String genGet(String paraName) {
        if (paraName.startsWith("is") || paraName.startsWith("Is")) {

            return Util.firstToLowCase(paraName);
        } else {
            return "get" + Util.firstToUpperCase(paraName);
        }
    }


    /**
     * 主要用于setCount函数中get的生成，重点在于要考虑boolean值的生成
     * isMax字段相应的get，set函数分别是
     * isMax()
     * setMax()
     */
    public static String genSet(String paraName) {
        if (paraName.startsWith("is") || paraName.startsWith("Is")) {

            return "set" + paraName.substring(2);//去掉is
        } else {
            return "set" + Util.firstToUpperCase(paraName);
        }
    }
}
