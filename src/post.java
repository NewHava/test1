import java.io.IOException;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class post {
	public static final MediaType JSON = MediaType.parse("application/json;charset=utf-8");
	static OkHttpClient client = new OkHttpClient();
	
	static String post(String url,String json) throws IOException{
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(url).post(body).build();
		Response response = client.newCall(request).execute();
		if(response.isSuccessful()){
			return response.body().string();
		}else{
			throw new IOException("Unexpect code"+response);
		}
	}
	public static void main(String[] args) throws IOException {
		String url = post.post("http://www.163.com", null);
		System.out.println(url);
	}
}
