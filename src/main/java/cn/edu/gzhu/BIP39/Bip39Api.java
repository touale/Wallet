package cn.edu.gzhu.BIP39;

import cn.edu.gzhu.BIP39.wordlists.English;
import cn.edu.gzhu.BIP39.wordlists.Words;

import java.security.SecureRandom;

/**
 * @author Touale
 * @description Bip39Api
 * @date 2022/1/27 16:09
 */
public class Bip39Api {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        byte[] entropy = new byte[Words.TWELVE.byteLength()];
        new SecureRandom().nextBytes(entropy);
        new MnemonicGenerator(English.INSTANCE)
                .createMnemonic(entropy, sb::append);
        System.out.println(sb.toString());
    }
}
