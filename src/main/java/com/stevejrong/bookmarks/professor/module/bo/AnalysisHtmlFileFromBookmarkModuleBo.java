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
package com.stevejrong.bookmarks.professor.module.bo;

import java.io.Serializable;

/**
 * Bo - 收藏夹信息
 */
public class AnalysisHtmlFileFromBookmarkModuleBo implements Serializable {

    /**
     * 收藏夹中收藏信息的标题
     */
    private String bookmarkTitle;

    /**
     * 收藏夹中收藏信息的地址
     */
    private String bookmarkURL;

    public String getBookmarkTitle() {
        return bookmarkTitle;
    }

    public void setBookmarkTitle(String bookmarkTitle) {
        this.bookmarkTitle = bookmarkTitle;
    }

    public String getBookmarkURL() {
        return bookmarkURL;
    }

    public void setBookmarkURL(String bookmarkURL) {
        this.bookmarkURL = bookmarkURL;
    }

    public AnalysisHtmlFileFromBookmarkModuleBo() {
    }
}
