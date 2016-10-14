package org.test.bin;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.AbstractJavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;
import org.test.C3P0Test;
import org.test.JDBCWthoutDBPoolTest;

/**
 * hejinbin , QQ 107966750, C3P0的测试用例,放入jmeter中 2016-10-13
 */
public class JDBWithC3P0JmertRuning extends AbstractJavaSamplerClient {
	// 填参数
	public Arguments getDefaultParameters() {
		Arguments params = new Arguments();

		return params;
	}

	// 测试查询
//	public SampleResult runTest(JavaSamplerContext arg0) {
//		SampleResult sr = new SampleResult();
//		try {
//			sr.sampleStart();
//			Long aid = C3P0Test.queryTest();
//			// Long aid = 741l;
//			// 逾期值
//			if (aid == 741) {
//				// 只有是预期值才判断查询成功
//				sr.setSuccessful(true);
//			} else {
//				sr.setSuccessful(false);
//			}
//		} catch (Exception e) {
//			sr.setSuccessful(false);
//			e.printStackTrace();
//		} finally {
//			sr.sampleEnd();
//		}
//		return sr;
//	}
	public SampleResult runTest(JavaSamplerContext arg0) {
		SampleResult sr = new SampleResult();
		try {
			sr.sampleStart();
			C3P0Test.insertTest();

			// 只有是预期值才判断查询成功
			sr.setSuccessful(true);

		} catch (Exception e) {
			sr.setSuccessful(false);
			e.printStackTrace();
		} finally {
			sr.sampleEnd();
		}
		return sr;
	}

}
