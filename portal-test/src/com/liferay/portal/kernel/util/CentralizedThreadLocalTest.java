package com.liferay.portal.kernel.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

/**
 * @author Patrik Björk
 */
public class CentralizedThreadLocalTest {

	@Test
	public void testSetAndToMap() {

		for (int i = 0; i < 10; i++) {
			CentralizedThreadLocal<Object> centralizedThreadLocal = new CentralizedThreadLocal<>(true);
			centralizedThreadLocal.set("1");

			centralizedThreadLocal.remove();

			CentralizedThreadLocal<Object> centralizedThreadLocal2 = new CentralizedThreadLocal<>(true);
			centralizedThreadLocal2.set("2");
		}

		Map<CentralizedThreadLocal<?>, Object> shortLivedThreadLocals =
			CentralizedThreadLocal.getShortLivedThreadLocals();

		Assert.assertEquals(10, shortLivedThreadLocals.size());
	}

}
