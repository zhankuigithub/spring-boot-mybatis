package com.zk.springboot.environment.impl;

import com.zk.springboot.environment.IEnvProvider;

public class DevEnvProvider implements IEnvProvider {
    @Override
    public String configDir() {
        return System.getenv("ENV_DEV_CONFIG_DIR");
    }
}
