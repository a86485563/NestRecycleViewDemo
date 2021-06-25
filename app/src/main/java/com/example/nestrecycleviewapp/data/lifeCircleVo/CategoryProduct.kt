package com.example.nestrecycleviewapp.data.lifeCircleVo

import com.google.gson.annotations.SerializedName

data class CategoryProduct(@SerializedName("prod_images_ratio2x3")
                           val prodImagesRatioBig: List<String>?,
                           @SerializedName("prod_short_description")
                           val prodShortDescription: String? = "",
                           @SerializedName("prod_end_date")
                           val prodEndDate: String? = "",
                           @SerializedName("prod_price")
                           val prodPrice: Int? = 0,
                           @SerializedName("detailed_URL_for_fetnet_desktop_web")
                           val detailedURLForFetnetDesktopWeb: String? = "",
                           @SerializedName("partner_prefix")
                           val partnerPrefix: String? = "",
                           @SerializedName("isAdditionalFiltered")
                           val isAdditionalFiltered: Boolean? = false,
                           @SerializedName("prod_id")
                           val prodId: String? = "",
                           @SerializedName("prod_name")
                           val prodName: String? = "",
                           @SerializedName("detailed_URL")
                           val detailedURL: String? = "",
                           @SerializedName("prod_start_date")
                           val prodStartDate: String? = "",
                           @SerializedName("prod_images_ratio1x1")
                           val prodImagesRatioSmall: List<String>?,
                           @SerializedName("prod_id_suffix")
                           val prodIdSuffix: String? = "",
                           @SerializedName("product_layout_type")
                           val productLayoutType: String? = "",
                           @SerializedName("product_recommend_weight")
                           val productRecommendWeight: Double? = 0.0,
                           @SerializedName("detailed_URL_for_fetnet_mobile_web")
                           val detailedURLForFetnetMobileWeb: String? = "")