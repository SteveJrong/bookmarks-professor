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
package com.stevejrong.bookmarks.professor.config;

/**
 * Bean - 系统配置
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:32 PM
 * @since 1.0
 */
public class SystemConfig {

    /**
     * 收藏夹原始文件的存放目录
     */
    private String directoryPathOfOriginalBookmarkFile;

    /**
     * 整合好的收藏夹文件存放目录
     */
    private String directoryPathOfNewBookmarkFile;

    public String getDirectoryPathOfOriginalBookmarkFile() {
        return directoryPathOfOriginalBookmarkFile;
    }

    public void setDirectoryPathOfOriginalBookmarkFile(String directoryPathOfOriginalBookmarkFile) {
        this.directoryPathOfOriginalBookmarkFile = directoryPathOfOriginalBookmarkFile;
    }

    public String getDirectoryPathOfNewBookmarkFile() {
        return directoryPathOfNewBookmarkFile;
    }

    public void setDirectoryPathOfNewBookmarkFile(String directoryPathOfNewBookmarkFile) {
        this.directoryPathOfNewBookmarkFile = directoryPathOfNewBookmarkFile;
    }
}