package com.example.cacheit.domain

import com.example.cacheit.data.ItemEntity

data class Item(
    val title:String?,
    val body:String?
)

fun Item.toDomain(): com.example.cacheit.domain.Item {
    return com.example.cacheit.domain.Item(title = this.title, body = this.body)
}

fun List<Item>.toDomainList(): List<com.example.cacheit.domain.Item> {
    return this.map { it.toDomain() }
}

fun Item.toItemEntity(): ItemEntity {
    return ItemEntity(
        title = this.title,
        body = this.body
    )
}
