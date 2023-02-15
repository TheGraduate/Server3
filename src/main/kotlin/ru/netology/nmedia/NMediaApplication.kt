package ru.netology.nmedia

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import ru.netology.nmedia.dto.Attachment
import ru.netology.nmedia.dto.Author
import ru.netology.nmedia.dto.Comment
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.enumeration.AttachmentType
import ru.netology.nmedia.service.AuthorService
import ru.netology.nmedia.service.CommentService
import ru.netology.nmedia.service.PostService

@SpringBootApplication
class NMediaApplication {
    @Bean
    fun runner(
        authorService: AuthorService,
        postService: PostService,
        commentService: CommentService,
    ) = CommandLineRunner {
        val netology = authorService.save(
            Author(id = 0, name = "Netology", avatar = "netology.jpg")
        )
        val sber = authorService.save(
            Author(id = 0, name = "Сбер", avatar = "sber.jpg")
        )
        val tcs = authorService.save(
            Author(id = 0, name = "Тинькофф", avatar = "tcs.jpg")
        )

        val firstPost = postService.save(
            Post(
                id = 0,
                authorId = netology.id,
                content = "Привет, это новая Нетология!",
                published = 0,
                likedByMe = false,
                likes = 0,
            )
        )
        val secondPost = postService.save(
            Post(
                id = 0,
                authorId = sber.id,
                content = "Привет, это новый Сбер!",
                published = 0,
                likedByMe = false,
                likes = 0,
            )
        )
        val thirdPost = postService.save(
            Post(
                id = 0,
                authorId = tcs.id,
                content = "Нам и так норм!",
                published = 0,
                likedByMe = false,
                likes = 0,
            )
        )
        val fourthPost = postService.save(
            Post(
                id = 0,
                authorId = netology.id,
                content = "Подкасты любят свой подкаст и обсуждать .",
                published = 0,
                likedByMe = false,
                likes = 0,
                attachment = Attachment(
                    url = "podcast.jpg",
                    description = "Как запустить свой подкаст: подборка статей",
                    type = AttachmentType.IMAGE,
                ),
            )
        )
        val fifthPost = postService.save(
            Post(
                id = 0,
                authorId = sber.id,
                content = "Появился новый способ мошенничества СберБанк Онлайн.",
                published = 0,
                likedByMe = false,
                likes = 0,
                attachment = Attachment(
                    url = "sbercard.jpg",
                    description = "Предлагают мошенничество!",
                    type = AttachmentType.IMAGE,
                ),
            )
        )
        with(commentService) {
            save(
                Comment(
                    id = 0,
                    postId = firstPost.id,
                    authorId = netology.id,
                    content = "Отлично!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            save(
                Comment(
                    id = 0,
                    postId = firstPost.id,
                    authorId = sber.id,
                    content = "Мы тоже обновились!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
            save(
                Comment(
                    id = 0,
                    postId = secondPost.id,
                    authorId = netology.id,
                    content = "Новый логотип прекрасен!",
                    published = 0,
                    likedByMe = false,
                    likes = 0,
                )
            )
        }
    }
}

fun main(args: Array<String>) {
    runApplication<NMediaApplication>(*args)
}
