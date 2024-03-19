package com.example.exercises.patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.HashMap;

class ProxyExample {

    public static void main(String[] arguments) {
        final Map<String, String> original = new HashMap<>();
        InvocationHandler proxy = (obj, method, args) -> {
            System.out.println("Invoked: " + method.getName());
            return method.invoke(original, args);
        };
        Map<String, String> proxyInstance = (Map) Proxy.newProxyInstance(
                original.getClass().getClassLoader(),
                original.getClass().getInterfaces(),
                proxy);
        proxyInstance.put("key", "value");
        System.out.println(proxyInstance.get("key"));
    }

}
