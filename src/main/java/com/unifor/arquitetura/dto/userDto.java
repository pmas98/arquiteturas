package com.unifor.arquiteturas.dto;

import com.unifor.arquiteturas.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userDto {
    private long id;
    private String nome;
    private String email;

    public userDto(User user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
    }
}
