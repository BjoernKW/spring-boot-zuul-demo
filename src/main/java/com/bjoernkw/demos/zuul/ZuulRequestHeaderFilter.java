package com.bjoernkw.demos.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;

@Component
public class ZuulRequestHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true; // always apply filter
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulRequestHeader("Zuul-Test-Request-Header", "Zuul test request header");

        return null;
    }
}
