package cn.edu.gzhu.api;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * @author Touale
 * @description BasicWalletManageImpl
 * @date 2022/1/29 16:29
 */
public class BasicWalletManage {
    private final static Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161"));


    public String getCurrentBalance(String address) throws IOException {
        EthGetBalance ethGetBlance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        String balance = Convert.fromWei(new BigDecimal(ethGetBlance.getBalance()), Convert.Unit.ETHER).toPlainString();
        return balance;
    }


    public static void signETHTransaction() throws IOException, ExecutionException, InterruptedException {

        //发送方地址
        String from = "0xd4cad7bea2845a5c98d41cd5b696cf2ed924a360";
        //转账数量
        String amount = "0.5";
        //接收者地址
        String to = "0x21197647b87F385c7284de7e31d1F2bba39a5bAb";
        //发送方私钥
        String privateKey = "0xab430b39fae59b04e337683f3f6fce686da274d2ffcc63b52e209c0d400a43fa";
        //查询地址交易编号
        BigInteger nonce = web3j.ethGetTransactionCount(from, DefaultBlockParameterName.PENDING).send().getTransactionCount();
        //支付的矿工费
        BigInteger gasPrice = web3j.ethGasPrice().send().getGasPrice();
        BigInteger gasLimit = new BigInteger("210000");

        BigInteger amountWei = Convert.toWei(amount, Convert.Unit.ETHER).toBigInteger();
        //签名交易
        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce, gasPrice, gasLimit, to, amountWei, "");
        Credentials credentials = Credentials.create(privateKey);
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        //广播交易
        String hash = web3j.ethSendRawTransaction(Numeric.toHexString(signMessage)).sendAsync().get().getTransactionHash();

        System.out.println("hash:" + hash);
    }
}
