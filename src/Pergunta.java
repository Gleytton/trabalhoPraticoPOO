import java.util.Scanner;

public class Pergunta extends Arquivos {
    private static int idPergunta = 0; // adicionar incremento na variavel quando for salvar no arquivo.
    private int nivel;
    private String pergunta;
    private String opcA;
    private String opcB;
    private String opcC;
    private String opcD;
    private String resposta;

    //Construct
    public Pergunta(int nivel, String pergunta, String opcA, String opcB, String opcC, String opcD, String resposta) {
        this.nivel = nivel;
        this.pergunta = pergunta;
        this.opcA = opcA;
        this.opcB = opcB;
        this.opcC = opcC;
        this.opcD = opcD;
        this.resposta = resposta;
    }


    //método Criar Pergunta
    public void CriarPergunta() {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Escolha o nivel da pergunta:");
        int nivel = teclado.nextInt();
        System.out.println("Digite a pergunta:");
        String pergunta = teclado.nextLine();
        System.out.println("Alternativa A: ");
        String opcA = teclado.nextLine();
        System.out.println("Alternativa B: ");
        String opcB = teclado.nextLine();
        System.out.println("Alternativa C: ");
        String opcC = teclado.nextLine();
        System.out.println("Alternativa D: ");
        String opcD = teclado.nextLine();
        System.out.println("Resposta correta: ");
        String resposta = teclado.nextLine();

        Pergunta p = new Pergunta(nivel, pergunta, opcA, opcB, opcC, opcD, resposta);
        if (perguntaJaExiste(this.pergunta)) {
            System.out.println("Pergunta já existe!");
        } else {
            salvarPergunta(p);
        }

    }

    public static int getIdPergunta() {
        return idPergunta;
    }

    public static void setIdPergunta(int idPergunta) {
        Pergunta.idPergunta = idPergunta;
    }

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

    public String getOpcA() {
        return opcA;
    }

    public void setOpcA(String opcA) {
        this.opcA = opcA;
    }

    public String getOpcB() {
        return opcB;
    }

    public void setOpcB(String opcB) {
        this.opcB = opcB;
    }

    public String getOpcC() {
        return opcC;
    }

    public void setOpcC(String opcC) {
        this.opcC = opcC;
    }

    public String getOpcD() {
        return opcD;
    }

    public void setOpcD(String opcD) {
        this.opcD = opcD;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}
