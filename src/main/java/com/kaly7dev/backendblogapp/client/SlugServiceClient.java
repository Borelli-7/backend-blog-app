package com.kaly7dev.backendblogapp.client;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange
public interface SlugServiceClient {
    @GetExchange("{content}")
    String getSlug(@PathVariable String content);
}
