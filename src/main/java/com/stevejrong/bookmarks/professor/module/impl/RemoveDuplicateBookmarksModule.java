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

import com.stevejrong.bookmarks.professor.module.IBusinessModule;
import com.stevejrong.bookmarks.professor.module.bo.AnalysisHtmlFileFromBookmarkModuleBo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * 去除收藏夹中的重复项
 * 去除规则：仅根据URL判定即可
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:46 PM
 * @since 1.0
 */
public class RemoveDuplicateBookmarksModule implements IBusinessModule<List<AnalysisHtmlFileFromBookmarkModuleBo>> {

    /**
     * 待去重的收藏夹项对象数组
     */
    private List<AnalysisHtmlFileFromBookmarkModuleBo> analysisHtmlFileFromBookmarkModuleList;

    public List<AnalysisHtmlFileFromBookmarkModuleBo> getAnalysisHtmlFileFromBookmarkModuleList() {
        return analysisHtmlFileFromBookmarkModuleList;
    }

    public void setAnalysisHtmlFileFromBookmarkModuleList(List<AnalysisHtmlFileFromBookmarkModuleBo> analysisHtmlFileFromBookmarkModuleList) {
        this.analysisHtmlFileFromBookmarkModuleList = analysisHtmlFileFromBookmarkModuleList;
    }

    @Override
    public List<AnalysisHtmlFileFromBookmarkModuleBo> doAction() {
        List<AnalysisHtmlFileFromBookmarkModuleBo> removeDuplicateBookmarksList
                = analysisHtmlFileFromBookmarkModuleList.stream()
                .collect(Collectors.collectingAndThen(Collectors.toCollection(()
                                -> new TreeSet<>(Comparator.comparing(AnalysisHtmlFileFromBookmarkModuleBo::getBookmarkURL))),
                        ArrayList::new));

        return removeDuplicateBookmarksList;
    }
}