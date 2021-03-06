
package com.flchy.cloud.gateway.provider;

import java.util.ArrayList;
import java.util.List;

/**
 * 鉴权配置
 *
 * @author Chill
 */
public class AuthProvider {

	public static String TARGET = "/**";
	public static String REPLACEMENT = "";
	private static List<String> defaultSkipUrl = new ArrayList<>();

	static {
		defaultSkipUrl.add("/example");
		defaultSkipUrl.add("/v2/api-docs/**");
		defaultSkipUrl.add("/v2/api-docs-ext/**");
		defaultSkipUrl.add("/error/**");
		defaultSkipUrl.add("/assets/**");
		defaultSkipUrl.add("/safety-auth/admin/login/login");
		defaultSkipUrl.add("/safety-auth/auth/**");
		defaultSkipUrl.add("/school-admin/led/**");
	}

	/**
	 * 默认无需鉴权的API
	 */
	public static List<String> getDefaultSkipUrl() {
		return defaultSkipUrl;
	}

}
