package com.example.nestrecycleviewapp.data.lifeCircleVo

import com.google.gson.annotations.SerializedName

data class LifeCycleData(@SerializedName("category_metadata")
                         val categoryMetadata: CategoryMetadata?,
                         @SerializedName( "category_products")
                         val data: List<CategoryProduct>? = null,
                         @SerializedName("model_metadata")
                         val modelMetadata: String? = "")