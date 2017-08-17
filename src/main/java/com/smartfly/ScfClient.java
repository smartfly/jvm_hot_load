package com.smartfly;

import com.bj58.spat.scf.client.SCFInit;
import com.bj58.spat.scf.client.proxy.builder.ProxyFactory;

/**
 * ClassName：Utils<br>
 * Description：通用工具类 .<br>
 * <p>
 * company：58同城 <br>
 * Copyright：Copyright © 2011 58.com All Rights Reserved<br>
 *
 * @author auto
 * @Date 2011-7-30 21:47:50
 * @since JRE 1.6.0_22 or higher
 */
public final class ScfClient {

	final static ScfClient client = new ScfClient();

	static {
		SCFInit.initScfKey("D:\\workspace\\comsmartflylogtest\\src\\main\\resources\\scfkey.key");
	}

	private ScfClient() {

	}
	
	public final static <T> T getScfService(Class<T> service, String url) {
		return ProxyFactory.create(service, url);
	}
}
