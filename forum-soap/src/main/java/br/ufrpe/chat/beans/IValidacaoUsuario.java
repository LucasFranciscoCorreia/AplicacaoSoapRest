package br.ufrpe.chat.beans;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface IValidacaoUsuario {
    boolean validarUsuario(String usuario, String senha);
}
