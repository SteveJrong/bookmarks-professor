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
package com.stevejrong.bookmarks.professor.module;

/**
 * 业务模块接口
 *
 * @author SteveJrong
 * create date: 2021-01-03 4:33 PM
 * @since 1.0
 */
public interface IBusinessModule<T> {

    /**
     * 业务执行方法
     *
     * @return
     */
    T doAction();
}