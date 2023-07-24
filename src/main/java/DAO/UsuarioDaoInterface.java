package DAO;

import Modelo.Pessoa;

public interface UsuarioDaoInterface {
    public void inserir(Pessoa u) throws ErroDAO;
    public void deletar(Pessoa u) throws ErroDAO;
    public void deletar(int codigo) throws ErroDAO;
    public void editar(Pessoa u) throws ErroDAO;
    public Pessoa buscar(int codigo) throws ErroDAO;
    public Pessoa buscar(Pessoa u) throws ErroDAO;
    public Pessoa buscar(String login, String senha) throws ErroDAO;
}