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
package com.stevejrong.bookmarks.professor.boot;

import com.google.common.collect.Lists;
import com.stevejrong.bookmarks.professor.config.SystemConfig;
import com.stevejrong.bookmarks.professor.module.bo.AnalysisHtmlFileFromBookmarkModuleBo;
import com.stevejrong.bookmarks.professor.module.impl.AnalysisHtmlFileFromBookmarkModule;
import com.stevejrong.bookmarks.professor.module.impl.PersistBookmarksModule;
import com.stevejrong.bookmarks.professor.module.impl.RemoveDuplicateBookmarksModule;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * 启动入口
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:32 PM
 * @since 1.0
 */
public class BookmarksProfessorApplication {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-bean.xml");

        SystemConfig systemConfig = (SystemConfig) context.getBean("systemConfig");
        AnalysisHtmlFileFromBookmarkModule analysisHtmlFileFromBookmarkModule
                = (AnalysisHtmlFileFromBookmarkModule) context.getBean("analysisHtmlFileFromBookmarkModule");

        List<AnalysisHtmlFileFromBookmarkModuleBo> bookmarksList = Lists.newArrayList();

        // 分析收藏夹HTML文件
        Files.newDirectoryStream(Paths.get(systemConfig.getDirectoryPathOfOriginalBookmarkFile()), path -> path.toFile().isFile())
                .forEach(htmlFile -> {
                    analysisHtmlFileFromBookmarkModule.setHtmlFileOfBookmark(htmlFile.toString());
                    List<AnalysisHtmlFileFromBookmarkModuleBo> analysisHtmlFileFromBookmarkModuleBoList = analysisHtmlFileFromBookmarkModule.doAction();

                    bookmarksList.addAll(analysisHtmlFileFromBookmarkModuleBoList);
                });

        /*StringBuilder sb = new StringBuilder("序号, 标题, URL\n");
        for (int i = 0; i < bookmarksList.size(); i++) {
            sb.append(i + 1).append(", ")
                    .append(bookmarksList.get(i).getBookmarkTitle()).append(", ")
                    .append(bookmarksList.get(i).getBookmarkURL()).append("\n");
        }
        FileUtil.writeStringContentToFile(sb.toString(),
                ".txt",
                "original_bookmarks_data_"
                        .concat(DateTimeUtil.formatDate(DateTimeUtil.YYYYMMDD_HHMMSS_FORMAT_WITHOUT_SYMBOL, DateTimeUtil.getDateByNow())),
                FileUtil.getProjectAbsolutePath().concat(File.separator).concat("logs"));*/

        RemoveDuplicateBookmarksModule removeDuplicateBookmarksModule
                = (RemoveDuplicateBookmarksModule) context.getBean("removeDuplicateBookmarksModule");

        removeDuplicateBookmarksModule.setAnalysisHtmlFileFromBookmarkModuleList(bookmarksList);
        List<AnalysisHtmlFileFromBookmarkModuleBo> willPersistBookmarksList = removeDuplicateBookmarksModule.doAction();

        PersistBookmarksModule persistBookmarksModule = (PersistBookmarksModule) context.getBean("persistBookmarksModule");
        persistBookmarksModule.setAnalysisHtmlFileFromBookmarkModuleList(willPersistBookmarksList);

        persistBookmarksModule.doAction();
    }
}
