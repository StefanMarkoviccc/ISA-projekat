package app.isa.service;

import app.isa.domain.model.User;

import java.util.List;

public interface IEmailService {

    void sendActionEmail(List<User> users);


}
