package Modelo;

import java.util.Objects;

public class Pessoa {
    private int codigo, dataNasc;
    private String login,senha,nome, nomeMae, naturalidade, naturalidadeMun, endereco ;
    private boolean flagMedico;

    public Pessoa() {

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(int dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public String getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }

    public String getNaturalidadeMun() {
        return naturalidadeMun;
    }

    public void setNaturalidadeMun(String naturalidadeMun) {
        this.naturalidadeMun = naturalidadeMun;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean isFlagMedico() {
        return flagMedico;
    }

    public void setFlagMedico(boolean flagMedico) {
        this.flagMedico = flagMedico;
    }

    public Pessoa(int codigo, int dataNasc, String login, String senha, String nome, String nomeMae, String naturalidade, String naturalidadeMun, String endereco, boolean flagMedico) {
        this.codigo = codigo;
        this.dataNasc = dataNasc;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.naturalidade = naturalidade;
        this.naturalidadeMun = naturalidadeMun;
        this.endereco = endereco;
        this.flagMedico = flagMedico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return codigo == pessoa.codigo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "codigo=" + codigo +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                '}';
    }
}