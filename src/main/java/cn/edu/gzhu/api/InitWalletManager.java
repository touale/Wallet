package cn.edu.gzhu.api;

import cn.edu.gzhu.BIP32.extended.ExtendedPrivateKey;
import cn.edu.gzhu.BIP32.netWorksManage.netWorks.Bitcoin;
import cn.edu.gzhu.BIP39.MnemonicGenerator;
import cn.edu.gzhu.BIP39.SeedCalculator;
import cn.edu.gzhu.BIP39.wordlists.English;
import cn.edu.gzhu.BIP39.wordlists.Words;
import cn.edu.gzhu.BIP44.AddressIndex;
import cn.edu.gzhu.BIP44.BIP44;
import cn.edu.gzhu.entity.EcKeys;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;

import java.security.SecureRandom;

import static cn.edu.gzhu.BIP32.util.ByteUtils.hex2Bytes;
import static cn.edu.gzhu.BIP39.util.ByteUtils.bytes2Hex;

/**
 * @author Touale
 * @description InitWalletManager
 * @date 2022/1/28 15:40
 */
public class InitWalletManager {

    public String generatorMnemonic() {
        StringBuilder sb = new StringBuilder();
        byte[] entropy = new byte[Words.TWELVE.byteLength()];
        new SecureRandom().nextBytes(entropy);
        new MnemonicGenerator(English.INSTANCE)
                .createMnemonic(entropy, sb::append);
        return sb.toString();
    }


    public String mnemonicToSeed(String mnemonic) {
        /**
         Most wallet software defaults to empty passphrase
         */
        byte[] seed = new SeedCalculator().calculateSeed(
                mnemonic, "");
        return bytes2Hex(seed);
    }

    public EcKeys mnemonicsToKeyPair(String mnemonic, Integer index) {
        String seed = mnemonicToSeed(mnemonic);
        return generateKeyPair(seed, index);
    }

    public EcKeys seedToKeyPair(String seed, Integer index) {
        return generateKeyPair(seed, index);
    }

    private EcKeys generateKeyPair(String seed, Integer index) {
        AddressIndex addressIndex = BIP44
                .m()
                .purpose44()
                .coinType(60)
                .account(0)
                .external()
                .address(index);

        ExtendedPrivateKey rootKey = ExtendedPrivateKey.fromSeed(
                hex2Bytes(seed),
                Bitcoin.MAIN_NET);

        ExtendedPrivateKey childPrivateKey = rootKey.derive(addressIndex, AddressIndex.DERIVATION);

        byte[] privateKeyBytes = childPrivateKey.getKey();

        String privateKey = childPrivateKey.getPrivateKey();
        String publicKey = childPrivateKey.neuter().getPublicKey();
        String address = Keys.getAddress(ECKeyPair.create(privateKeyBytes));

        EcKeys ecKeys = new EcKeys();
        ecKeys.setPublicKey(publicKey);
        ecKeys.setPrivateKey(privateKey);
        ecKeys.setAddress(address);

        return ecKeys;
    }


}
