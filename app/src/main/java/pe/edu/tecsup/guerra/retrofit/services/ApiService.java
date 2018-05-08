package pe.edu.tecsup.guerra.retrofit.services;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import pe.edu.tecsup.guerra.retrofit.models.Producto;
import pe.edu.tecsup.guerra.retrofit.response.ResponseMessage;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by Alumno on 4/05/2018.
 */

public interface ApiService {

    String API_BASE_URL = "https://laravel-55-android-gal05.c9users.io";

    @GET("api/v1/productos")
    Call<List<Producto>> getProductos();





    @FormUrlEncoded
    @POST("/api/v1/productos")
    Call<ResponseMessage> createProducto(@Field("nombre") String nombre,
                                         @Field("precio") String precio,
                                         @Field("detalles") String detalles);
    @Multipart
    @POST("/api/v1/productos")
    Call<ResponseMessage> createProductoWithImage(
            @Part("nombre") RequestBody nombre,
            @Part("precio") RequestBody precio,
            @Part("detalles") RequestBody detalles,
            @Part MultipartBody.Part imagen
    );

}
