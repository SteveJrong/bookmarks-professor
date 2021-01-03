/**
 * Copyright 2021 SteveJrong
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.stevejrong.bookmarks.professor.util;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Util - 文件操作工具类
 *
 * @author SteveJrong
 * create date: 2021-01-03 4:33 PM
 * @since 1.0
 */
public final class FileUtil {

    /**
     * 字节数组转换为File对象
     * 此方法会生成临时文件
     *
     * @param byteArray 字节数组
     * @param filePath  临时文件创建路径
     * @return File对象
     */
    public static File byteArrayToFile(byte[] byteArray, String filePath) {
        File file = new File(filePath);

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            OutputStream output = new FileOutputStream(file);
            BufferedOutputStream bufferedOutput = new BufferedOutputStream(output);
            bufferedOutput.write(byteArray);
            bufferedOutput.flush();
            bufferedOutput.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    /**
     * 获取项目的根绝对路径
     *
     * @return 项目的根绝对路径
     */
    public static String getProjectAbsolutePath() {
        String projectAbsolutePath = null;

        File file = new File("");
        try {
            projectAbsolutePath = file.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return projectAbsolutePath;
    }

    /**
     * 字符串内容写入文本文件
     *
     * @param content    要写入的字符串内容
     * @param fileSuffix 保存的文件后缀名
     * @param fileName   保存的文件名称
     * @param filePath   保存的文件路径
     */
    public static void writeStringContentToFile(String content, String fileSuffix, String fileName, String filePath) {
        File file = new File(filePath.concat(File.separator).concat(fileName).concat(fileSuffix));

        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            Files.write(Paths.get(filePath.concat(File.separator).concat(fileName).concat(fileSuffix)), content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将文本文件中的内容读入StringBuilder中
     *
     * @param stringBuilder StringBuilder对象。用于保存读出的文本内容
     * @param fileName 文本文件名称
     * @param filePath 文本文件路径
     *
     * @throws IOException
     */
    private static void readToBuffer(StringBuilder stringBuilder, String fileName, String filePath) throws IOException {
        InputStream is = new FileInputStream(filePath.concat(File.separator).concat(fileName));
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();
        while (line != null) {
            stringBuilder.append(line);
            stringBuilder.append("\n");
            line = reader.readLine();
        }
        reader.close();
        is.close();
    }

    /**
     * 读取文本文件内容
     *
     * @param fileName 文本文件名称
     * @param filePath 文本文件路径
     * @return
     *
     * @throws IOException
     */
    public static StringBuilder readFile(String fileName, String filePath) throws IOException {
        StringBuilder sb = new StringBuilder();
        readToBuffer(sb, fileName, filePath);

        return sb;
    }
}
