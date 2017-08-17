package com.smartfly;

import com.bj58.localservice.ai.linkplatform.contract.IPhoneConectRateService;

/**
 * Created with IntelliJ IDEA.
 * User: hutao01
 * Date: 2017/7/11
 * Time: 14:52
 * Description:
 * To change this template use File | Settings | File Templates | Includes | File Header
 */
public class SCFTest {

    public static void main(String[] args) {
        IPhoneConectRateService service = ScfClient.getScfService(IPhoneConectRateService.class,
                "tcp://linkplatformconnectratescf/PhoneConnectRateService");
        try {
            float a = service.getConnectRateById(64850);
            System.out.println(a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
