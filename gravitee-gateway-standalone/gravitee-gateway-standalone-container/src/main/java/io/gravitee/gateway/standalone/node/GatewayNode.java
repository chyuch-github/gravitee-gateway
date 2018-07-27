/**
 * Copyright (C) 2015 The Gravitee team (http://gravitee.io)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.gravitee.gateway.standalone.node;

import io.gravitee.common.component.LifecycleComponent;
import io.gravitee.gateway.reactor.Reactor;
import io.gravitee.gateway.report.ReporterService;
import io.gravitee.gateway.services.ServiceManager;
import io.gravitee.gateway.standalone.vertx.VertxEmbeddedContainer;
import io.gravitee.node.container.AbstractNode;
import io.gravitee.plugin.core.api.PluginRegistry;
import io.gravitee.plugin.core.internal.PluginEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * @author David BRASSELY (david.brassely at graviteesource.com)
 * @author GraviteeSource Team
 */
public class GatewayNode extends AbstractNode {

    @Override
    public String name() {
        return "API Gateway node";
    }

    @Override
    public List<Class<? extends LifecycleComponent>> components() {
        List<Class<? extends LifecycleComponent>> components = new ArrayList<>();

        components.add(PluginEventListener.class);
        components.add(PluginRegistry.class);
        components.add(Reactor.class);
        components.add(ServiceManager.class);
        components.add(ReporterService.class);
        components.add(VertxEmbeddedContainer.class);

        return components;
    }
}
