package com.jsmatos.jersey.tst;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.spi.internal.ResourceMethodInvocationHandlerProvider;

import javax.inject.Singleton;
import javax.ws.rs.core.Feature;
import javax.ws.rs.core.FeatureContext;
import javax.ws.rs.ext.Provider;

@Provider
public class Hk2Feature implements Feature {

    @Override
    public boolean configure(FeatureContext context) {
        context.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bind(JerseyResourceMethodInvocationHandlerProviderAdapter.class)
                        .to(ResourceMethodInvocationHandlerProvider.class).in(Singleton.class);
            }
        });
        return true;
    }
}