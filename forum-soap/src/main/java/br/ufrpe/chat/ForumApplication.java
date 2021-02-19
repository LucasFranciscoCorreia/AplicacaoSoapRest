package br.ufrpe.chat;

import br.ufrpe.chat.beans.ValidacaoUsuario;

import javax.xml.ws.Endpoint;

public class ForumApplication {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/", new ValidacaoUsuario());
    }
}
