package com.radin.blockchainpublishservices.ethereum;

public enum EthereumNetworkType {
    GOERLI("goerli"),
    ROPSTEN("ropsten"),
    MAINNET("mainnet");

    private String networkType;

    EthereumNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public String getNetworkType() {
        return networkType;
    }
}
