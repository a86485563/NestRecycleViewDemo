package com.example.nestrecycleviewapp.data.lifeCircleVo

import com.google.gson.annotations.SerializedName

data class CategoryMetadata(@SerializedName("end_date")
                            val endDate: String = "",
                            @SerializedName("see_more_btn")
                            val seeMoreBtn: Boolean = false,
                            @SerializedName("category_layout_type")
                            val categoryLayoutType: String = "",
                            @SerializedName("assigned_area")
                            val assignedArea: String = "",
                            @SerializedName("kind")
                            val kind: Int = 0,
                            @SerializedName("max_amount_on_homepage")
                            val maxAmountOnHomepage: Int = 0,
                            @SerializedName("max_products")
                            val maxProducts: Int = 0,
                            @SerializedName("display_order")
                            val displayOrder: Int = 0,
                            @SerializedName("id")
                            val id: String = "",
                            @SerializedName("display_name")
                            val displayName: String = "",
                            @SerializedName("start_date")
                            val startDate: String = "",
                            @SerializedName("vendor_prefix_allowed")
                            val vendorPrefixAllowed: String = "")