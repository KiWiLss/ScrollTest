/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: Province
 * Author:   kiwilss
 * Date:     2019/2/28 13:59
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.model.modelk
import com.squareup.moshi.Json


/**
 *@FileName: Province
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/2/28
 * @desc   : {DESCRIPTION}
 */


data class Province(
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String
)

