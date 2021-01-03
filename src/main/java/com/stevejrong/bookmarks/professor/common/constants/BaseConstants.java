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
package com.stevejrong.bookmarks.professor.common.constants;

import com.stevejrong.bookmarks.professor.util.DateTimeUtil;
import com.stevejrong.bookmarks.professor.util.FileUtil;

import java.io.File;

/**
 * Constants - 系统基础常量
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:32 PM
 * @since 1.0
 */
public class BaseConstants {

    /**
     * 东八区时区
     */
    public static final String UTC_GMT8 = "+8";

    /**
     * Java8中，东八区的时区ID
     */
    public static final String UTC_GMT8_ZONE_ID = "Asia/Shanghai";

    /**
     * JSON格式的提交数据方式
     */
    public static final String APPLICATION_JSON = "application/json";

    /**
     * XML格式的提交数据方式
     */
    public static final String APPLICATION_XML = "application/xml";

    public static final String CONTENT_TYPE = "Content-Type";

    public static final String APPLICATION_JSON_UTF_8 = APPLICATION_JSON.concat(";").concat("charset=utf-8");

    public static final String FLAC_FILE_SUFFIX = ".flac";

    public static final String MP3_FILE_SUFFIX = ".mp3";

    public static final String ARTWORK_TEMP_DIRECTORY = FileUtil.getProjectAbsolutePath() + File.separator + "temp" + File.separator + "artwork";

    public static final String MODULE_LOG_DIRECTORY = FileUtil.getProjectAbsolutePath() + File.separator + "log";

    public static final String ANALYSIS_ORIGINAL_MUSIC_FILE_MODULE_LOG_NAME = "analysis_original_music_file_module_log_"
            .concat(DateTimeUtil.formatDate(DateTimeUtil.YYYYMMDD_HHMMSS_FORMAT_WITHOUT_SYMBOL, DateTimeUtil.getDateByNow()));

    public static final String COMPLEMENTS_SUCCESS_MUSIC_INFO_MODULE_LOG_NAME = "complements_success_music_info_module_log_"
            .concat(DateTimeUtil.formatDate(DateTimeUtil.YYYYMMDD_HHMMSS_FORMAT_WITHOUT_SYMBOL, DateTimeUtil.getDateByNow()));

    public static final String COMPLEMENTS_FAILURE_SUCCESS_MUSIC_INFO_MODULE_LOG_NAME = "complements_failure_music_info_module_log_"
            .concat(DateTimeUtil.formatDate(DateTimeUtil.YYYYMMDD_HHMMSS_FORMAT_WITHOUT_SYMBOL, DateTimeUtil.getDateByNow()));

    public static final String DEFAULT_ALBUM_PIC_FILE_PATH = FileUtil.getProjectAbsolutePath().concat(File.separator)
            .concat("src").concat(File.separator)
            .concat("main").concat(File.separator)
            .concat("resources").concat(File.separator)
            .concat("img").concat(File.separator)
            .concat("default_album_pic.jpg");
}
