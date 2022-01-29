package cn.edu.gzhu;

import cn.edu.gzhu.api.BasicWalletManage;
import cn.edu.gzhu.api.WalletManager;
import cn.edu.gzhu.entity.EcKeys;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author Touale
 * @description TestApplication
 * @date 2022/1/28 15:51
 */
public class TestApplication {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        /**
         * this project includes two parts,one is here!
         *
         * in this part,it takes a couple of example calls to try to figure out how it works
         *
         * and the api in this project is too simple to composite beacause of the short time!
         *
         * if I have much time,I will do it in a good architecture!
         */


        WalletManager manager = new WalletManager();

        /**
         * ===> generatorMnemonic():brush cream course vital reform bridge toy general globe element aisle siege
         */

        String mnemonic = manager.generatorMnemonic();
        System.out.println("===> mnemonic:" + mnemonic);

        /**
         * ===> mnemonicToSeed():272697d0dda1897f325b43fcd462eb0d84796e1b471363285b8515b94d3c5bc80e40c01548a7c4a8d606aadcf99538efc603033bd7d08a8eccafba5a776c21ba
         */
        System.out.println("===> seed:" + manager.mnemonicToSeed(mnemonic));

        /**
         * EcKeys ecKeys = manager.seedToKeyPair(
         *                 "a5b76acc6607175f8a085e1b2ed3da0f5e98248f45de77e7bb50753d6be031c31be722fc8737f4cd99c73e811347549ae318e222d23a33d989451910af69b6b9", 0);
         * or
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
        System.out.println("===> new publicKey:0x" + ecKeys.getPublicKey());
        System.out.println("===> new privateKey:0x" + ecKeys.getPrivateKey());
        System.out.println("===> new address:0x" + ecKeys.getAddress());

        /**
         * all console:
         *
         * ===> mnemonic:brush cream course vital reform bridge toy general globe element aisle siege
         * ===> seed:272697d0dda1897f325b43fcd462eb0d84796e1b471363285b8515b94d3c5bc80e40c01548a7c4a8d606aadcf99538efc603033bd7d08a8eccafba5a776c21ba
         * ===> publicKey:0x020551ecb8f4358e4ce6e253cfb680f083075c3bbcca665cee76af12c3e9f994a0
         * ===> privateKey:0xab430b39fae59b04e337683f3f6fce686da274d2ffcc63b52e209c0d400a43fa
         * ===> address:0xd4cad7bea2845a5c98d41cd5b696cf2ed924a360
         */


        /**
         * this is not the turly main ETH netWork!
         * Instead,it is done by the test ETH netWork
         * like this,https://ropsten.infura.io/v3/9aa3d95b3bc440fa88ea12eaa4456161
         * you can change it by this class by url
         */
        BasicWalletManage base = new BasicWalletManage();

        /**
         * query the balance of the address
         * 0.499958429283743
         */
        System.out.println(base.getCurrentBalance("0xd4cad7bea2845a5c98d41cd5b696cf2ed924a360"));



        /**
         * example of trying a transaction,
         * and the arguments are in the function!
         */
        base.signETHTransaction();

    }

}
