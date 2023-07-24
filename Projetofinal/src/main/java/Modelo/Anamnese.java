package Modelo;

public class Anamnese {
    String cpfPaciente;
    String exameFisico;
    String exameComplementar;
    String hipoteseDiagnostica;
    String diagnosticoDefinitivo;
    String tratamentoEfetuado;
    String data;

    @Override
    public String toString() {
        return "Anamnese{" +
                "cpfPaciente='" + cpfPaciente + '\'' +
                ", exameFisico='" + exameFisico + '\'' +
                ", exameComplementar='" + exameComplementar + '\'' +
                ", hipoteseDiagnostica='" + hipoteseDiagnostica + '\'' +
                ", diagnosticoDefinitivo='" + diagnosticoDefinitivo + '\'' +
                ", tratamentoEfetuado='" + tratamentoEfetuado + '\'' +
                ", data='" + data + '\'' +
                ", medicoResponsavel='" + medicoResponsavel + '\'' +
                ", idPessoa=" + idPessoa +
                ", idMedico=" + idMedico +
                '}';
    }

    public String getMedicoResponsavel() {
        return medicoResponsavel;
    }

    public void setMedicoResponsavel(String medicoResponsavel) {
        this.medicoResponsavel = medicoResponsavel;
    }

    String medicoResponsavel;
    int idPessoa, idMedico;

    public Anamnese(String cpfPaciente, String exameFisico, String exameComplementar, String hipoteseDiagnostica, String diagnosticoDefinitivo, String tratamentoEfetuado, int idPessoa, int idMedico) {
        this.cpfPaciente = cpfPaciente;
        this.exameFisico = exameFisico;
        this.exameComplementar = exameComplementar;
        this.hipoteseDiagnostica = hipoteseDiagnostica;
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
        this.tratamentoEfetuado = tratamentoEfetuado;
        this.idPessoa = idPessoa;
        this.idMedico = idMedico;

    }

    public int getIdPessoa() {
        return idPessoa;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public Anamnese() {
    }

    public String getCpfPaciente() {
        return cpfPaciente;
    }

    public void setCpfPaciente(String cpfPaciente) {
        this.cpfPaciente = cpfPaciente;
    }

    public String getExameFisico() {
        return exameFisico;
    }

    public void setExameFisico(String exameFisico) {
        this.exameFisico = exameFisico;
    }

    public String getExameComplementar() {
        return exameComplementar;
    }

    public void setExameComplementar(String exameComplementar) {
        this.exameComplementar = exameComplementar;
    }

    public String getHipoteseDiagnostica() {
        return hipoteseDiagnostica;
    }

    public void setHipoteseDiagnostica(String hipoteseDiagnostica) {
        this.hipoteseDiagnostica = hipoteseDiagnostica;
    }

    public String getDiagnosticoDefinitivo() {
        return diagnosticoDefinitivo;
    }

    public void setDiagnosticoDefinitivo(String diagnosticoDefinitivo) {
        this.diagnosticoDefinitivo = diagnosticoDefinitivo;
    }

    public String getTratamentoEfetuado() {
        return tratamentoEfetuado;
    }

    public void setTratamentoEfetuado(String tratamentoEfetuado) {
        this.tratamentoEfetuado = tratamentoEfetuado;
    }
}
