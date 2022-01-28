package cn.edu.gzhu;

import cn.edu.gzhu.api.InitWalletManager;
import cn.edu.gzhu.api.WalletManager;
import cn.edu.gzhu.entity.EcKeys;
import com.alibaba.fastjson.JSONObject;
import org.web3j.crypto.ECKeyPair;
import org.web3j.crypto.Keys;
import org.web3j.utils.Numeric;

/**
 * @author Touale
 * @description TestApplication
 * @date 2022/1/28 15:51
 */
public class TestApplication {
    public static void main(String[] args) {
        WalletManager manager = new WalletManager();

        /**
         * ===> mnemonic:brush cream course vital reform bridge toy general globe element aisle siege
         */

        String mnemonic = manager.generatorMnemonic();
        System.out.println("===> mnemonic:" + mnemonic);

        /**
         * ===> seed:272697d0dda1897f325b43fcd462eb0d84796e1b471363285b8515b94d3c5bc80e40c01548a7c4a8d606aadcf99538efc603033bd7d08a8eccafba5a776c21ba
         */
        System.out.println("===> seed:" + manager.mnemonicToSeed(mnemonic));

        /**
         * EcKeys ecKeys = manager.seedToKeyPair(
         *                 "a5b76acc6607175f8a085e1b2ed3da0f5e98248f45de77e7bb50753d6be031c31be722fc8737f4cd99c73e811347549ae318e222d23a33d989451910af69b6b9", 0);
         *
         * or
         *
         * EcKeys ecKeys = manager.mnemonicsToKeyPair(
         *                 "push toast render sleep galaxy rubber predict three silk define gospel member",
         *                 0);
         *
         */

        /**
         * ===> publicKey:0x020551ecb8f4358e4ce6e253cfb680f083075c3bbcca665cee76af12c3e9f994a0
         * ===> privateKey:0xab430b39fae59b04e337683f3f6fce686da274d2ffcc63b52e209c0d400a43fa
         * ===> address:0xd4cad7bea2845a5c98d41cd5b696cf2ed924a360
         */
        EcKeys ecKeys = manager.mnemonicsToKeyPair(
                mnemonic,
                0);
        System.out.println("===> publicKey:0x" + ecKeys.getPublicKey());
        System.out.println("===> privateKey:0x" + ecKeys.getPrivateKey());
        System.out.println("===> address:0x" + ecKeys.getAddress());

        /**
         * all console:
         *
         * ===> mnemonic:brush cream course vital reform bridge toy general globe element aisle siege
         * ===> seed:272697d0dda1897f325b43fcd462eb0d84796e1b471363285b8515b94d3c5bc80e40c01548a7c4a8d606aadcf99538efc603033bd7d08a8eccafba5a776c21ba
         * ===> publicKey:0x020551ecb8f4358e4ce6e253cfb680f083075c3bbcca665cee76af12c3e9f994a0
         * ===> privateKey:0xab430b39fae59b04e337683f3f6fce686da274d2ffcc63b52e209c0d400a43fa
         * ===> address:0xd4cad7bea2845a5c98d41cd5b696cf2ed924a360
         */

    }

}
