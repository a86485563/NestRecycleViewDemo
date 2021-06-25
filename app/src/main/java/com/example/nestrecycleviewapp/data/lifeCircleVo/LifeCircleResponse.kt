package com.example.nestrecycleviewapp.data.lifeCircleVo

import com.google.gson.annotations.SerializedName

data class LifeCircleResponse(@SerializedName("ui_template_version")
                              val uiTemplateVersion: String? = "",
                              @SerializedName( "data")
                              val data: List<LifeCycleData>? = null)