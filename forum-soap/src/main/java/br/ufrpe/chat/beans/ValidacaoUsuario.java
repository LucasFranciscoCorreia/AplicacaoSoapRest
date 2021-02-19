package br.ufrpe.chat.beans;

import javax.jws.WebService;

@WebService(endpointInterface = "br.ufrpe.chat.beans.IValidacaoUsuario")
public class ValidacaoUsuario implements IValidacaoUsuario{
    private String usuario, senha;

    public ValidacaoUsuario(String usuario, String senha){
        this.usuario = usuario;
        this.senha = senha;
    }
    public ValidacaoUsuario(){
        this.usuario = "admin";
        this.senha = "admin";
    }

    @Override
    public boolean validarUsuario(String usuario, String senha) {
        if(this.usuario.equals(usuario) && this.senha.equals(senha)){
            return true;
        }
        return false;
    }
}
