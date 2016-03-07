import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class get {
	private final static OkHttpClient client = new OkHttpClient();
	
	public static String Run(String url) throws IOException{
		
		// * Request是OKHttp中访问的请求,Builder是辅助类
		 //* Response是OKHttp中的响应.
		 
		Request request = new Request.Builder().url(url).build();
		Response response = client.newCall(request).execute();
		if(response.isSuccessful()){
			
			return response.body().string();
		}else{
			throw new IOException("Unexpect code"+response);
		}
	}
	public static void main(String[] args) throws IOException {
		String url = get.Run("http://www.163.com");
		
		System.out.println(url);
	}

}
