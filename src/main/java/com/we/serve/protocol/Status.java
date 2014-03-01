package com.we.serve.protocol;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum Status{
    //Name               Code
    //Success 2 _ _
    OK                  (200,"OK"),
    CREATED             (201,"CREATED"),
    ACCEPTED            (202,"Accepted"),
    PARTIAL_INFORMATION (203,"Partial Information"),
    NO_RESPONSE         (204,"No Response"),
    //Error 4 _ _, 5 _ _
    BAD_REQUEST         (400,"Bad Request"),
    UNAUTHORIZED        (401,"Unauthorized"),
    PAYMENT_REQUIRED    (402,"PaymentRequired"),//Who knew this exists?
    FORBIDDEN           (403,"Forbidden"),//Thou shalt not pass.
    NOT_FOUND           (404,"Not found"),//Not found? FFFFFUUUUUU
    INTERNAL_ERROR      (500,"Internal Error"),//It's not you, it's me.
    NOT_IMPLEMENTED     (501,"Not Implemented"),//Under construction.*Palms sweaty forehead*
    SERVICE_OVERLOADED  (502,"Service temporarily overloaded"),
    GATEWAY_TIMEOUT     (503,"Gateway timeout"),
    //Redirection 3 _ _
    MOVED               (301,"Moved"),
    FOUND               (302,"Found"),
    METHOD              (303,"Method"),
    NOT_MODIFIED        (304,"Not Modified");
    private final int code;
    private final String msg;
    private static final Map<Integer,Status> lookup = new HashMap<Integer,Status>();
    Status(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode(){
        return code;
    }
    public String getMessage(){
        return msg;
    }
    static {
        for(Status s : EnumSet.allOf(Status.class))
            lookup.put(s.getCode(), s);
        }
    public static Status get(int code) { 
        return lookup.get(code); 
    }
}