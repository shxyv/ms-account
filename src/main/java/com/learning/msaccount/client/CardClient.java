package com.learning.msaccount.client;

import com.learning.msaccount.client.model.Card;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-card")
public interface CardClient {

    @GetMapping("api/v1/cards/{id}")
    Card getCardById(@PathVariable Long id);


}
