package personal.ztcao.baseframe.net.base.interceptor;
import java.io.IOException;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ParamsInterceptor implements Interceptor {

	@Override
	public Response intercept(Chain chain) throws IOException {
		Request oldRequest = chain.request();
		Request newRequest = oldRequest ;
		RequestBody body   = oldRequest.body();
		if (body != null) { //修改oldRequest
			RequestBody newBody = null;
			if (body instanceof FormBody) {
				newBody = addParamsToFormBody((FormBody) body);
			} else if (body instanceof MultipartBody) {
				newBody = addParamsToMultipartBody((MultipartBody) body);
			}

			if (null != newBody) {
				newRequest = oldRequest.newBuilder().url(oldRequest.url())
						.method(oldRequest.method(), newBody)
						.build();
			}else{
				newRequest = addParamsToQuery(oldRequest) ;
			}
		}
		return chain.proceed(newRequest);
	}

	/**
	 * 为MultipartBody类型请求体添加参数
	 *
	 * @param body
	 * @return
	 */
	private MultipartBody addParamsToMultipartBody(MultipartBody body) {
		MultipartBody.Builder builder = new MultipartBody.Builder();
		builder.setType(MultipartBody.FORM);
		Map<String ,String> paramMap = ParamSupplier.supplyParamMap() ;
		for (String key : paramMap.keySet()) {
			builder.addFormDataPart(key, paramMap.get(key));
		}

		//添加
		for (int i = 0; i < body.size(); i++) {
			builder.addPart(body.part(i));
		}
		  return builder.build();
	}

	/*
	 * / 为FormBody类型请求体添加
	 * 
	 * @param bo
	 * 
	 * @param paramsBuild
	 * 
	 * @return
	 **/

	private FormBody addParamsToFormBody(FormBody body) {
		FormBody.Builder builder = new FormBody.Builder();
		for (int i = 0; i < body.size(); i++) {
			builder.addEncoded(body.encodedName(i), body.encodedValue(i));
		}

		Map<String ,String> paramMap = ParamSupplier.supplyParamMap() ;
		for (String key : paramMap.keySet()) {
			builder.addEncoded(key, paramMap.get(key));
		}
		return builder.build();
	}

	//url后面增加公共的查询参数
	private Request addParamsToQuery(Request oldRequest) {
		Map<String ,String> paramMap = ParamSupplier.supplyParamMap() ;
		HttpUrl.Builder httpUrlBuilder = oldRequest.url().newBuilder() ;
		for (String key : paramMap.keySet()) {
			httpUrlBuilder.addQueryParameter(key, paramMap.get(key));
		}
		Request newRequest = oldRequest.newBuilder().url(httpUrlBuilder.build()).build();
		return newRequest;
	}
}

