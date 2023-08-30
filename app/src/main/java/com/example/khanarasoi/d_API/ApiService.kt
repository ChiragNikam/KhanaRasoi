import com.example.khanarasoi.d_API.LoginRequest
import com.example.khanarasoi.d_API.LoginResponse
import com.example.khanarasoi.d_API.RegistrationRequest
import com.example.khanarasoi.d_API.RegistrationResponse
import com.example.khanarasoi.d_API.UpdateRequest
import com.example.khanarasoi.d_API.UserProfileResponse
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    // Login API
    @POST("/api/user/auth/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    // Register API
    @POST("/api/user/auth/register")
    fun register(@Body request: RegistrationRequest): Call<RegistrationResponse>

    // Fetch user profile by ID
    @GET("/api/user/auth")
    fun getUserProfile(@Header("Authorization") token: String): Call<UserProfileResponse>


    // Update user profile
    @PATCH("/api/user/auth")
    fun updateUserProfile(@Header("Authorization") token: String, @Body profileUpdateRequest: UpdateRequest): Call<UserProfileResponse>
    /*

    // Delete a user
    @DELETE("/api/user/{id}")
    fun deleteUser(@Path("id") userId: Int): Call<Void>

    // Fetch a list of items with optional query parameters for filtering
    @GET("/api/items")
    fun getItems(@Query("category") category: String? = null, @Query("limit") limit: Int? = null): Call<List<ItemResponse>>
    */
}
