package pl.piomin.services.transaction.services;

import java.math.BigInteger;

import org.web3j.tx.gas.StaticGasProvider;

public class CustomizedGasProvider extends StaticGasProvider {
    public static final BigInteger GAS_LIMIT = BigInteger.valueOf(1000_000L);
    public static final BigInteger GAS_PRICE = BigInteger.valueOf(1000_000L);

    public CustomizedGasProvider() {
        super(GAS_PRICE, GAS_LIMIT);
    }
}
