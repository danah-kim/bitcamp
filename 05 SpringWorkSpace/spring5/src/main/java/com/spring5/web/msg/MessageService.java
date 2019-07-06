package com.spring5.web.msg;

import com.spring5.web.msg.Message;

public interface MessageService {

  public void addMessage(Message vo) throws Exception;

  public Message readMessage(String uid, Integer mno) throws Exception;
}
