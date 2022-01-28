package cn.edu.gzhu.api;

import cn.edu.gzhu.utils.result.ResultDTO;

/**
 * @author Touale
 * @description WalletManager
 * @date 2022/1/28 16:13
 */
public class WalletManager extends
        InitWalletManager {


    /**
     * in my opinion,this need a good architecture here
     * <p>
     * There should not be just one account, but multiple accounts!!!
     * <p>
     * one accout example is as follow!
     */

    private String walletAdress;
    private String walletPublicKey;
    private String walletPrivateKey; // unsafe,it should save in file with complex algorithm


    public ResultDTO crateNewAccount() {
        /**
         * ToDo
         */
        return null;
    }

    public ResultDTO importAccount() {
        /**
         * ToDo
         */
        return null;
    }

    public ResultDTO updateAccount() {
        /**
         *
         */
        return null;
    }

    public String getWalletAdress() {

        /**
         * ToDo
         */
        return null;
    }

    private Boolean isValidMnemonic() {

        /**
         * ToDo
         * Verify that the mnemonic is valid
         * Including the length of mnemonic,the parity bit of...
         */
        return null;
    }

    private Boolean isValidAdress() {
        /**
         * ToDo
         * Verifies the address validity when in transaction
         */
        return null;
    }

    public String getCurrentBalance() {
        /**
         * ToDo
         * notice:
         * Note that this interface does not require the privatekey!!!
         */
        return null;
    }

    public void translation() {
        /**
         * pre
         */
    }


}
