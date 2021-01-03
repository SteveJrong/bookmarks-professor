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
package com.stevejrong.bookmarks.professor.common.enums;

/**
 * Class - 抽象枚举
 *
 * @author SteveJrong
 * create date: 2021-01-03 8:32 PM
 * @since 1.0
 */
public interface AbstractEnum {

    /**
     * 获取枚举描述
     *
     * @return 枚举的描述
     */
    String getDesc();

    /**
     * 获取枚举值
     * 当枚举的ordinal()值无法满足实际需要，需要自行定义枚举的Code时使用
     *
     * @return 枚举的自定义Code值
     */
    default Integer getCode() {
        return null;
    }
}
