/**
 * Copyright (C), 2017-2019, XXX有限公司
 * FileName: BaseBean
 * Author:   kiwilss
 * Date:     2019/3/4 14:26
 * Description: {DESCRIPTION}
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.kiwilss.scrolltest.model.modelk


/**
 *@FileName: BaseBean
 *@author : Lss kiwilss
 * @e-mail : kiwilss@163.com
 * @time   : 2019/3/4
 * @desc   : {DESCRIPTION}
 */
data class BaseBean<T>(val code: String?, val failures: Any?,
                    val message: String?, val status: Int, val result: T?)


