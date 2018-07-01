package com.jsmatos.some.api.impl;

import com.jsmatos.some.api.NeedsValidation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

public class XyzCaseNeedingValidationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("applying DEFAULT_INVOCATION_HANDLER on " + method);
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            NeedsValidation needsValidation = parameter.getAnnotation(NeedsValidation.class);
            if (needsValidation != null) {
                validate(proxy, method, args, parameter, i);
            }
        }
        return method.invoke(proxy, args);
    }


    void validate(Object proxy, Method method, Object[] args, Parameter parameter, int parameterIndex) {
        String msg = "validating call to " + method.getDeclaringClass().getSimpleName() + "." + method.getName();
        if (args.length > 0) {
            msg += " with args " + Arrays.toString(args);
        }
        System.out.println(msg);
    }
}
