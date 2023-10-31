package uz.gita.contactwitworker.data.source.remote

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Query
import uz.gita.contactwitworker.data.source.remote.requests.AddContactRequest
import uz.gita.contactwitworker.data.source.remote.response.ContactResponse
import uz.gita.contactwitworker.data.source.remote.response.ContactResponseItem
import uz.gita.contactwitworker.data.source.remote.response.DeleteResponse

interface AppApi {
    @GET("contact")
    suspend fun getContacts(): Response<ContactResponse>

    @POST("contact")
    suspend fun addContact(@Body addContactRequest: AddContactRequest): Response<ContactResponseItem>

    @PUT("contact")
    suspend fun updateContact(@Body contactUpdateRequest: AddContactRequest): Response<ContactResponse>

    @DELETE("contact")
    suspend fun deleteContact(@Query("id") id: Int): Response<DeleteResponse>

}