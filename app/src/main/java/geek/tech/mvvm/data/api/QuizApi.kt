package geek.tech.mvvm.data.api

import geek.tech.mvvm.data.api.model.Quiz
import retrofit2.Response
import retrofit2.http.*

interface QuizApi {
    @GET("api.php")
    suspend fun getQuiz(
        @Query("amount") amount:Int
    ):Response<Any>

    @FormUrlEncoded
    @POST("create.php")
    fun createQuiz(
            @Field("category") category:String,
            @Field("type") type:String
    )

    @POST("create.php")
    fun createQuiz(
            @Body quiz: Quiz
    )

    @GET("user/post/{id}/")
    fun getPost(
            @Path("id") id:Int,
            @Query("amount") amount:Int
    )
}