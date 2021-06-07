package org.gsef.eventfinder.utils;

import org.apache.tomcat.util.codec.binary.Base64;

public class IdDecoder {
	public static String encode(Long id) {
		return Base64.encodeBase64URLSafeString(Long.toString(id).getBytes());
	}
	
	public static Long decode(String id) {
		return Long.parseLong(new String(Base64.decodeBase64URLSafe(id)));
	}
}
