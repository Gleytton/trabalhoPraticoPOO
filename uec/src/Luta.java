
import java.util.Random;
import java.util.random.RandomGenerator;

public class Luta {
    private Lutador desafiado;
    private Lutador desafiante;
    private int rounds;
    private boolean aprovada;

    public Lutador getDesafiado(){
        return this.desafiado;
    }
    public void setDesafiado(Lutador desafiado){
        this.desafiado = desafiado;
    }
    public Lutador getDesafiante(){
        return this.desafiante;
    }
    public void setDesafiante(Lutador desafiante){
        this.desafiante = desafiante;
    }
    public int getRounds(){
        return this.rounds;
    }
    public void setRounds(int rounds){
        this.rounds = rounds;
    }
    public boolean getAprovada(){
        return this.aprovada;
    }
    public void setAprovada(boolean aprovada){
        this.aprovada = aprovada;
    }


    public void marcarLuta(Lutador l1,Lutador l2){

        if(l1.getCategoria().equals(l2.getCategoria()) && (l1 != l2)){
            this.setAprovada(true);
            this.desafiante = l1;
            this.desafiado = l2;
        }
        else{
            this.setAprovada(false);
            this. desafiante = null;
            this.desafiado = null;
        }
    }

    public void lutar() {

        System.out.print("Aprovada" + this.getAprovada());
        if (this.getAprovada() == true) {
            System.out.println("deu certo lutar");
            this.desafiado.apresentar();
            this.desafiante.apresentar();

            Random aleatorio = new Random();

            int vencedor = aleatorio.nextInt(3);

            switch (vencedor) {
                case (0): { // empate
                    System.out.print("Empate");
                    this.desafiado.empatarLuta();
                    this.desafiante.empatarLuta();
                    break;
                }
                case (1): {
                    System.out.print(this.desafiante.getNome() + "é o vencedor");
                    this.desafiante.ganharLuta();
                    this.desafiado.perderLuta();
                    break;

                }
                case (2): {
                    System.out.print(this.desafiado.getNome() + "é o vencedor");
                    this.desafiante.perderLuta();
                    this.desafiado.ganharLuta();
                    break;
                }

            }

        } else {
            System.out.print("A luta não pode acontecer!!!");
        }


    }

    public void statusLuta(){
        System.out.println("aprovada:" + this.getAprovada() );
    }
}






