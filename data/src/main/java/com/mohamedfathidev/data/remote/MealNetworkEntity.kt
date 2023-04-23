package com.mohamedfathidev.data.remote

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class MealNetworkEntity(
    @SerializedName("idCategory")
    @Expose
    val idCategory: String,
    @SerializedName("strCategory")
    @Expose
    val strCategory: String,
    @SerializedName("strCategoryDescription")
    @Expose
    val strCategoryDescription: String,
    @SerializedName("strCategoryThumb")
    @Expose
    val strCategoryThumb: String
)