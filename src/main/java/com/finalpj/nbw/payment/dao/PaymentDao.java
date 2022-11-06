package com.finalpj.nbw.payment.dao;

import com.finalpj.nbw.payment.domain.CartProduct;
import com.finalpj.nbw.payment.domain.Payment;
import com.finalpj.nbw.payment.domain.UnMemPayment;

import java.util.List;
import java.util.Map;

public interface PaymentDao {

    int insertUnMemPayment(UnMemPayment unMemPaymentDto) throws Exception;                 // 비회원 : tb_unmempayment 테이블에 결제 정보 등록

    int insertMemPayment(Payment paymentDto) throws Exception;                        // 회원 : tb_memberPayment에 결제정보 등록(1건)
   
    int insertPayDetail(List<Map<String,Object>> payDetailList) throws Exception;  // 회원 : tb_memberPaymentdetail 결제 정보 등록(n건)

    List<CartProduct> selectPayAfter (Map<String,Object> pMap) throws Exception;              // 회원 : 결제 후 주문 완료된 상품 조회

    Map<String,Object> selectReceiver (String order_no) throws Exception;             // 회원 : 결제 후 주문 수령자 정보 및 결제정보 조회

    Map<String,Object> selectUnMemReceiver(String order_no) throws Exception;
}
