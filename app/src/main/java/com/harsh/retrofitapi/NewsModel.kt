package com.harsh.retrofitapi

import java.io.Serializable

data class NewsModel(var totalResults : Int, var articles : List<ArticlesModel>) : Serializable
