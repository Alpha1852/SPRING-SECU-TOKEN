package com.example.Util;

import org.springframework.beans.factory.annotation.Value;

public class ConstantUtil {


    final public static double ERP_TAX_RATE=1.2;


    @Value("ERP.TAX_RATE")
    public static double ERP_TAX_RATE_PROPERTIES;
}
