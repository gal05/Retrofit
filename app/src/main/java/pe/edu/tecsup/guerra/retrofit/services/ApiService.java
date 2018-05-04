package pe.edu.tecsup.guerra.retrofit.services;

import java.util.List;

import pe.edu.tecsup.guerra.retrofit.models.Producto;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Alumno on 4/05/2018.
 */

public interface ApiService {

    String API_BASE_URL = "https://retrofit-android-gal05.c9users.io";

    @GET("api/v1/productos")
    Call<List<Producto>> getProductos();

}
