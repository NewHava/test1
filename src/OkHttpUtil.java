import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

/**
 * Okhttp������
 * @author hu
 *
 */
public class OkHttpUtil {
	private static final OkHttpClient mOkHttpClient = new OkHttpClient();
	static{
		mOkHttpClient.setConnectTimeout(30, TimeUnit.SECONDS);
		
	}
	/**
	 * �ò��Ὺ���첽�߳�.
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Response execute(Request request)throws IOException{
		return mOkHttpClient.newCall(request).execute();
	}
	/**
	 * �����첽�̷߳�������
	 * @param request
	 * @param responseCallback
	 */
	public static void enqueue(Request request,Callback responseCallback){
		mOkHttpClient.newCall(request).enqueue(responseCallback);
	}
	/**
	 * �����첽�̷߳�������,�Ҳ����ⷵ�ؽ��(ʵ�ֿ�callback)
	 * @param request
	 */
	public static void enqueue(Request request){
		mOkHttpClient.newCall(request).enqueue(new Callback(){

			@Override
			public void onFailure(Request arg0, IOException arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onResponse(Response arg0) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	
	public static String getStringFromServer(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();
		Response response = execute(request);
		if(response.isSuccessful()){
			String responseUrl = response.body().string();
			return responseUrl;
		}else{
			throw new IOException("Unexpected code"+response);
		}
	}
	
	private static final String CHARSET_NAME = "UTF-8";
	/**
	 * ����ʹ����HttpClient��API
	 * @param params
	 * @return
	 */
	public static String formatParams(List<BasicNameValuePair> params){
		return URLEncodedUtils.format(params, CHARSET_NAME);
	}
	/**
	 * ΪHttpGet��url��������Ӷ��name value����
	 * @param url
	 * @param params
	 * @return
	 */
	public static String attachHttpGetParams(String url,List<BasicNameValuePair> params){
		return url +"?"+formatParams(params);
	}
	
	public static String attachHttpGetParam(String url,String name,String value){
		return url+"?"+name+"="+value;
	}
}