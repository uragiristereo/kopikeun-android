package app.kopikeun.data.remote

import app.kopikeun.data.model.CafeDetailResponse
import app.kopikeun.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.*

interface KopikeunApi {
    // CAFE

    @GET("/cafe/{cafe_id}")
    suspend fun getCafeInfo(@Path("cafe_id") cafeId: Int): Response<CafeDetailResponse>

    @GET("/cafe/{cafe_id}/photos")
    suspend fun getCafePhotos(
        @Path("cafe_id") cafeId: Int,
        @Query("show_from_customer") showFromCustomer: Boolean,
        @Query("limit") limit: Int,
    ): Response<String>

    @GET("/cafe/{cafe_id}/reviews")
    suspend fun getCafeReviews(
        @Path("cafe_id") cafeId: Int,
        @Query("limit") limit: Int,
    ): Response<String>

    @GET("/cafe/{cafe_id}/review/{review_id}")
    suspend fun getCafeReview(
        @Path("cafe_id") cafeId: Int,
        @Path("review_id") reviewId: Int,
    ): Response<String>

    @GET("/cafes/search")
    suspend fun getCafesByKeyword(
        @Query("keyword") keyword: String,
        @Query("limit") limit: Int,
    ): Response<SearchResponse>


    // USER

    @FormUrlEncoded
    @POST("/user/register")
    suspend fun register(
        @Field("email") email: String,
        @Field("hash") hash: String,
    ): Response<String>

    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("hash") hash: String,
    ): Response<String>

    @GET("/user/info")
    suspend fun getUserInfo(@Header("Authorization") authorization: String): Response<String>

    @GET("/user/favorites")
    suspend fun getUserFavorites(@Header("Authorization") authorization: String): Response<String>


    // APP

    @GET("/app/check_update")
    suspend fun checkForUpdate(@Query("version") version: String): Response<String>
}