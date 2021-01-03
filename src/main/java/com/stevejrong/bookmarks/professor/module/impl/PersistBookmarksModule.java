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
package com.stevejrong.bookmarks.professor.module.impl;

import com.stevejrong.bookmarks.professor.config.SystemConfig;
import com.stevejrong.bookmarks.professor.module.IBusinessModule;
import com.stevejrong.bookmarks.professor.module.bo.AnalysisHtmlFileFromBookmarkModuleBo;
import com.stevejrong.bookmarks.professor.util.DateTimeUtil;
import com.stevejrong.bookmarks.professor.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 持久化合并好的收藏夹文件内容
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:57 PM
 * @since 1.0
 */
public class PersistBookmarksModule implements IBusinessModule<Boolean> {

    /**
     * 待持久化的收藏夹项对象数组
     */
    private List<AnalysisHtmlFileFromBookmarkModuleBo> analysisHtmlFileFromBookmarkModuleList;

    /**
     * 系统配置Bean
     */
    private SystemConfig systemConfig;

    public List<AnalysisHtmlFileFromBookmarkModuleBo> getAnalysisHtmlFileFromBookmarkModuleList() {
        return analysisHtmlFileFromBookmarkModuleList;
    }

    public void setAnalysisHtmlFileFromBookmarkModuleList(List<AnalysisHtmlFileFromBookmarkModuleBo> analysisHtmlFileFromBookmarkModuleList) {
        this.analysisHtmlFileFromBookmarkModuleList = analysisHtmlFileFromBookmarkModuleList;
    }

    public SystemConfig getSystemConfig() {
        return systemConfig;
    }

    public void setSystemConfig(SystemConfig systemConfig) {
        this.systemConfig = systemConfig;
    }

    @Override
    public Boolean doAction() {
        String pathOfBookmarkTemplate = FileUtil.getProjectAbsolutePath()
                .concat(File.separator)
                .concat("src")
                .concat(File.separator)
                .concat("main")
                .concat(File.separator)
                .concat("resources")
                .concat(File.separator)
                .concat("template")
                .concat(File.separator);

        String pathOfHyperlinkTemplate = FileUtil.getProjectAbsolutePath()
                .concat(File.separator)
                .concat("src")
                .concat(File.separator)
                .concat("main")
                .concat(File.separator)
                .concat("resources")
                .concat(File.separator)
                .concat("template")
                .concat(File.separator);

        // 读取收藏夹项模板内容
        StringBuilder hyperlinkTemplateContent = null;
        try {
            hyperlinkTemplateContent = FileUtil.readFile("hyperlink.template", pathOfHyperlinkTemplate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 拼接收藏夹项字符串
        StringBuilder sbOfHyperlinks = new StringBuilder();
        for (AnalysisHtmlFileFromBookmarkModuleBo analysisHtmlFileFromBookmarkModuleBo : analysisHtmlFileFromBookmarkModuleList) {
            sbOfHyperlinks.append(
                    hyperlinkTemplateContent.toString().replace("@{param1}", analysisHtmlFileFromBookmarkModuleBo.getBookmarkURL())
                            .replace("@{param2}", DateTimeUtil.getTimestampByNow().toString())
                            .replace("@{param3}", analysisHtmlFileFromBookmarkModuleBo.getBookmarkTitle())
            ).append("\n");
        }


        // 读取收藏夹模板内容
        StringBuilder bookmarkTemplateContent = null;
        try {
            bookmarkTemplateContent = FileUtil.readFile("bookmark.template", pathOfHyperlinkTemplate);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 将收藏夹模板内容中的占位字符替换为拼接好的收藏夹项字符串
        String willPersistBookmark = bookmarkTemplateContent.toString()
                .replace("@{bookmarksData}", sbOfHyperlinks.toString());

        FileUtil.writeStringContentToFile(willPersistBookmark,
                ".html",
                "Bookmarks_"
                        .concat(DateTimeUtil.formatDate(DateTimeUtil.YYYYMMDD_HHMMSS_FORMAT_WITHOUT_SYMBOL, DateTimeUtil.getDateByNow())),
                systemConfig.getDirectoryPathOfNewBookmarkFile());

        return true;
    }
}