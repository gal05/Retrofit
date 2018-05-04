package pe.edu.tecsup.guerra.retrofit.avtivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import pe.edu.tecsup.guerra.retrofit.R;
import pe.edu.tecsup.guerra.retrofit.models.Producto;
import pe.edu.tecsup.guerra.retrofit.services.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiService.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService=retrofit.create(ApiService.class);
        Call<List<Producto>> call =apiService.getProductos();

        call.enqueue(new Callback<List<Producto>>() {
            @Override
            public void onResponse(Call<List<Producto>> call, Response<List<Producto>> response) {

                if (response.isSuccessful()){
                    List<Producto> productos=response.body();
                    for (Producto producto:productos){
                        Log.d("PRODUCTO : ",producto.getNombre());
                    }
                }else{
                    Toast.makeText(MainActivity.this, "error inesperado", Toast.LENGTH_LONG);
                }

            }

            @Override
            public void onFailure(Call<List<Producto>> call, Throwable t) {

            }
        });

    }
}
