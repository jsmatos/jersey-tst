package com.jsmatos.jersey.tst;

import com.jsmatos.some.api.impl.DefaultResourceMethodInvocationHandlerProviderImpl;
import org.glassfish.jersey.server.model.Invocable;
import org.glassfish.jersey.server.spi.internal.ResourceMethodInvocationHandlerProvider;

import java.lang.reflect.InvocationHandler;

public class JerseyResourceMethodInvocationHandlerProviderAdapter implements ResourceMethodInvocationHandlerProvider {

    private final com.jsmatos.some.api.ResourceMethodInvocationHandlerProvider api;

    //ToDo: don't know why can't inject the default impl of api
    public JerseyResourceMethodInvocationHandlerProviderAdapter() {
        this.api = new DefaultResourceMethodInvocationHandlerProviderImpl();
    }

    @Override
    public InvocationHandler create(Invocable method) {
        return this.api.getInvocationHandlerFor(method.getDefinitionMethod());
    }
}
