package br.android.cericatto.infoglobo.presenter.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.google.gson.Gson;

import java.util.List;

/**
 * Utils.java.
 * 
 * @author Rodrigo Cericatto
 * @since Mar 29, 2017
 */
public class Utils {

	//--------------------------------------------------
	// Network Methods
	//--------------------------------------------------

	public static Boolean checkConnection(Context context) {
		ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = manager.getActiveNetworkInfo();
		if (networkInfo != null && networkInfo.isConnected()) {
			return true;
		}
		return false;
	}

	//--------------------------------------------------
	// Binding Methods
	//--------------------------------------------------

	public static String capitalize(String text) {
		if (Utils.isEmpty(text)) return "";
		return text.toUpperCase();
	}

	public static String setAutor(List<String> list) {
		if (list == null || list.size() <= 0) return "";
		return list.get(0).toUpperCase();
	}

	public static String setPublicadoEm(String publicadoEm) {
		String[] firstSplit = publicadoEm.split("-");
		String[] secondSplit = firstSplit[2].split("T");
		String[] thirdSplit = secondSplit[1].split("-");
		String dia = secondSplit[0];
		String mes = firstSplit[1];
		String ano = firstSplit[0];
		String hora = thirdSplit[0];
		return dia + "/" + mes + "/" + ano + " " + hora;
	}

	//--------------------------------------------------
	// String Methods
	//--------------------------------------------------

	public static Boolean isEmpty(String text) {
		Boolean result = true;
		Boolean isNull = (text == null);
		if (!isNull) {
			Boolean isZeroLength = (text.length() <= 0);
			Boolean isEmpty = (text.equals(""));
			result = isNull || isZeroLength || isEmpty;
		}
		return result;
	}

	//--------------------------------------------------
	// Json Generics Methods
	//--------------------------------------------------

	public static String toJson(Object object) {
		return new Gson().toJson(object);
	}
}