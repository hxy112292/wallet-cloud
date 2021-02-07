package org.blockchain.wallet.dto.blockchain;

public class BlockChainAdr {

    private String address;
    private Long n_tx;
    private Long total_received;
    private Long total_sent;
    private Long final_balance;
    private Long change_index;
    private Long account_index;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getN_tx() {
        return n_tx;
    }

    public void setN_tx(Long n_tx) {
        this.n_tx = n_tx;
    }

    public Long getTotal_received() {
        return total_received;
    }

    public void setTotal_received(Long total_received) {
        this.total_received = total_received;
    }

    public Long getTotal_sent() {
        return total_sent;
    }

    public void setTotal_sent(Long total_sent) {
        this.total_sent = total_sent;
    }

    public Long getFinal_balance() {
        return final_balance;
    }

    public void setFinal_balance(Long final_balance) {
        this.final_balance = final_balance;
    }

    public Long getChange_index() {
        return change_index;
    }

    public void setChange_index(Long change_index) {
        this.change_index = change_index;
    }

    public Long getAccount_index() {
        return account_index;
    }

    public void setAccount_index(Long account_index) {
        this.account_index = account_index;
    }
}
