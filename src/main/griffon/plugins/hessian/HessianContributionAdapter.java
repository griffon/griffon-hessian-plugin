/*
 * Copyright 2012-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.hessian;

import griffon.util.CallableWithArgs;
import groovy.lang.Closure;

import java.util.Map;

/**
 * @author Andres Almiray
 */
public class HessianContributionAdapter implements HessianContributionHandler {
    private HessianProvider provider = DefaultHessianProvider.getInstance();

    public void setHessianProvider(HessianProvider provider) {
        this.provider = provider != null ? provider : DefaultHessianProvider.getInstance();
    }

    public HessianProvider getHessianProvider() {
        return provider;
    }

    public <R> R withHessian(Map<String, Object> params, Closure<R> closure) {
        return provider.withHessian(params, closure);
    }

    public <R> R withBurlap(Map<String, Object> params, Closure<R> closure) {
        return provider.withBurlap(params, closure);
    }

    public <R> R withHessian(Map<String, Object> params, CallableWithArgs<R> callable) {
        return provider.withHessian(params, callable);
    }

    public <R> R withBurlap(Map<String, Object> params, CallableWithArgs<R> callable) {
        return provider.withBurlap(params, callable);
    }
}