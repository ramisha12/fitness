package np.com.myfitness.remote;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtils {

    private static Retrofit retrofit = null;
    private static final String base_url ="https://myfitness.techenfield.com/";

    private ApiUtils(){}

    public static Retrofit getService(Context context){
       if (retrofit == null){
           OkHttpClient client = new OkHttpClient.Builder()
                   .addInterceptor(new ChuckerInterceptor(context))
                   .build();

           retrofit =new Retrofit.Builder()
                   .baseUrl(base_url)
                   .client(client)
                   .addConverterFactory(GsonConverterFactory.create())
                   .build();
       }
       return retrofit;


    }
}
