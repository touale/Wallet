package cn.edu.gzhu.BIP39;

import cn.edu.gzhu.BIP39.wordlists.English;
import cn.edu.gzhu.BIP39.wordlists.Words;

import java.security.SecureRandom;

import static cn.edu.gzhu.BIP39.util.ByteUtils.bytes2Hex;

/**
 * @author Touale
 * @description Bip39Api
 * @date 2022/1/27 16:09
 */
public class Bip39Api {

    public void apiTest_MnemonicGenerator() {
        StringBuilder sb = new StringBuilder();
        byte[] entropy = new byte[Words.TWELVE.byteLength()];
        new SecureRandom().nextBytes(entropy);
        new MnemonicGenerator(English.INSTANCE)
                .createMnemonic(entropy, sb::append);
        System.out.println(sb.toString());
    }

    public void apiTest_SeedCalculator() {
        byte[] seed = new SeedCalculator().calculateSeed(
                "biology burden bike luxury connect height chapter jeans ready exhibit case almost",
                "123456");
        System.out.println(bytes2Hex(seed));
    }

}
