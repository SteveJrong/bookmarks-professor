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

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.stevejrong.bookmarks.professor.module.IBusinessModule;
import com.stevejrong.bookmarks.professor.module.bo.AnalysisHtmlFileFromBookmarkModuleBo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 分析从浏览器导出的收藏夹文件
 * 作用：读取收藏夹条目的重要信息，以便作为数据源
 *
 * @author SteveJrong
 * create date: 2021-01-03 4:38 PM
 * @since 1.0
 */
public class AnalysisHtmlFileFromBookmarkModule implements IBusinessModule<List<AnalysisHtmlFileFromBookmarkModuleBo>> {

    /**
     * 收藏夹HTML文件的路径
     */
    private String htmlFileOfBookmark;

    public String getHtmlFileOfBookmark() {
        return htmlFileOfBookmark;
    }

    public void setHtmlFileOfBookmark(String htmlFileOfBookmark) {
        this.htmlFileOfBookmark = htmlFileOfBookmark;
    }

    @Override
    public List<AnalysisHtmlFileFromBookmarkModuleBo> doAction() {
        List<AnalysisHtmlFileFromBookmarkModuleBo> bookmarkModuleBoList = Lists.newArrayList();

        Document document = null;
        try {
            document = Jsoup.parse(new File(htmlFileOfBookmark), Charsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.select("DT>A[HREF][ADD_DATE]");
        for (Element childElement : elements) {
            AnalysisHtmlFileFromBookmarkModuleBo bookmarkModuleBo = new AnalysisHtmlFileFromBookmarkModuleBo();
            bookmarkModuleBo.setBookmarkTitle(childElement.text());
            bookmarkModuleBo.setBookmarkURL(childElement.attr("HREF"));

            bookmarkModuleBoList.add(bookmarkModuleBo);
        }

        return bookmarkModuleBoList;
    }
}