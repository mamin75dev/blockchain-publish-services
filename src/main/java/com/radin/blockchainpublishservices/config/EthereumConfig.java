package com.radin.blockchainpublishservices.config;

import com.radin.blockchainpublishservices.ethereum.EthereumNetworkType;

public class EthereumConfig {
    public static final String networkType = EthereumNetworkType.GOERLI.getNetworkType();

    private static final String PROVIDER_API_KEY = "549ca5d171f54c2e9c9e1d80d979b84b";

    public static final String PROVIDER_URL = String.format("https://%s.infura.io/v3/%s", networkType, PROVIDER_API_KEY);
}
