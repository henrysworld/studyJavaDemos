package week02.nio02.gateway.router;

import java.util.List;

public interface HttpEndpointRouter {
    String route(List<String> endpoints);
}
