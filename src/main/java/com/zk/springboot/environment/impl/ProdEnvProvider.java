package com.zk.springboot.environment.impl;

import com.zk.springboot.environment.IEnvProvider;

public class ProdEnvProvider implements IEnvProvider {
    @Override
    public String configDir() {
        return "config";
    }
}
