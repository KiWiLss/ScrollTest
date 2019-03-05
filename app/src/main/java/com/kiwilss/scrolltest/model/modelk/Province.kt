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



data class LoginInfo(
    @Json(name = "code")
    val code: Any,
    @Json(name = "failures")
    val failures: Any,
    @Json(name = "message")
    val message: String,
    @Json(name = "result")
    val result: Result,
    @Json(name = "status")
    val status: Int
)

data class Result(
    @Json(name = "announcementContent")
    val announcementContent: String,
    @Json(name = "bankCode")
    val bankCode: String,
    @Json(name = "cityCode")
    val cityCode: String,
    @Json(name = "havingPhoto")
    val havingPhoto: Boolean,
    @Json(name = "isVip")
    val isVip: Boolean,
    @Json(name = "mchAreaDO")
    val mchAreaDO: MchAreaDO,
    @Json(name = "mchBankCardDO")
    val mchBankCardDO: MchBankCardDO,
    @Json(name = "mchIdentificationAuditDO")
    val mchIdentificationAuditDO: Any,
    @Json(name = "mchOpenDTO")
    val mchOpenDTO: MchOpenDTO,
    @Json(name = "siteId")
    val siteId: Int
)

data class MchBankCardDO(
    @Json(name = "bankAddress")
    val bankAddress: Any,
    @Json(name = "bankBranchName")
    val bankBranchName: String,
    @Json(name = "bankCardNo")
    val bankCardNo: String,
    @Json(name = "bankCode")
    val bankCode: String,
    @Json(name = "bankLineNo")
    val bankLineNo: String,
    @Json(name = "bankName")
    val bankName: String,
    @Json(name = "bizType")
    val bizType: Int,
    @Json(name = "cardMonth")
    val cardMonth: Any,
    @Json(name = "cardYear")
    val cardYear: Any,
    @Json(name = "city")
    val city: String,
    @Json(name = "companyOrPersonal")
    val companyOrPersonal: String,
    @Json(name = "county")
    val county: String,
    @Json(name = "createUser")
    val createUser: Int,
    @Json(name = "cvNum")
    val cvNum: Any,
    @Json(name = "dbcr")
    val dbcr: String,
    @Json(name = "gmtCreate")
    val gmtCreate: Long,
    @Json(name = "gmtModified")
    val gmtModified: Long,
    @Json(name = "iconPath")
    val iconPath: String,
    @Json(name = "idCardNo")
    val idCardNo: String,
    @Json(name = "idName")
    val idName: String,
    @Json(name = "mchBankCardId")
    val mchBankCardId: Int,
    @Json(name = "merchantId")
    val merchantId: Int,
    @Json(name = "mobile")
    val mobile: String,
    @Json(name = "modifyUser")
    val modifyUser: Int,
    @Json(name = "province")
    val province: String,
    @Json(name = "status")
    val status: Int
)

data class MchOpenDTO(
    @Json(name = "auditOperator")
    val auditOperator: Any,
    @Json(name = "auditOpinion")
    val auditOpinion: String,
    @Json(name = "auditStatus")
    val auditStatus: Any,
    @Json(name = "auditTime")
    val auditTime: Long,
    @Json(name = "categoryId")
    val categoryId: Any,
    @Json(name = "categoryPath")
    val categoryPath: Any,
    @Json(name = "createUser")
    val createUser: Int,
    @Json(name = "currentLoginIp")
    val currentLoginIp: String,
    @Json(name = "currentLoginTime")
    val currentLoginTime: Long,
    @Json(name = "ext1")
    val ext1: Any,
    @Json(name = "ext2")
    val ext2: Any,
    @Json(name = "ext3")
    val ext3: Any,
    @Json(name = "ext4")
    val ext4: Any,
    @Json(name = "ext5")
    val ext5: Any,
    @Json(name = "ext6")
    val ext6: Any,
    @Json(name = "gmtCreate")
    val gmtCreate: Long,
    @Json(name = "gmtModified")
    val gmtModified: Long,
    @Json(name = "idCardName")
    val idCardName: String,
    @Json(name = "idCardNo")
    val idCardNo: String,
    @Json(name = "inviterPhone")
    val inviterPhone: Any,
    @Json(name = "isChange")
    val isChange: Any,
    @Json(name = "lastLoginIp")
    val lastLoginIp: String,
    @Json(name = "lastLoginTime")
    val lastLoginTime: Long,
    @Json(name = "levelNum")
    val levelNum: Any,
    @Json(name = "loginId")
    val loginId: String,
    @Json(name = "mail")
    val mail: Any,
    @Json(name = "mchAddress")
    val mchAddress: Any,
    @Json(name = "mchHeadPhotoId")
    val mchHeadPhotoId: Any,
    @Json(name = "mchHeadPhotoPath")
    val mchHeadPhotoPath: Any,
    @Json(name = "merchantId")
    val merchantId: Int,
    @Json(name = "merchantName")
    val merchantName: String,
    @Json(name = "merchantNo")
    val merchantNo: String,
    @Json(name = "merchantPrivateKey")
    val merchantPrivateKey: Any,
    @Json(name = "merchantPublicKey")
    val merchantPublicKey: Any,
    @Json(name = "merchantSecret")
    val merchantSecret: Any,
    @Json(name = "merchantType")
    val merchantType: Int,
    @Json(name = "modifyUser")
    val modifyUser: Int,
    @Json(name = "nick")
    val nick: Any,
    @Json(name = "password")
    val password: Any,
    @Json(name = "payPassword")
    val payPassword: Any,
    @Json(name = "phone")
    val phone: String,
    @Json(name = "regionId")
    val regionId: Any,
    @Json(name = "regionPath")
    val regionPath: Any,
    @Json(name = "status")
    val status: Int
)

data class MchAreaDO(
    @Json(name = "area")
    val area: String,
    @Json(name = "areaAddr")
    val areaAddr: String,
    @Json(name = "areaName")
    val areaName: String,
    @Json(name = "city")
    val city: String,
    @Json(name = "createUser")
    val createUser: Int,
    @Json(name = "ext1")
    val ext1: Any,
    @Json(name = "ext2")
    val ext2: Any,
    @Json(name = "ext3")
    val ext3: Any,
    @Json(name = "ext4")
    val ext4: Any,
    @Json(name = "ext5")
    val ext5: Any,
    @Json(name = "ext6")
    val ext6: Any,
    @Json(name = "gmtCreate")
    val gmtCreate: Long,
    @Json(name = "gmtModified")
    val gmtModified: Long,
    @Json(name = "latitude")
    val latitude: String,
    @Json(name = "longitude")
    val longitude: String,
    @Json(name = "mchAreaId")
    val mchAreaId: Int,
    @Json(name = "merchantId")
    val merchantId: Int,
    @Json(name = "modifyUser")
    val modifyUser: Int,
    @Json(name = "onType")
    val onType: Int,
    @Json(name = "province")
    val province: String,
    @Json(name = "status")
    val status: Int
)