package np.com.myfitness.remote;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface {

@POST("/api/login")
    Call<UserModel> postApiInterface(@Body UserModel userModel);


}
