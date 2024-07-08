public class Pergunta {
    private int nivel;
    private String pergunta;
    private String opcA;
    private String opcB;
    private String opcC;
    private String opcD;
    private String resposta;
    private int idPergunta;


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getOpcA(){
        return this.opcA;
    }
    public void setOpcA(String opcA){
        this.opcA = opcA;
    }
    public String getOpcB(){
        return this.opcB;
    }
    public void setOpcB(String opcB){
        this.opcB = opcB;
    }

    public String getOpcC(){
        return this.opcC;
    }
    public void setOpcC(String opcC){
        this.opcC = opcC;
    }
    public String getOpcD(){
        return this.opcD;
    }
    public void setOpcD(String opcB){
        this.opcD = opcD;
    }


    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public int getIdPergunta() {
        return idPergunta;
    }

    public void setIdPergunta(int idPergunta) {
        this.idPergunta = idPergunta;
    }

    public Pergunta(int nivel, String pergunta, String opcA, String opcB, String opcC, String opcD, String resposta, int idPergunta) {
        this.nivel = nivel;
        this.pergunta = pergunta;
        this.opcA = opcA;
        this.opcB = opcB;
        this.opcC = opcC;
        this.opcD = opcD;
        this.resposta = resposta;
        this.idPergunta = idPergunta;
    }




}
