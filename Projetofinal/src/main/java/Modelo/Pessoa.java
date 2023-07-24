package Modelo;

import java.util.Objects;

public class Pessoa {
    private int idPessoa;
    private String login;
    private String senha;
    private String nome;
    private String nomeMae;
    private String naturalidade;
    private String naturalidadeMun;
    private String endereco;
    private String dataNasc;
    private String sexo;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    private String codigo;
    private int flagMedico;
    public Pessoa() {

    }

    public Pessoa(String nome, String nomeMae, String naturalidade, String naturalidadeMun, String endereco, String dataNasc, int idPessoa, String senha, String sexo, int flagMedico) {
        this.nome = nome;
        this.idPessoa = idPessoa;
        this.nomeMae = nomeMae;
        this.naturalidade = naturalidade;
        this.naturalidadeMun = naturalidadeMun;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.senha = senha;
        this.sexo = sexo;
        this.flagMedico = flagMedico;

    }


    public int getCodigo() {
        return idPessoa;
    }

    public void setCodigo(int codigo) {
        this.idPessoa = codigo;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getFlagMedico() {
        return flagMedico;
    }

    public void setFlagMedico(int flagMedico) {
        this.flagMedico = flagMedico;
    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public Pessoa(String login, String senha, String nome, String nomeMae, String naturalidade, String naturalidadeMun, String endereco, String dataNasc, String sexo, int flagMedico, int idPessoa) {
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.naturalidade = naturalidade;
        this.naturalidadeMun = naturalidadeMun;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.flagMedico = flagMedico;
        this.idPessoa =idPessoa;
    }

    public Pessoa(int codigo, String dataNasc, String login, String senha, String nome, String nomeMae, String naturalidade, String naturalidadeMun, String endereco, String sexo, int flagMedico) {
        this.idPessoa = codigo;
        this.dataNasc = dataNasc;
        this.login = login;
        this.senha = senha;
        this.nome = nome;
        this.nomeMae = nomeMae;
        this.naturalidade = naturalidade;
        this.naturalidadeMun = naturalidadeMun;
        this.endereco = endereco;
        this.sexo = sexo;
        this.flagMedico = flagMedico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return idPessoa == pessoa.idPessoa;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPessoa);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "idPessoa=" + idPessoa +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", nome='" + nome + '\'' +
                ", nomeMae='" + nomeMae + '\'' +
                ", naturalidade='" + naturalidade + '\'' +
                ", naturalidadeMun='" + naturalidadeMun + '\'' +
                ", endereco='" + endereco + '\'' +
                ", dataNasc='" + dataNasc + '\'' +
                ", sexo='" + sexo + '\'' +
                ", flagMedico=" + flagMedico +
                '}';
    }
}