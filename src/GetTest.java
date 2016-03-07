import java.io.IOException;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

public class GetTest {
	private final OkHttpClient client = new OkHttpClient();
	public void run() throws Exception{
		Request request = new Request.Builder()
				.url("www.jd.com")
				.header("User-Agent","OkHttp Headers.java")
				.addHeader("Accept", "application/json;q=0.5")
				.addHeader("Accept", "application/vnd.github.v3+json")
				.build();
		com.squareup.okhttp.Response response = client.newCall(request).execute();
		if(!response.isSuccessful()){
			throw new IOException("Unexpected code"+response);
		}else{
			System.out.println("Server:"+response.header("server"));
			System.out.println("Date:"+response.header("Date"));
			System.out.println("Vary:"+response.header("Vary"));
		}
	}
	public static void main(String[] args) throws IOException {
		
		
	}
	}


