package com.wallet.crypto.alphawallet.repository;

import com.wallet.crypto.alphawallet.entity.NetworkInfo;
import com.wallet.crypto.alphawallet.entity.Token;
import com.wallet.crypto.alphawallet.entity.TokenTicker;
import com.wallet.crypto.alphawallet.entity.Wallet;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface TokenLocalSource {
    Completable saveTokens(NetworkInfo networkInfo, Wallet wallet, Token[] items);
    void updateTokenBalance(NetworkInfo network, Wallet wallet, Token token);
    void setEnable(NetworkInfo network, Wallet wallet, Token token, boolean isEnabled);
    void updateTokenBurn(NetworkInfo network, Wallet wallet, Token token, List<Integer> burn);

    Single<Token[]> fetchEnabledTokens(NetworkInfo networkInfo, Wallet wallet);
    Single<Token[]> fetchAllTokens(NetworkInfo networkInfo, Wallet wallet);
    Single<Token> fetchEnabledToken(NetworkInfo networkInfo, Wallet wallet, Token token);

    Completable saveTickers(NetworkInfo network, Wallet wallet, TokenTicker[] tokenTickers);
    Single<TokenTicker[]> fetchTickers(NetworkInfo network, Wallet wallet, Token[] tokens);
}