package com.volodymyr.register_usertest_task.utils;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.stream.Collectors;

public class DefaultUtils {

    public static List<String> bindingResultToList(BindingResult bindingResult, String fieldName) {
        return bindingResult.getFieldErrors(fieldName)
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());
    }
}
