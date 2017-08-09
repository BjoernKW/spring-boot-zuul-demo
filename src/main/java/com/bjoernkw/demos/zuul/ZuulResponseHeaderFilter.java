package com.bjoernkw.demos.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.POST_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SEND_RESPONSE_FILTER_ORDER;

@Component
public class ZuulResponseHeaderFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return SEND_RESPONSE_FILTER_ORDER;
    }

    @Override
    public boolean shouldFilter() {
        return true; // always apply filter
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        context.addZuulResponseHeader("Zuul-Test-Response-Header", "Zuul test response header");

        return null;
    }
}
