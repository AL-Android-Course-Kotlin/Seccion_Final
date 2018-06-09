package com.alejandrolora.finalapp.models

import java.util.Date

data class Rate(
        val text: String,
        val rate: Float,
        val createdAt: Date,
        val profileImgURL: String = ""
)