public interface Publicacao {

    public abstract boolean abrir();
    public abstract boolean fechar();
    public abstract void folhear(int pag);
    public abstract int avancarPag();
    public abstract int voltarPag();

}
