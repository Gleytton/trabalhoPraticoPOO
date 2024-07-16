public class ControleRemoto implements Controlador {

    private int volume;
    private boolean ligado = false;
    private boolean tocando = false;

    public ControleRemoto(int v, boolean l, boolean t){
        this.volume = v;
        this.ligado = l;
        this.tocando = t;
    }

    public int getVolume(){
        return this.volume;
    }
    public void setVolume(int v){
        this.volume = v;
    }
    public boolean getLigado(){
        return this.ligado;
    }
    public void setLigado(boolean l){
        this.ligado = l;
    }
    public boolean getTocando(){
        return this.tocando;
    }
    public void setTocando(boolean t){
        this.tocando = t;
    }

    public void ligar(){
        setLigado(true);
    }
    public void desligar(){
        setLigado(false);
    }
    public void abrirMenu(){
        System.out.println(getLigado());
        System.out.println(getVolume());
        int i;
        for(i = 0; i <= getVolume(); i +=10){
            System.out.print("|");
        }
    }
    public void fecharMenu(){
        System.out.print("Fechando menu\n");
    }
    public void maisVolume(){
        if(this.getLigado()){
            this.setVolume(this.getVolume() + 1 );
        }
    }
    public void menosVolume(){
        if(this.getLigado()){
            this.setVolume(this.getVolume() - 1);
        }
    }

    public void ligarMudo(){
        if (this.getLigado() == true && this.getVolume() > 0){

            this.setVolume(0);
        }
    }

    public void desligarMudo(){
        if(this.getLigado() == true && this.getVolume() == 0){

            this.setVolume(30);
        }
    }
    public void play() {
        if (this.getLigado() && !this.getTocando()) {
            this.setTocando(true);
        }
    }
    public void pause(){
        if(this.getLigado() && this.getTocando()){
            this.setTocando(false);
        }
    }


}

