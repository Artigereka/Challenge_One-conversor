package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;

import resources.Currency;

public class TestAPI {
	
	public static void main(String[] args) {
		
		String apiKey = "ar2l9a68u3o8si1qf5mplondt42l9m01j04tdi5ft58mj0hjdb3m8";
		String base = "GBP";
		String to = "EUR";
		BigDecimal amount = new BigDecimal("100");
//		String converted;
		String urlRequested = "https://anyapi.io/api/v1/exchange/convert?base=" + base + "&to=" + to + "&amount="
				+ amount.intValue() + "&apiKey=" + apiKey;
		
		try {
			@SuppressWarnings("depracation")
			URL url = new URL(urlRequested);
			
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

//			Check if connect is made
			int responseCode = conn.getResponseCode();
//			200 OK - 400 Bad request - 500 Internal server error
			if (responseCode != 200) {
				throw new RuntimeException("HttpResponseCode: " + responseCode);
			} else {
//				Get API response (JSON)
				InputStream inputStream = conn.getInputStream();
				BufferedReader rd = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
				String response = readAll(rd);
//				Store API useful data

				Gson gson = new Gson();
				Currency currency = gson.fromJson(response, Currency.class);

				System.out.println(response);
				System.out.println(currency.getConverted());

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static String readAll(Reader rd) throws IOException{
		StringBuilder stringBuilder = new StringBuilder();
		int cp;
		while((cp = rd.read()) != -1) {
			stringBuilder.append((char) cp);
		}
		return stringBuilder.toString();
	}

}
