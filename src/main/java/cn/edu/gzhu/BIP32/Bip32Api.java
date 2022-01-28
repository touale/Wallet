package cn.edu.gzhu.BIP32;


import cn.edu.gzhu.BIP32.extended.ExtendedPrivateKey;
import cn.edu.gzhu.BIP32.extended.ExtendedPublicKey;
import cn.edu.gzhu.BIP32.netWorksManage.netWorks.Bitcoin;

import static cn.edu.gzhu.BIP32.util.ByteUtils.hex2Bytes;

import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

/**
 * @author Touale
 * @description Applicaiton
 * @date 2022/1/27 17:15
 */
public class Bip32Api {
    public static void main(String[] args) {
        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(hex2Bytes(
                        "126e057d3066eda1d9e3bf5587a7436c8ab62c27918b552495ba751f036d2eff213b4a86663f20933ca7eb53c72e24dac8e18a85ec23afed96fb499df0016603"),
                Bitcoin.MAIN_NET);
        ExtendedPrivateKey childPri = rootKey.derive("m/44'/60'/0'/0/0");
        ExtendedPublicKey childPub = childPri.neuter();
        System.out.println(childPri.extendedBase58());
        System.out.println(childPub.extendedBase58());


        // 4. get key pair
        byte[] privateKeyBytes = childPri.getKey();
        ECKeyPair keyPair = ECKeyPair.create(privateKeyBytes);

        // we 've gotten what we need
        String privateKey = childPri.getPrivateKey();
        String publicKey = childPri.neuter().getPublicKey();
        String address = Keys.getAddress(keyPair);

        System.out.println("privateKey:"+privateKey);
        System.out.println("publicKey:"+publicKey);
        System.out.println("address:"+ address);

    }
}
