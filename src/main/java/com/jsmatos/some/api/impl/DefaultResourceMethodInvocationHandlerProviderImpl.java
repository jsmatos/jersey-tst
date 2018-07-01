package com.jsmatos.some.api.impl;

import com.jsmatos.some.api.NeedsValidation;
import com.jsmatos.some.api.ResourceMethodInvocationHandlerProvider;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class DefaultResourceMethodInvocationHandlerProviderImpl implements ResourceMethodInvocationHandlerProvider {
    @Override
    public InvocationHandler getInvocationHandlerFor(Method method) {
        //ToDo: return different invocation handlers based on method.getDefinitionMethod().getDeclaringClass()
        for (Parameter parameter : method.getParameters()) {
            if (parameter.isAnnotationPresent(NeedsValidation.class)) {
                return getXyzCase();
            }
        }
        return METHOD_NOT_HANDLED_HANDLER;
    }

    private InvocationHandler xyzCase = null;

    private InvocationHandler getXyzCase() {
        if (xyzCase == null) {
            xyzCase = new XyzCaseNeedingValidationHandler();
        }
        return xyzCase;
    }
}
