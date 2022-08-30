package com.radin.blockchainpublishservices.ethereum;

import com.radin.blockchainpublishservices.config.EthereumConfig;
import org.web3j.crypto.RawTransaction;
import org.web3j.protocol.Web3jService;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.DefaultGasProvider;

import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

public class EthereumManager {
    HttpService ethService = new HttpService(EthereumConfig.PROVIDER_URL);
    public Admin ethAdmin = Admin.build(ethService);

    public BigInteger getAccountNonce(String address) throws ExecutionException, InterruptedException {
        EthGetTransactionCount txCount = ethAdmin.ethGetTransactionCount(address, DefaultBlockParameterName.LATEST).sendAsync().get();
        return txCount.getTransactionCount();
    }

    public RawTransaction createEthTransaction(String fromAddress, String toAddress, BigInteger value) throws ExecutionException, InterruptedException {
        BigInteger nonce = this.getAccountNonce(fromAddress);
        return RawTransaction.createEtherTransaction(nonce, DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT, toAddress, value);
    }

//    public RawTransaction createERC20Transaction() {
//    }
//
//    public String encodeRawTransaction(RawTransaction rawTransaction) {
//
//    }
}
