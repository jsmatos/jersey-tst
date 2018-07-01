package com.jsmatos.some.api;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Provides the {@link InvocationHandler invocation handler} instances designated
 * to handle invocations of the supplied {@link Method resource methods}.
 *
 * @author Marek Potociar (marek.potociar at oracle.com)
 */
public interface ResourceMethodInvocationHandlerProvider {

    /**
     * Get the invocation handler for the invocable resource method. May return
     * {@code null} in case the method is not supported by the provider for whatever
     * reason.
     *
     * @param method resource method.
     * @return invocation handler for the invocable resource method.
     */
    InvocationHandler getInvocationHandlerFor(Method method);

    InvocationHandler METHOD_NOT_HANDLED_HANDLER = null;

}
