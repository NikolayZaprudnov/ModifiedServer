package ru.netology.nmedia.entity

import ru.netology.nmedia.dto.Post
import jakarta.persistence.Id
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType

@Entity
data class PostEntity(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long,
    var authorName: String,
    var authorAvatar: String,
    var time: String,
    var content: String,
    var likedByMe: Boolean,
    var likesAmount: Int = 0,
    var repostAmount: Int = 0,
    val video: String? = null
) {
    fun toDto() = Post(id, authorName, authorAvatar, time, content , likedByMe, likesAmount, repostAmount, video)

    companion object {
        fun fromDto(dto: Post) = PostEntity(dto.id, dto.authorName, dto.authorAvatar,
            dto.time, dto.content, dto.likedByMe, dto.likesAmount, dto.repostAmount, dto.video)
    }
}