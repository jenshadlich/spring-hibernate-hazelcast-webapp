package de.jeha.spring_hibernate_hazelcast_webapp.struts2.aspects;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestartTransactionInterceptor implements MethodInterceptor {

	private static final Logger LOG = LoggerFactory.getLogger(RestartTransactionInterceptor.class);

	public Object invoke(MethodInvocation invocation) throws Throwable {
		return restart(invocation, 1);
	}

	private Object restart(MethodInvocation invocation, int attempt) throws Throwable {
		Object rval = null;
		try {
			rval = invocation.proceed();
		} catch (Exception e) {
			Throwable thr = ExceptionUtils.getRootCause(e);
			if (thr == null) {
				throw e;
			}

			if (StringUtils.contains(thr.getMessage(), "deadlock")
					|| StringUtils.contains(thr.getMessage(), "try restarting transaction")
					|| StringUtils.contains(thr.getMessage(), "failed to resume the transaction")) {
				if (attempt > 300) {
					throw e;
				}
				int timeout = RandomUtils.nextInt(2000);
				LOG.warn("Transaction rolled back. Restarting transaction.");
				LOG.debug("Spleep for " + timeout);
				LOG.debug("Restarting transaction: invocation=[" + invocation + "], attempt=[" + attempt + "]");
				Thread.sleep(timeout);
				attempt++;
				return restart(invocation, attempt);
			} else {
				throw e;
			}
		}
		return rval;
	}
}