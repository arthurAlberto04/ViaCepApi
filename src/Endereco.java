public class Endereco {
    private String rua;
    private String bairro;
    private String cidade;
    private String estado;

    public Endereco(EnderecoDto endereco)
    {
        this.rua = endereco.logradouro();
        this.bairro = endereco.bairro();
        this.cidade = endereco.localidade();
        this.estado = endereco.estado();
    }

    @Override
    public String toString() {
        return "Rua: %s, Bairro: %s, Cidade: %s, Estado: %s".formatted(this.rua, this.bairro, this.cidade, this.estado);
    }
}
