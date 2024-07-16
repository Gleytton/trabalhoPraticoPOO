public class Conta {
    public int numConta;
    private String dono;
    protected String tipo;
    private float saldo;
    private boolean status;

    public Conta(int n, String d, String t, float sd, boolean st){
        this.numConta = n;
        this.dono = d;
        this.tipo = t; // CC- Conta corrente ; CP - Conta Poupança
        this.saldo = sd;
        this.status = st;
    }
    public int getNumConta(){
        return this.numConta;
    }
    public void setNumConta(int num){
        this.numConta = num;
    }
    public String getDono(){
        return this.dono;
    }
    public void setDono(String d){
        this.dono = d;
    }
    public String getTipo(){
        return this.tipo;
    }
    public void setTipo(String t){
        this.tipo= t;
    }
    public float getSaldo(){
        return this.saldo;
    }
    public void setSaldo(float n){
        this.saldo = n;
    }
    public boolean getStatus(){
        return this.status;
    }
    public void setStatus(boolean st){
        this.status = st;
    }
    public float depositar(float d) {
        if(this.status){
            this.saldo += d;
        }else{

            System.out.printf("Conta Invalida");
        }
        return this.saldo;
    }
    public void sacar(float s, float a) {

        if (this.saldo > 0.0 && this.status == true){
            System.out.printf("Você sacou: %.2f", a);
            System.out.printf("Saldo atual: %2.f", s - a);
            this.setSaldo(s - a);
        }
    }

    public void abrirConta(int n, String d, String t, float sd, boolean st){
        if (t == "CC") {
            Conta c = new Conta(n, d, t, 50.00F, true);
        }
        else{
            Conta c = new Conta(n,d,t,150.00F, true);
        }
    }

    public void fecharConta(){
        if(this.status == true && this.saldo == 0) {
            this.setStatus(false);
            System.out.printf(" Status da conta; FECHADO");
        }else{
            System.out.printf("Impossível realizar a operação!!!\n"+
                    "Consulte o gerente do banco");
        }
    }

}

