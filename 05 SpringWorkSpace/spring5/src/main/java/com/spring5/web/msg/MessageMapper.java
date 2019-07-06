package com.spring5.web.msg;

public interface MessageMapper {

  public void create(Message vo) throws Exception;

  public Message readMessage(Integer mid) throws Exception;

  public void updateState(Integer mid) throws Exception;

}
